package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.Complaint;
import nl.quin.complaintservicesystem.repository.ComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerComplaintResultRepository;
import nl.quin.complaintservicesystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    CustomerRepository customerRespository;

    @Autowired
    CustomerComplaintResultRepository customerComplaintResultRepository;

    public Collection<Complaint> getAllCourses() {
        return complaintRepository.findAll();
    }

    public Collection<Complaint> getComplaints(String name) {
        if (name.isEmpty()) {
            return complaintRepository.findAll();
        }
        else {
            return complaintRepository.findAllByName(name);
        }
    }

    public Complaint getComplaintById(long id) {
        if (!complaintRepository.existsById(id)) { throw new RecordNotFoundException(); }
        return complaintRepository.findById(id).orElse(null);
    }

    public long createComplaint(Complaint complaint) {
        Complaint storedComplaint = complaintRepository.save(complaint);
        return storedComplaint.getId();
    }

    public void updateComplaint(long id, Complaint complaint) {
        if (!complaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        Complaint storedComplaint = complaintRepository.findById(id).orElse(null);
        storedComplaint.setCode(complaint.getCode());
        storedComplaint.setName(complaint.getName());
        storedComplaint.setCommentary(complaint.getCommentary());
        storedComplaint.setOrderNrCustomer((complaint.getOrderNrCustomer()));
        complaintRepository.save(complaint);
    }

    public void partialUpdateComplaint(long id, Map<String, String> fields) {
        if (!complaintRepository.existsById(id)) { throw new UserNotFoundException(); }
        Complaint storedComplaint = complaintRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "code":
                    storedComplaint.setCode((String) fields.get(field));
                    break;
                case "name":
                    storedComplaint.setName((String) fields.get(field));
                    break;
                case "badPrintCommentary":
                    storedComplaint.setCommentary((String) fields.get(field));
                    break;
                case "orderNrCustomer":
                    storedComplaint.setOrderNrCustomer((String) fields.get(field));
                    break;

            }
        }
        complaintRepository.save(storedComplaint);
    }



    public void deleteComplaint(long id) {
        if (!complaintRepository.existsById(id)) { throw new RecordNotFoundException(); }
        complaintRepository.deleteById(id);
    }

}