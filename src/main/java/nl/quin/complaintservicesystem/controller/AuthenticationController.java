package nl.quin.complaintservicesystem.controller;


import nl.quin.complaintservicesystem.service.UserAuthenticateService;
import nl.quin.complaintservicesystem.payload.request.AuthenticationRequest;
import nl.quin.complaintservicesystem.payload.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // Cross origin allowed for port 3000

@RestController
public class AuthenticationController {

    UserAuthenticateService userAuthenticateService;

    @Autowired
    public AuthenticationController(UserAuthenticateService userAuthenticateService) {
        this.userAuthenticateService = userAuthenticateService;
    }

    // This is the ENDPOINT where you POST { "username":"johndoe", "password":"se7en" }
    // to get JWT TOKEN (Fill in this JWT TOKEN in Authorization tab under BEARER TOKEN to get access)
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        AuthenticationResponse authenticationResponse = userAuthenticateService.authenticateUser(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }

}
