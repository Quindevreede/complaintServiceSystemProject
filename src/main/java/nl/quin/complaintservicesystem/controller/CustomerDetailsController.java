package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.payload.request.CustomerComplaintRequest;
import nl.quin.complaintservicesystem.payload.request.CustomerDetailsRequest;
import nl.quin.complaintservicesystem.payload.request.UploadDownloadRequestDto;
import nl.quin.complaintservicesystem.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer_details")
public class CustomerDetailsController {

    private CustomerDetailsService customerDetailsService;

    @Autowired
    public void setCustomerDetailsService(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @PostMapping("/print")
    public ResponseEntity<?> printCustomerInfo(@Valid @RequestBody CustomerDetailsRequest customerDetailsRequest) {
        return customerDetailsService.printCustomerDetails(customerDetailsRequest);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> customerDetailsWithoutAddress(@Valid @RequestBody CustomerDetailsRequest customerDetailsRequest) {
        return customerDetailsService.registerWithoutCustomerComplaint(customerDetailsRequest);
    }

    @PostMapping("/{id}/complaint")
    public ResponseEntity<?> addCustomerComplaintToCustomerDetailsById(@PathVariable("id") long id,
                                                    @Valid @RequestBody CustomerComplaintRequest customerComplaintRequest) {
        return customerDetailsService.addCustomerComplaintToCustomerDetailsById(id, customerComplaintRequest);
    }

    @PostMapping("/{id}/upload_download/files")
    public ResponseEntity<?> addUploadDownloadToCustomerDetailsById(@PathVariable("id") long id,
                                                                       @Valid @RequestBody UploadDownloadRequestDto uploadDownloadRequestDto) {
        return customerDetailsService.addUploadDownloadToCustomerDetailsById(id, uploadDownloadRequestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerDetailsById(@PathVariable("id") long id) {
        return customerDetailsService.getCustomerDetailsInfoById(id);
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

