package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.Complaint;
import nl.quin.complaintservicesystem.model.CustomerComplaintResult;
import nl.quin.complaintservicesystem.model.CustomerComplaintResultKey;
import nl.quin.complaintservicesystem.service.CustomerComplaintResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/complaints")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @Autowired
    private CustomerComplaintResultService customerComplaintResultService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchComplaint(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(complaintService.getComplaints(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getComplaint(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(complaintService.getComplaintById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createComplaint(@RequestBody Complaint complaint) {
        long newId = complaintService.createComplaint(complaint);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateComplaint(@PathVariable("id") long id, @RequestBody Complaint complaint) {
        complaintService.updateCourse(id, complaint);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateComplaintPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        complaintService.partialUpdateComplaint(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteComplaint(@PathVariable("id") long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/customers")
    public ResponseEntity<Object> getCustomerComplaintResults(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerComplaintResultService.getResultsByComplaintId(id));
    }

    @GetMapping(value = "/{course_id}/customers/{customer_id}")
    public ResponseEntity<Object> getCustomerComplaintResult(@PathVariable("complaint_id") long complaintId,
                                                         @PathVariable("customer_id") long customerId) {
        return ResponseEntity.ok().body(customerComplaintResultService.getResultById(customerId, complaintId));
    }

    @PostMapping(value = "/{complaint_id}/customers/{customer_id}")
    public ResponseEntity<Object> addStudentComplaintResult(@PathVariable("complaint_id") long complaintId,
                                                         @PathVariable("customer_id") long customerId,
                                                         @RequestBody CustomerComplaintResult result) {
        CustomerComplaintResultKey newId = customerComplaintResultService.addResult(complaintId, customerId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

}