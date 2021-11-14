package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.repository.AssistComplaintRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AssistComplaintService {

    @Autowired
    AssistComplaintRepository assistComplaintRepository;

    @Autowired
    UserService username;

    @Autowired
    CustomerComplaintService getOrderNumber;

    public Collection<AssistComplaint> getAllAssistComplaints() {
        return assistComplaintRepository.findAll();
    }

    public AssistComplaint getAssistComplaintById(long id) {
        if (!assistComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        return assistComplaintRepository.findById(id).orElse(null);
    }

    public long createAssistComplaint (AssistComplaint assistComplaint) {
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
        if (!assistComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        assistComplaintRepository.deleteById(id);
    }

}