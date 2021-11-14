package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Collection<CustomerDetails> getAllCustomers() {
        return customerDetailsRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
        if(!customerDetails.getEmail().contains("@")) {
            throw new RuntimeException("Not a valid email address.");
        }
        if(!customerDetails.getEmail().contains(".")) {
            throw new RuntimeException("Not a valid email address.");
        }
        customerDetails.setUsername(username.getCurrentUserName());
        CustomerDetails storedCustomerDetails = customerDetailsRepository.save(customerDetails);

        return storedCustomerDetails.getId();
    }

    public void updateCustomer(long id, CustomerDetails customerDetails) {
        if (!customerDetailsRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        if(!customerDetails.getEmail().contains("@")) {
            throw new RuntimeException("Not a valid email address.");
        }
        if(!customerDetails.getEmail().contains(".")) {
            throw new RuntimeException("Not a valid email address.");
        }
        CustomerDetails storedCustomerDetails = customerDetailsRepository.findById(id).orElse(null);
        storedCustomerDetails.setUsername(username.getCurrentUserName());
        storedCustomerDetails.setFirstName(customerDetails.getFirstName());
        storedCustomerDetails.setLastName(customerDetails.getLastName());
        storedCustomerDetails.setEmail(customerDetails.getEmail());
        customerDetailsRepository.save(customerDetails);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCustomer ( long id){
        if (!customerDetailsRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        customerDetailsRepository.deleteById(id);
    }

}