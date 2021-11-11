package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


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
        } else {
            return customerDetailsRepository.findAllByLastName(name);
        }
    }

    public CustomerDetails getCustomerById(long id) {
        if (!customerDetailsRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        return customerDetailsRepository.findById(id).orElse(null);
    }

    public long createCustomer(CustomerDetails customerDetails) {
        if(customerDetailsRepository.existsByEmail(customerDetails.getEmail())) {
            throw new RuntimeException("The email is already in use.");
        }

        customerDetails.setUsername(username.getCurrentUserName()); //TODO if no currentUserName? kan deze in uiteindelijke???
        CustomerDetails storedCustomerDetails = customerDetailsRepository.save(customerDetails); //TODO hierna: autowired User user, haal op User die hoort bij username, user.setcustomerdetails.  User user =userRepository.save(user);

        return storedCustomerDetails.getId();
    }

    public void updateCustomer(long id, CustomerDetails customerDetails) {
//        ErrorResponse errorResponse = new ErrorResponse();

        if (!customerDetailsRepository.existsById(id)) {
            throw new UserNotFoundException();
        }

        if(customerDetailsRepository.existsByEmail(customerDetails.getEmail())) {
            throw new RuntimeException("The email is already in use.");        }

        CustomerDetails storedCustomerDetails = customerDetailsRepository.findById(id).orElse(null);
        storedCustomerDetails.setUsername(username.getCurrentUserName());
        storedCustomerDetails.setFirstName(customerDetails.getFirstName());
        storedCustomerDetails.setLastName(customerDetails.getLastName());
        storedCustomerDetails.setEmail(customerDetails.getEmail());
        customerDetailsRepository.save(customerDetails);
    }

        public void deleteCustomer ( long id){
            if (!customerDetailsRepository.existsById(id)) {
                throw new UserNotFoundException();
            }
            customerDetailsRepository.deleteById(id);
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