package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.service.CustomerComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_complaint")
public class CustomerComplaintController {

    @Autowired
    private CustomerComplaintService customerComplaintService;

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

}

/*//TODO //TODO //TODO
    @PostMapping(value = "/customer_complaint")
    public ResponseEntity addCustomerComplaint(@RequestBody CustomerComplaint customercomplaint) {
        customerComplaintService.save(customercomplaint);
        return ResponseEntity.ok("Toegevoegd");
    }
 */