package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerComplaintRepository extends JpaRepository<CustomerComplaint, Long> {
    Collection<CustomerComplaint> findAllByOrderNumber(String orderNumber);
}
