package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.AssistComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistComplaintRepository extends JpaRepository<AssistComplaint, Long> {

}