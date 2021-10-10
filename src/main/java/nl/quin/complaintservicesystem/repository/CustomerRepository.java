package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Collection<Customer> findAllByLastName(String last_name);
}

