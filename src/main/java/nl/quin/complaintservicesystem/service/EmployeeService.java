package nl.quin.complaintservicesystem.service;


import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.Employee;
import nl.quin.complaintservicesystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Collection<Employee> getEmployees(String name) {
        if (name.isEmpty()) {
            return employeeRepository.findAll();
        }
        else {
            return employeeRepository.findAllByLastName(name);
        }
    }

    public Employee getEmployeeById(long id) {
        if (!employeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        return employeeRepository.findById(id).orElse(null);
    }

    public long createEmployee (Employee employee) {
        Employee storedEmployee  = employeeRepository.save(employee);
        return storedEmployee .getId();
    }

    public void updateEmployee(long id, Employee employee) {
        if (!employeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        Employee storedEmployee = employeeRepository.findById(id).orElse(null);
        storedEmployee.setFirstName(employee.getFirstName());
        storedEmployee.setLastName(employee.getLastName());
        storedEmployee.setEmail(employee.getEmail());
        storedEmployee.setOrderNr(employee.getOrderNr());
        employeeRepository.save(employee);
    }

    public void partialUpdateEmployee(long id, Map<String, String> fields) {
        if (!employeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        Employee storedEmployee = employeeRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "first_name":
                    storedEmployee.setFirstName((String) fields.get(field));
                    break;
                case "last_name":
                    storedEmployee.setLastName((String) fields.get(field));
                    break;
                case "email":
                    storedEmployee.setEmail((String) fields.get(field));
                case "order_nr":
                    storedEmployee.setOrderNr((String) fields.get(field));
                    break;

            }
        }
        employeeRepository.save(storedEmployee);
    }

    public void deleteEmployee(long id) {
        if (!employeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        employeeRepository.deleteById(id);
    }

}