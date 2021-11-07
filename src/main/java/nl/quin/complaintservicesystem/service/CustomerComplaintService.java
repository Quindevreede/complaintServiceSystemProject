package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CustomerComplaintService {

    @Autowired
    CustomerComplaintRepository customerComplaintRepository;

    @Autowired
    UserService username;

    public Collection<CustomerComplaint> getAllCustomerComplaints() {
        return customerComplaintRepository.findAll();
    }

    public Collection<CustomerComplaint> getCustomerComplaint(String name) {
        if (name.isEmpty()) {
            return customerComplaintRepository.findAll();
        }
        else {
            return customerComplaintRepository.findAllByOrderNumber(name);
        }
    }

    public CustomerComplaint getCustomerComplaintById(long id) {
        if (!customerComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerComplaintRepository.findById(id).orElse(null);
    }

    public long createCustomerComplaint (CustomerComplaint customerComplaint) {
        customerComplaint.setUsername(username.getCurrentUserName()); //TODO if no currentUserName? kan deze in uiteindelijke???
        CustomerComplaint storedCustomerComplaint = customerComplaintRepository.save(customerComplaint);
        return storedCustomerComplaint.getId();
    }

    public void updateCustomerComplaint(long id, CustomerComplaint customerComplaint) {
        if (!customerComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerComplaint storedCustomerComplaint = customerComplaintRepository.findById(id).orElse(null);
        storedCustomerComplaint.setUsername(username.getCurrentUserName());
        storedCustomerComplaint.setOrderNumber(customerComplaint.getOrderNumber());
        storedCustomerComplaint.setCustomerCommentary(customerComplaint.getCustomerCommentary());
        customerComplaintRepository.save(customerComplaint);
    }

    public void partialUpdateCustomerComplaint(long id, Map<String, String> fields) {
        if (!customerComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerComplaint storedCustomerComplaint = customerComplaintRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "order_number":
                    storedCustomerComplaint.setOrderNumber((String) fields.get(field));
                    break;
                case "customer_commentary":
                    storedCustomerComplaint.setCustomerCommentary((String) fields.get(field));
                    break;
            }
        }
        customerComplaintRepository.save(storedCustomerComplaint);
    }

    public void deleteCustomerComplaint(long id) {
        if (!customerComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerComplaintRepository.deleteById(id);
    }

}

/*//TODO//TODO//TODO

    public void save(CustomerComplaint customerComplaint) {
        customerComplaintRepository.save(customerComplaint);
    }

 */

