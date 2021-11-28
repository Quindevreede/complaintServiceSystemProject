package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.repository.AssistComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AssistComplaintService {

    @Autowired
    AssistComplaintRepository assistComplaintRepository;

    public AssistComplaint getAssistComplaintById(long id) {
        Optional<AssistComplaint> assistComplaint = assistComplaintRepository.findById(id);
        if (assistComplaint.isPresent()) {
            return assistComplaint.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    public long createAssistComplaint (AssistComplaint assistComplaint) {
        assistComplaint.setInvoiceLink("http://localhost:666/receipt_upload/files/" + assistComplaint.getInvoiceLink() + "/download");
        AssistComplaint storedAssistComplaint = assistComplaintRepository.save(assistComplaint);
        return storedAssistComplaint.getId();
    }

    public void updateAssistComplaint(long id, AssistComplaint assistComplaint) {
        if (!assistComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        AssistComplaint storedAssistComplaint = assistComplaintRepository.findById(id).orElse(null);
        storedAssistComplaint.setAssistedBy(assistComplaint.getAssistedBy());
        storedAssistComplaint.setAssistDepartment(assistComplaint.getAssistDepartment());
        storedAssistComplaint.setAssistCommentary(assistComplaint.getAssistCommentary());
        assistComplaintRepository.save(assistComplaint);
    }

    public void deleteAssistComplaint(long id) {
        Optional<AssistComplaint> assistComplaint = assistComplaintRepository.findById(id);
        if (assistComplaint.isPresent()) {
            assistComplaintRepository.deleteById(id);
        } else {
            throw new UserNotFoundException();
        }
    }

}