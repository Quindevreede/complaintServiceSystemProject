package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<Employee> findAllByLastName(String last_name);
}