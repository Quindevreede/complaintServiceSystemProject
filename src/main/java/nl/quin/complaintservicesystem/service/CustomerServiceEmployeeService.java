package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;

import nl.quin.complaintservicesystem.model.CustomerServiceEmployee;
import nl.quin.complaintservicesystem.repository.CustomerServiceEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class CustomerServiceEmployeeService {

    @Autowired
    CustomerServiceEmployeeRepository customerServiceEmployeeRepository;

    public Collection<CustomerServiceEmployee> getAllCustomerServiceEmployees() {
        return customerServiceEmployeeRepository.findAll();
    }

    public Collection<CustomerServiceEmployee> getCustomerServiceEmployees(String name) {
        if (name.isEmpty()) {
            return customerServiceEmployeeRepository.findAll();
        }
        else {
            return customerServiceEmployeeRepository.findAllByLastName(name);
        }
    }

    public CustomerServiceEmployee getCustomerServiceEmployeeById(long id) {
        if (!customerServiceEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerServiceEmployeeRepository.findById(id).orElse(null);
    }

    public long createCustomerServiceEmployee (CustomerServiceEmployee customerServiceEmployee) {
        CustomerServiceEmployee storedCustomerServiceEmployee  = customerServiceEmployeeRepository.save(customerServiceEmployee);
        return storedCustomerServiceEmployee.getId();
    }

    public void updateCustomerServiceEmployee(long id, CustomerServiceEmployee customerServiceEmployee) {
        if (!customerServiceEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerServiceEmployee storedCustomerServiceEmployee = customerServiceEmployeeRepository.findById(id).orElse(null);
        storedCustomerServiceEmployee.setFirstName(customerServiceEmployee.getFirstName());
        storedCustomerServiceEmployee.setLastName(customerServiceEmployee.getLastName());
        storedCustomerServiceEmployee.setEmail(customerServiceEmployee.getEmail());
        storedCustomerServiceEmployee.setOrderNr(customerServiceEmployee.getOrderNr());
        storedCustomerServiceEmployee.setCustomerServiceCommentary((customerServiceEmployee.getCustomerServiceCommentary()));
        customerServiceEmployeeRepository.save(customerServiceEmployee);
    }

    public void partialUpdateCustomerServiceEmployee(long id, Map<String, String> fields) {
        if (!customerServiceEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerServiceEmployee storedCustomerServiceEmployee = customerServiceEmployeeRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "first_name":
                    storedCustomerServiceEmployee.setFirstName((String) fields.get(field));
                    break;
                case "last_name":
                    storedCustomerServiceEmployee.setLastName((String) fields.get(field));
                    break;
                case "email":
                    storedCustomerServiceEmployee.setEmail((String) fields.get(field));
                case "order_nr":
                    storedCustomerServiceEmployee.setOrderNr((String) fields.get(field));
                    break;
                case "customerService_commentary":
                    storedCustomerServiceEmployee.setCustomerServiceCommentary((String) fields.get(field));
                    break;
            }
        }
        customerServiceEmployeeRepository.save(storedCustomerServiceEmployee);
    }

    public void deleteCustomerServiceEmployee(long id) {
        if (!customerServiceEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerServiceEmployeeRepository.deleteById(id);
    }

}
