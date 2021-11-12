package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class CustomerComplaintService {

    @Autowired
    CustomerComplaintRepository customerComplaintRepository;

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    ProductionComplaintRepository productionComplaintRepository;

    @Autowired
    AssistComplaintRepository assistComplaintRepository;

    @Autowired
    UploadRepository uploadRepository;

    @Autowired
    UserService username;

    public Collection<CustomerComplaint> getAllCustomerComplaints() {
        return customerComplaintRepository.findAll();
    }

    public Collection<CustomerComplaint> getCustomerComplaint(String name) {
        if (name.isEmpty()) {
            return customerComplaintRepository.findAll();
        } else {
            return customerComplaintRepository.findAllByOrderNumber(name);
        }
    }

    public CustomerComplaint getCustomerComplaintById(long id) {
        if (!customerComplaintRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        return customerComplaintRepository.findById(id).orElse(null);
    }

    public long createCustomerComplaint(CustomerComplaint customerComplaint) {
        customerComplaint.setUsername(username.getCurrentUserName()); //TODO if no currentUserName? kan deze in uiteindelijke???
        if (customerComplaintRepository.existsByOrderNumber(customerComplaint.getOrderNumber())) {
            throw new RuntimeException("The ordernumber is already in use.");
        }
        CustomerComplaint storedCustomerComplaint = customerComplaintRepository.save(customerComplaint);

        return storedCustomerComplaint.getId();
    }

    public void updateCustomerComplaint(long id, CustomerComplaint customerComplaint) {
        if (!customerComplaintRepository.existsById(id)) {
            throw new UserNotFoundException();
        }

        CustomerComplaint storedCustomerComplaint = customerComplaintRepository.findById(id).orElse(null);
        storedCustomerComplaint.setUsername(username.getCurrentUserName());
        storedCustomerComplaint.setOrderNumber(customerComplaint.getOrderNumber());
        storedCustomerComplaint.setCustomerCommentary(customerComplaint.getCustomerCommentary());
        customerComplaintRepository.save(customerComplaint);
    }

    public void partialUpdateCustomerComplaint(long id, Map<String, String> fields) {
        if (!customerComplaintRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        CustomerComplaint storedCustomerComplaint = customerComplaintRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "customer_commentary":
                    storedCustomerComplaint.setCustomerCommentary((String) fields.get(field));
                    break;
            }
        }
        customerComplaintRepository.save(storedCustomerComplaint);
    }

    public void deleteCustomerComplaint(long id) {
        if (!customerComplaintRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        customerComplaintRepository.deleteById(id);
    }

    public void assignUploadToCustomerComplaint(String orderNumber, Long uploadId) {

        var optionalCustomerComplaint = customerComplaintRepository.findByOrderNumber(orderNumber);

        var optionalUpload = uploadRepository.findById(uploadId);

        if (optionalCustomerComplaint.isPresent() && optionalUpload.isPresent()) {

            var customerComplaint = optionalCustomerComplaint.get();

            var upload = optionalUpload.get();

            customerComplaint.setUpload(upload);

            customerComplaintRepository.save(customerComplaint);

        } else {

            throw new RecordNotFoundException();

        }

    }

    public void assignCustomerDetails(String orderNumber, String username) {

        var optionalCustomerComplaint = customerComplaintRepository.findByOrderNumber(orderNumber);

        var optionalCustomerDetails = customerDetailsRepository.findByUsername(username);

        if (optionalCustomerComplaint.isPresent() && optionalCustomerDetails.isPresent()) {

            var customerComplaint = optionalCustomerComplaint.get();

            var customerDetails = optionalCustomerDetails.get();

            customerComplaint.setCustomerDetails(customerDetails);

            customerComplaintRepository.save(customerComplaint);

        } else {

            throw new RecordNotFoundException("no data to save");

        }

    }

    public void assignProductionComplaintToCustomerComplaint(String orderNumber, Long productionComplaintId) {

        var optionalCustomerComplaint = customerComplaintRepository.findByOrderNumber(orderNumber);

        var optionalProductionComplaint = productionComplaintRepository.findById(productionComplaintId);

        if (optionalCustomerComplaint.isPresent() && optionalProductionComplaint.isPresent()) {

            var customerComplaint = optionalCustomerComplaint.get();

            var productionComplaint = optionalProductionComplaint.get();

            customerComplaint.setProductionComplaint(productionComplaint);

            customerComplaintRepository.save(customerComplaint);

        } else {

            throw new RecordNotFoundException("no data to save");

        }

    }

    public void assignAssistComplaintToCustomerComplaint(String orderNumber, Long assistComplaintId) {

        var optionalCustomerComplaint = customerComplaintRepository.findByOrderNumber(orderNumber);

        var optionalAssistComplaint = assistComplaintRepository.findById(assistComplaintId);

        if (optionalCustomerComplaint.isPresent() && optionalAssistComplaint.isPresent()) {

            var customerComplaint = optionalCustomerComplaint.get();

            var assistComplaint = optionalAssistComplaint.get();

            customerComplaint.setAssistComplaint(assistComplaint);

            customerComplaintRepository.save(customerComplaint);

        } else {

            throw new RecordNotFoundException("no data to save");

        }

    }

}