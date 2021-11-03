package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerComplaintRepository extends JpaRepository<CustomerComplaint, Long> {
}
