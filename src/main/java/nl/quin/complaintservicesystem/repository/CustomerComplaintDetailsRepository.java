package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerComplaintDetails;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerComplaintDetailsRepository extends JpaRepository<CustomerComplaintDetails, Long> {
    Collection<CustomerComplaintDetails> findAllByLastName(String last_name);
}

