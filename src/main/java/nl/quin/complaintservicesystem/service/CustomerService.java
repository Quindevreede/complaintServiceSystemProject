package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.Customer;
import nl.quin.complaintservicesystem.repository.ComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerComplaintResultRepository;
import nl.quin.complaintservicesystem.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    CustomerComplaintResultRepository customerComplaintResultRepository;

    @Autowired
    UserService userService;

    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Collection<Customer> getCustomers(String name) {
        if (name.isEmpty()) {
            return customerRepository.findAll();
        }
        else {
            return customerRepository.findAllByLastName(name);
        }
    }

    public Customer getCustomerById(long id) {
        if (!customerRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerRepository.findById(id).orElse(null);
    }

    public long createCustomer (Customer customer) {
        customer.setUsername(userService.getCurrentUserName()); //TODO if no currentUserName?
        Customer  storedCustomer  = customerRepository.save(customer);
        return storedCustomer .getId();
    }

    public void updateCustomer(long id, Customer customer) {
        if (!customerRepository.existsById(id)) { throw new UserNotFoundException(); }
        Customer storedCustomer = customerRepository.findById(id).orElse(null);
        storedCustomer.setOrderNumberCustomer(customer.getOrderNumberCustomer());
        storedCustomer.setFirstName(customer.getFirstName());
        storedCustomer.setLastName(customer.getLastName());
        storedCustomer.setEmail(customer.getEmail());
        storedCustomer.setCustomerCommentary((customer.getCustomerCommentary()));
        customerRepository.save(customer);
    }

    public void partialUpdateCustomer(long id, Map<String, String> fields) {
        if (!customerRepository.existsById(id)) { throw new UserNotFoundException(); }
        Customer storedCustomer = customerRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "order_number_customer":
                    storedCustomer.setOrderNumberCustomer((String) fields.get(field));
                    break;
                case "first_name":
                    storedCustomer.setFirstName((String) fields.get(field));
                    break;
                case "last_name":
                    storedCustomer.setLastName((String) fields.get(field));
                    break;
                case "email":
                    storedCustomer.setEmail((String) fields.get(field));
                case "customer_commentary":
                    storedCustomer.setCustomerCommentary((String) fields.get(field));
                    break;
            }
        }
        customerRepository.save(storedCustomer);
    }

    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerRepository.deleteById(id);
    }

}