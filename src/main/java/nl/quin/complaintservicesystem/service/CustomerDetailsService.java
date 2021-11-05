package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.payload.request.CustomerComplaintRequest;
import nl.quin.complaintservicesystem.payload.request.CustomerDetailsRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerDetailsService {

    //List<CustomerDetails> getCustomerDetails();

    ResponseEntity<?> printCustomerDetails(CustomerDetailsRequest customerDetailsRequest);

    ResponseEntity<?> registerWithoutCustomerComplaint(CustomerDetailsRequest customerDetailsRequest);

    ResponseEntity<?> addCustomerComplaintToCustomerDetailsById(long id, CustomerComplaintRequest customerComplaintRequest);

    ResponseEntity<?> getCustomerDetailsInfoById(long id);

    void addUserToCustomerDetailsById(Long customerDetailsId, String username);
}