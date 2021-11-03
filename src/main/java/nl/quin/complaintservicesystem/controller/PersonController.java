package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.payload.request.AddressRequest;
import nl.quin.complaintservicesystem.payload.request.SignupRequest;
import nl.quin.complaintservicesystem.service.PersonService;
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
@RequestMapping("/v1/user")
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/print")
    public ResponseEntity<?> printCustomerInfo(@Valid @RequestBody SignupRequest signupRequest) {
        return personService.printUser(signupRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerWithoutAddress(@Valid @RequestBody SignupRequest signupRequest) {
        return personService.registerWithoutAddress(signupRequest);
    }

    @PostMapping("/{id}/address")
    public ResponseEntity<?> addAddressToUser(@PathVariable("id") long id,
                                              @Valid @RequestBody AddressRequest addressRequest) {
        return personService.addAddressToUserById(id, addressRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfoById(@PathVariable("id") long id) {
        return personService.getPersonInfoById(id);
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