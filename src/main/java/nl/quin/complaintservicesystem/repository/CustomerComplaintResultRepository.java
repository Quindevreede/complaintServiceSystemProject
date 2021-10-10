package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerComplaintResult;
import nl.quin.complaintservicesystem.model.CustomerComplaintResultKey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerComplaintResultRepository extends JpaRepository<CustomerComplaintResult, CustomerComplaintResultKey> {
    Collection<CustomerComplaintResult> findAllByCustomerId(long customerId);
    Collection<CustomerComplaintResult> findAllByComplaintId(long complaintId);
}
