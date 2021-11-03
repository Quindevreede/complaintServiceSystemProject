package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}