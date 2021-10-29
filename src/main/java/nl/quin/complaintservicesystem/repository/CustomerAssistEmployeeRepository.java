package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerAssistEmployee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerAssistEmployeeRepository extends JpaRepository<CustomerAssistEmployee, Long> {
    Collection<CustomerAssistEmployee> findAllByLastName(String last_name);
}