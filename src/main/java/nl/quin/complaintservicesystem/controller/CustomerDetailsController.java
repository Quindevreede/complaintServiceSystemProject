package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.HashMap;
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerDetails(@PathVariable("id") long id) {
        customerDetailsService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}