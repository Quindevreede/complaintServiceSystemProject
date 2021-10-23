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

    public Collection<CustomerServiceEmployee> getAllCustomerServiceEmployee() {
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
        storedCustomerServiceEmployee.setPosition(customerServiceEmployee.getPosition());
        storedCustomerServiceEmployee.setCompanyPhoneNumber(customerServiceEmployee.getCompanyPhoneNumber());
        customerServiceEmployeeRepository.save(customerServiceEmployee);
    }

    public void partialUpdateCustomerServiceEmployee(long id, Map<String, String> fields) {
        if (!customerServiceEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerServiceEmployee storedCustomerServiceEmployee = customerServiceEmployeeRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "last_name":
                    storedCustomerServiceEmployee.setLastName((String) fields.get(field));
                    break;
                case "position":
                    storedCustomerServiceEmployee.setPosition((String) fields.get(field));
                    break;
                case "company_phone_number":
                    storedCustomerServiceEmployee.setCompanyPhoneNumber((String) fields.get(field));
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
