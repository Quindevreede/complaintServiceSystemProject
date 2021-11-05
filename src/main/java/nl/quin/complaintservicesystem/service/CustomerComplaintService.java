package nl.quin.complaintservicesystem.service;
import nl.quin.complaintservicesystem.model.CustomerComplaint;

import java.util.List;

    public interface CustomerComplaintService {
        List<CustomerComplaint> getCustomerComplaints();

        CustomerComplaint getCustomerComplaint(Long id);


}


