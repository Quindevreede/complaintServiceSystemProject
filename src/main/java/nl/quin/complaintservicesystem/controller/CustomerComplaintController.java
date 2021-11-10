package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.payload.request.UploadRequestDto;
import nl.quin.complaintservicesystem.payload.response.UploadResponseDto;
import nl.quin.complaintservicesystem.service.CustomerComplaintService;
import nl.quin.complaintservicesystem.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_complaint")
public class CustomerComplaintController {

    @Autowired
    private CustomerComplaintService customerComplaintService;

    @Autowired
    private UploadService uploadService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCustomerComplaints(@RequestParam(name="name", defaultValue="") String name) {
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

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerComplaintPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerComplaintService.partialUpdateCustomerComplaint(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerComplaint(@PathVariable("id") long id) {
        customerComplaintService.deleteCustomerComplaint(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}/upload/{uploadId}")
    public void assignUploadToCustomerComplaint(@PathVariable("id") Long id,@PathVariable("uploadId") Long uploadId) {
        customerComplaintService.assignUploadToCustomerComplaint(id, uploadId);
    }

    @PutMapping("/{id}/customer_details/{customer_details_Id}")
    public void assignCustomerDetailsToJob(@PathVariable("id") Long customerComplaintId,
                                           @PathVariable("customer_details_Id") Long customerDetailsId) {

        customerComplaintService.assignCustomerDetails(customerComplaintId, customerDetailsId);

    }
   /* @PutMapping("/{id}/customer_details/{customerDetailsId}")
    public void assignCustomerComplaintToCustomerDetails(@PathVariable("id") Long id,
                                                         @PathVariable("customerDetailsId") Long customerDetailsId) {

        customerDetailsService.assignCustomerComplaintToCustomerDetails(id, customerDetailsId);

    }

    */
}


/*//TODO //TODO //TODO
    @PostMapping(value = "/customer_complaint")
    public ResponseEntity addCustomerComplaint(@RequestBody CustomerComplaint customercomplaint) {
        customerComplaintService.save(customercomplaint);
        return ResponseEntity.ok("Toegevoegd");
    }
 */

//   @GetMapping("/{id}/upload/files/{id}")
//    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
//        UploadResponseDto response = uploadService.getFileById(id);
//        return ResponseEntity.ok().body(response);
//    }