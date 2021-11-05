package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerComplaintServiceImpl implements CustomerComplaintService {
private CustomerComplaintRepository repository;

@Autowired
    public CustomerComplaintServiceImpl(CustomerComplaintRepository repository) {
    this.repository = repository;
}

    @Override
    public List<CustomerComplaint> getCustomerComplaints() {
        return repository.findAll();
    }

    @Override
    public CustomerComplaint getCustomerComplaint(Long id) {
        return repository.getById(id);
    }

}


