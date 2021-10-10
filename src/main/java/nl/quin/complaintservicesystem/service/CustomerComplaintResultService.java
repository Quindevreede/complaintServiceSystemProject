package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.model.Complaint;
import nl.quin.complaintservicesystem.model.Customer;
import nl.quin.complaintservicesystem.model.CustomerComplaintResult;
import nl.quin.complaintservicesystem.model.CustomerComplaintResultKey;
import nl.quin.complaintservicesystem.repository.ComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerComplaintResultRepository;
import nl.quin.complaintservicesystem.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerComplaintResultService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerComplaintResultRepository customerComplaintResultRepository;

    public Collection<CustomerComplaintResult> getAllResults() {
        Collection<CustomerComplaintResult> results = customerComplaintResultRepository.findAll();
        return results;
    }

    public Collection<CustomerComplaintResult> getResultsByCustomerId(long customerId) {
        return customerComplaintResultRepository.findAllByCustomerId(customerId);
    }

    public Collection<CustomerComplaintResult> getResultsByComplaintId(long complaintId) {
        return customerComplaintResultRepository.findAllByComplaintId(complaintId);
    }

    public CustomerComplaintResult getResultById(long customerId, long complaintId) {
        return customerComplaintResultRepository.findById(new CustomerComplaintResultKey(customerId, complaintId)).orElse(null);
    }

    public CustomerComplaintResultKey addResult(long customerId, long complaintId, CustomerComplaintResult result) {
        if (!customerRepository.existsById(customerId)) { throw new RecordNotFoundException(); }
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (!complaintRepository.existsById(complaintId)) { throw new RecordNotFoundException(); }
        Complaint complaint = complaintRepository.findById(complaintId).orElse(null);
        result.setCustomer(customer);
        result.setComplaint(complaint);
        CustomerComplaintResultKey id = new CustomerComplaintResultKey(customerId, complaintId);
        result.setId(id);
        customerComplaintResultRepository.save(result);
        return id;
    }

    public void updateResult(long customerId, long complaintId, CustomerComplaintResult result) {
        CustomerComplaintResultKey id = new CustomerComplaintResultKey(customerId, complaintId);
        if (!customerComplaintResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        CustomerComplaintResult existingResult = customerComplaintResultRepository.findById(id).orElse(null);
        existingResult.setDate(result.getDate());
       // existingResult.setScore(result.getScore());
        customerComplaintResultRepository.save(existingResult);
    }

    public void partialUpdateResult(long customerId, long complaintId, CustomerComplaintResult result) {
        CustomerComplaintResultKey id = new CustomerComplaintResultKey(customerId, complaintId);
        if (!customerComplaintResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        CustomerComplaintResult existingResult = customerComplaintResultRepository.findById(id).orElse(null);
        if (result.getDate() != null) {
            existingResult.setDate(result.getDate());
        }
      /*  if (result.getScore() != null) {
            existingResult.setScore(result.getScore());
        }

       */
        customerComplaintResultRepository.save(existingResult);
    }

    public void deleteResult(long customerId, long complaintId) {
        CustomerComplaintResultKey id = new CustomerComplaintResultKey(customerId, complaintId);
        if (!customerComplaintResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        customerComplaintResultRepository.deleteById(id);
    }

}


