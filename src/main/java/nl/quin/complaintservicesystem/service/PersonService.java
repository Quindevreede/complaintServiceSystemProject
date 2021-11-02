package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.payload.request.AddressRequest;
import nl.quin.complaintservicesystem.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface PersonService {

    ResponseEntity<?> printUser(SignupRequest signupRequest);
    ResponseEntity<?> registerWithoutAddress(SignupRequest signupRequest);
    ResponseEntity<?> addAddressToUserById(long id, AddressRequest addressRequest);
    ResponseEntity<?> getPersonInfoById(long id);
}
