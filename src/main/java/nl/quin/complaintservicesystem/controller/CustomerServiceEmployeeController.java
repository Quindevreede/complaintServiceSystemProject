package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerServiceEmployee;
import nl.quin.complaintservicesystem.service.CustomerServiceEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * CustomerServiceEmployeeController
 * Implements endpoints for customer service employees resource
 *
 * GET /customersserviceemployees
 * POST /customersserviceemployees
 * GET /customersserviceemployees/{id}
 * PUT /customersserviceemployees/{id}
 * PATCH /customersserviceemployees/{id}
 * DELETE /customersserviceemployees/{id}
 *
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/customers_service_employees")
public class CustomerServiceEmployeeController {

    @Autowired
    private CustomerServiceEmployeeService customerServiceEmployeeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCustomerServiceEmployees(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(customerServiceEmployeeService.getCustomerServiceEmployees(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerServiceEmployee(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerServiceEmployeeService.getCustomerServiceEmployeeById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomerServiceEmployee(@RequestBody CustomerServiceEmployee customerServiceEmployee) {
        long newId = customerServiceEmployeeService.createCustomerServiceEmployee(customerServiceEmployee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerServiceEmployee(@PathVariable("id") long id, @RequestBody CustomerServiceEmployee customerServiceEmployee) {
        customerServiceEmployeeService.updateCustomerServiceEmployee(id, customerServiceEmployee);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerServiceEmployeePartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerServiceEmployeeService.partialUpdateCustomerServiceEmployee(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerServiceEmployee(@PathVariable("id") long id) {
        customerServiceEmployeeService.deleteCustomerServiceEmployee(id);
        return ResponseEntity.noContent().build();
    }

}