package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.Customer;
import nl.quin.complaintservicesystem.model.CustomerComplaintResult;
import nl.quin.complaintservicesystem.model.CustomerComplaintResultKey;
import nl.quin.complaintservicesystem.service.CustomerComplaintResultService;
import nl.quin.complaintservicesystem.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * CustomerController
 * Implements endpoints for customer resource
 *
 * GET /customers
 * POST /customers
 * GET /customers/{id}
 * PUT /customers/{id}
 * PATCH /customers/{id}
 * DELETE /customers/{id}
 *
 * GET /customers/{id}/complaints => return complaints with id
 * POST /customers/{id}/complaints => body { complaints_id:{id} }
 * DELETE /customers/{id}/complaints/{complaints_id}
 *
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerComplaintResultService customerComplaintResultService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCustomers(@RequestParam(name="name", defaultValue="") String name) {
       return ResponseEntity.ok().body(customerService.getCustomers(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        long newId = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerService.partialUpdateCustomer(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/complaints")
    public ResponseEntity<Object> getCustomerComplaintResults(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerComplaintResultService.getResultsByCustomerId(id));
    }

    @GetMapping(value = "/{customer_id}/courses/{complaint_id}")
    public ResponseEntity<Object> getCustomerComplaintResult(@PathVariable("customer_id") long customerId,
                                                         @PathVariable("complaint_id") long complaintId) {
        return ResponseEntity.ok().body(customerComplaintResultService.getResultById(customerId, complaintId));
    }

    @PostMapping(value = "/{customer_id}/complaints/{complaint_id}")
    public ResponseEntity<Object> addCustomerComplaintResult(@PathVariable("customer_id") long customerId,
                                                         @PathVariable("complaint_id") long complaintId,
                                                         @RequestBody CustomerComplaintResult result) {
        CustomerComplaintResultKey newId = customerComplaintResultService.addResult(customerId, complaintId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

}