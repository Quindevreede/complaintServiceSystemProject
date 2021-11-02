package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.payload.request.AddressRequest;
import nl.quin.complaintservicesystem.payload.request.CustomerDetailsRequest;
import nl.quin.complaintservicesystem.payload.response.ErrorResponse;
import nl.quin.complaintservicesystem.payload.response.PersonResponse;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements nl.quin.complaintservicesystem.service.CustomerDetailsService {

    private CustomerDetailsRepository customerDetailsRepository;
    private CustomerComplaintRepository customerComplaintRepository;

    @Autowired
    public void setCustomerDetailsRepositoryRepository(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Autowired
    public void setCustomerComplaintRepository(CustomerComplaintRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public ResponseEntity<?> printCustomerDetails(CustomerDetailsRequest customerDetailsRequest) {
        return ResponseEntity.ok(CustomerDetailsRequest);
    }

    @Override
    public ResponseEntity<?> registerWithoutAddress(CustomerDetailsRequest customerDetailsRequest) {

        CustomerDetails customerDetails = new CustomerDetails();
        ErrorResponse errorResponse = new ErrorResponse();

        if(customerDetailsRequest.getFirstName() != null && !customerDetailsRequest.getFirstName().equals("")) {
            customerDetails.setFirstName(customerDetailsRequest.getFirstName());
        }

        if(customerDetailsRequest.getLastName() != null && !customerDetailsRequest.getLastName().equals("")) {
            customerDetails.setLastName(customerDetailsRequest.getLastName());
        }

        if(!customerDetailsRequest.getPassword().equals(customerDetailsRequest.getRepeatedPassword())) {
            errorResponse.addError("repeatedPassword", "The passwords do not match eachother.");
        }
        if(customerDetailsRepository.existsByUsername(customerDetailsRequest.getUsername())) {
            errorResponse.addError("username", "The username already exists.");
        }
        if(customerDetailsRepository.existsByEmail(customerDetailsRequest.getEmail())) {
            errorResponse.addError("email", "The email is already in use.");
        }

        customerDetails.setEmail(customerDetailsRequest.getEmail());
        customerDetails.setUsername(customerDetailsRequest.getUsername());
        customerDetails.setPassword(customerDetailsRequest.getPassword());

        if(errorResponse.hasErrors()) {
            return ResponseEntity.status(400).body(errorResponse);
        }

        CustomerDetails savedCustomerDetails = customerDetailsRepository.save(customerDetails);

        return ResponseEntity.ok(createResponseObject(savedCustomerDetails));
    }

    @Override
    public ResponseEntity<?> addCustomerComplaintToUserById(long id, CustomerComplaintRequest customerComplaintRequest) {


        Optional<CustomerDetails> optionalCustomerDetails = customerDetailsRepository.findById(id);

        if(optionalCustomerDetails.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.addError("id", "The user with id (" + id + ") does not exist.");
            return ResponseEntity.status(400).body(errorResponse);
        }

        CustomerDetails customerDetailsWithCustomerComplaint = optionalCustomerDetails.get();
        CustomerComplaint customerComplaint = new CustomerComplaint();
        customerComplaint.setPostalCode(customerComplaintRequest.getPostalCode());
        customerComplaint.setHouseNumber(customerComplaintRequest.getHouseNumber());
        customerComplaint.setStreetName(customerComplaintRequest.getStreetName());
        if(customerComplaintRequest.getAddition() != null && !customerComplaintRequest.getAddition().equals("")) {
            customerComplaint.setAddition(customerComplaintRequest.getAddition());
        }
        customerComplaint.setCustomerDetails(customerDetailsWithCustomerComplaint);

        customerComplaintRepository.save(customerComplaint);

        customerDetailsWithCustomerComplaint.setCustomerComplaint(customerComplaint);

        return ResponseEntity.ok(createResponseObject(customerDetailsWithCustomerComplaint));
    }

    @Override
    public ResponseEntity<?> getCustomerDetailsInfoById(long id) {
        ErrorResponse errorResponse = new ErrorResponse();
        Optional<CustomerDetails> optionalCustomerDetails = customerDetailsRepository.findById(id);

        if(optionalCustomerDetails.isEmpty()) {
            errorResponse.addError("id", "The customer with id (" + id + ") does not exist.");
            return ResponseEntity.status(400).body(errorResponse);
        }

        CustomerDetails customerDetails = optionalCustomerDetails.get();

        CustomerDetailsResponse customerDetailsResponse = createResponseObject(customerDetails);

        return ResponseEntity.ok(customerDetailsResponse);
    }

    private CustomerDetailsResponse createResponseObject(CustomerDetails customerDetails) {
        CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse(customerDetails.getId(),
                customerDetails.getUsername(), customerDetails.getEmail());

        if(customerDetails.getFirstName() != null && !customerDetails.getFirstName().equals("")) {
            customerDetailsResponse.setFirstName(customerDetails.getFirstName());
        }
        if(customerDetails.getLastName() != null && !customerDetails.getLastName().equals("")) {
            customerDetailsResponse.setLastName(customerDetails.getLastName());
        }

        if(customerDetails.getCustomerComplaint() != null) {
            CustomerComplaint customerComplaint = customerDetails.getCustomerComplaint();
            customerDetailsResponse.setCustomerComplaint(customerComplaint.getPostalCode(), customerComplaint.getStreetName(), customerComplaint.getHouseNumber());
            if(customerComplaint.getAddition()!= null && !customerComplaint.getAddition().equals("")) {
                customerDetailsResponse.setAddition(customerComplaint.getAddition());
            }
        }
        return customerDetailsResponse;
    }
}
