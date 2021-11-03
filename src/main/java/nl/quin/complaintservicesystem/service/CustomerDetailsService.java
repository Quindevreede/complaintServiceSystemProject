package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.payload.request.CustomerComplaintRequest;
import nl.quin.complaintservicesystem.payload.request.CustomerDetailsRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerDetailsService {

    ResponseEntity<?> printCustomerDetails(CustomerDetailsRequest customerDetailsRequest);
    ResponseEntity<?> registerWithoutCustomerComplaint(CustomerDetailsRequest customerDetailsRequest);
    ResponseEntity<?> addCustomerComplaintToCustomerDetailsById(long id, CustomerComplaintRequest customerComplaintRequest);
    ResponseEntity<?> getCustomerDetailsInfoById(long id);
}
