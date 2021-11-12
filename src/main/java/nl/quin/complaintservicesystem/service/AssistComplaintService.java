package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.repository.AssistComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


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

        public void updateAssistComplaintPartial(long id, Map<String, String> fields) {
            if (!assistComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
            AssistComplaint storedAssistComplaint = assistComplaintRepository.findById(id).orElse(null);
            for (String field : fields.keySet()) {
                switch (field) {
                    case "assisted_by":
                        storedAssistComplaint.setAssistedBy((String) fields.get(field));
                        break;
                    case "assist_department":
                        storedAssistComplaint.setAssistDepartment((String) fields.get(field));
                        break;
                    case "assist_commentary":
                        storedAssistComplaint.setAssistCommentary((String) fields.get(field));
                        break;
                }
            }

            assistComplaintRepository.save(storedAssistComplaint);
        }

        public void deleteAssistComplaint(long id) {
            if (!assistComplaintRepository.existsById(id)) { throw new UserNotFoundException(); }
            assistComplaintRepository.deleteById(id);
        }

    }
