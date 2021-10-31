package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);

}
