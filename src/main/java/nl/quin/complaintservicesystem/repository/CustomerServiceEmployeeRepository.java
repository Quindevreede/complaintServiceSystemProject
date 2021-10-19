package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerServiceEmployee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerServiceEmployeeRepository extends JpaRepository<CustomerServiceEmployee, Long> {
    Collection<CustomerServiceEmployee> findAllByLastName(String last_name);
}
