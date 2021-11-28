package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.service.CustomerComplaintService;
import nl.quin.complaintservicesystem.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_complaint")
public class CustomerComplaintController {

    @Autowired
    private CustomerComplaintService customerComplaintService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllCustomerComplaints(@RequestParam(name = "name", defaultValue = "") String name) {
        return ResponseEntity.ok().body(customerComplaintService.getCustomerComplaint(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerComplaint(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerComplaintService.getCustomerComplaintById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomerComplaint(@RequestBody CustomerComplaint customerComplaint) {
        long newId = customerComplaintService.createCustomerComplaint(customerComplaint);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerComplaint(@PathVariable("id") long id, @RequestBody CustomerComplaint customerComplaint) {
        customerComplaintService.updateCustomerComplaint(id, customerComplaint);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerComplaint(@PathVariable("id") long id) {
        customerComplaintService.deleteCustomerComplaint(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{ordernumber}/customer_details/{username}")
    public void assignCustomerDetailsToCustomerComplaint(@PathVariable("ordernumber") String orderNumber, @PathVariable("username") String username) {
        customerComplaintService.assignCustomerDetailsToCustomerComplaint(orderNumber, username);
    }

    @PutMapping("/{ordernumber}/upload/{uploadId}")
    public void assignUploadToCustomerComplaint(@PathVariable("ordernumber") String orderNumber, @PathVariable("uploadId") Long uploadId) {
        customerComplaintService.assignUploadToCustomerComplaint(orderNumber, uploadId);
    }

    @PutMapping("/{ordernumber}/receipt_upload/{receiptUploadId}")
    public void assignUploadReceiptToCustomerComplaint(@PathVariable("ordernumber") String orderNumber, @PathVariable("receiptUploadId") Long receiptUploadId) {
        customerComplaintService.assignReceiptUploadToCustomerComplaint(orderNumber, receiptUploadId);
    }

    @PutMapping("/{ordernumber}/production_complaint/{production_complaintId}")
    public void assignProductionComplaintToCustomerComplaint(@PathVariable("ordernumber") String orderNumber, @PathVariable("production_complaintId") Long productionComplaintId) {
        customerComplaintService.assignProductionComplaintToCustomerComplaint(orderNumber, productionComplaintId);
    }

    @PutMapping("/{ordernumber}/assist_complaint/{assist_complaintId}")
    public void assignAssistComplaintToCustomerComplaint(@PathVariable("ordernumber") String orderNumber, @PathVariable("assist_complaintId") Long assistComplaintId) {
        customerComplaintService.assignAssistComplaintToCustomerComplaint(orderNumber, assistComplaintId);
    }

    @PutMapping("/{ordernumber}/customer_reply/{customer_replyId}")
    public void assignCustomerReplyToCustomerComplaint(@PathVariable("ordernumber") String orderNumber, @PathVariable("customer_replyId") Long customerReplyId) {
        customerComplaintService.assignCustomerReplyToCustomerComplaint(orderNumber, customerReplyId);
    }

}