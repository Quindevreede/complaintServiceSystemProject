package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.model.Speler;
import nl.quin.complaintservicesystem.model.Team;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;


@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    UserService username;

    @Autowired
    CustomerComplaintRepository customerComplaintRepository;

    public Collection<CustomerDetails> getAllCustomers() {
        return customerDetailsRepository.findAll();
    }

    public Collection<CustomerDetails> getCustomers(String name) {
        if (name.isEmpty()) {
            return customerDetailsRepository.findAll();
        }
        else {
            return customerDetailsRepository.findAllByLastName(name);
        }
    }

    public CustomerDetails getCustomerById(long id) {
        if (!customerDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerDetailsRepository.findById(id).orElse(null);
    }

    public long createCustomer (CustomerDetails customerDetails) {
        customerDetails.setUsername(username.getCurrentUserName()); //TODO if no currentUserName? kan deze in uiteindelijke???
        CustomerDetails storedCustomerDetails = customerDetailsRepository.save(customerDetails);
        return storedCustomerDetails.getId();
    }

    public void updateCustomer(long id, CustomerDetails customerDetails) {
        if (!customerDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerDetails storedCustomerDetails = customerDetailsRepository.findById(id).orElse(null);
        storedCustomerDetails.setUsername(username.getCurrentUserName());
        storedCustomerDetails.setFirstName(customerDetails.getFirstName());
        storedCustomerDetails.setLastName(customerDetails.getLastName());
        storedCustomerDetails.setEmail(customerDetails.getEmail());
        customerDetailsRepository.save(customerDetails);
    }

    public void partialUpdateCustomer(long id, Map<String, String> fields) {
        if (!customerDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerDetails storedCustomerDetails = customerDetailsRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "firstName":
                    storedCustomerDetails.setFirstName((String) fields.get(field));
                    customerDetailsRepository.save(storedCustomerDetails);
                    break;
                case "lastName":
                    storedCustomerDetails.setLastName((String) fields.get(field));
                    break;
                case "email":
                    storedCustomerDetails.setEmail((String) fields.get(field));
                    break;
            }
        }
        customerDetailsRepository.save(storedCustomerDetails);
    }

    public void deleteCustomer(long id) {
        if (!customerDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerDetailsRepository.deleteById(id);
    }

    public Iterable<CustomerComplaint> getCustomerDetailsCustomerComplaint(long id) {
        Optional<CustomerDetails> customerDetails = customerDetailsRepository.findById(id);
        if (customerDetails.isPresent()) {
            return customerDetails.get().getCustomerComplaints();
        }
        else {
            throw new RecordNotFoundException("Team with id " + id + " not found");
        }
    }



}

/* //TODO//TODO//TODO
     public Iterable<CustomerComplaint> getCustomerDetailsCustomerComplaint(long id) {
        Optional<CustomerDetails> customerDetails = customerDetailsRepository.findById(id);
        if (customerDetails.isPresent()) {
            return customerDetails.get().getCustomerComplaint();
        }
        else {
            throw new RecordNotFoundException("Team with id " + id + " not found");
        }
    }
 */