package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_details")
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCustomerDetails(@RequestParam(name = "name", defaultValue = "") String name) {
        return ResponseEntity.ok().body(customerDetailsService.getCustomers(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerDetails(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerDetailsService.getCustomerById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        long newId = customerDetailsService.createCustomer(customerDetails);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerDetails(@PathVariable("id") long id, @RequestBody CustomerDetails customerDetails) {
        customerDetailsService.updateCustomer(id, customerDetails);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerDetailsPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerDetailsService.partialUpdateCustomer(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerDetails(@PathVariable("id") long id) {
        customerDetailsService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}


/* //TODO//TODO//TODO

    @GetMapping(value = "/customer_details/{id}/customer_complaint")
    public ResponseEntity getCustomerDetailsCustomerComplaint(@PathVariable long id) {
        Iterable<CustomerComplaint> customerDetailsCustomerComplaint = customerDetailsService.getCustomerDetailsCustomerComplaint(id);
        return ResponseEntity.ok(customerDetailsCustomerComplaint);
    }
 */

