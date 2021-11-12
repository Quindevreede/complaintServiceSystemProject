package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.model.ProductionComplaint;
import nl.quin.complaintservicesystem.service.AssistComplaintService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface AssistComplaintRepository extends JpaRepository<AssistComplaint, Long> {

    AssistComplaint findByOrderNumber(String orderNumber);
    AssistComplaint findByAssistCommentary(String assistCommentary);

}