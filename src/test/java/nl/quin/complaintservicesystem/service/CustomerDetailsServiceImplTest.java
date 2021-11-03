/*package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.payload.request.CustomerComplaintRequest;
import nl.quin.complaintservicesystem.payload.request.CustomerDetailsRequest;
import nl.quin.complaintservicesystem.payload.response.ErrorResponse;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerDetailsServiceImplTest {

    @InjectMocks
    private final CustomerDetailsService customerDetailsService = new CustomerDetailsServiceImpl();

    @Mock
    private CustomerDetailsRepository customerDetailsRepository;

    @Mock
    private CustomerComplaintRequest customerComplaintRequest;

    private CustomerDetailsRequest customerDetailsRequest;

    @BeforeEach
    void setup() {
        customerDetailsRequest = new CustomerDetailsRequest();
        customerDetailsRequest.setFirstName("John");
        customerDetailsRequest.setLastName("Doe");
        customerDetailsRequest.setEmail("johndoe@hotmail.com");
        customerDetailsRequest.setUsername("johndoe");
        customerDetailsRequest.setPassword("se7en");
        customerDetailsRequest.setRepeatedPassword("se7en");
    }

    @Test
    public void testGetCustomerByLastName2() {

        Mockito
                .doReturn(customerDetailsRequest)
                .when(customerDetailsRepository)
                .findByUsername("johndoe");

        String name = "johndoe";
        String expected = "johndoe";

        CustomerDetails found = customerDetailsService.getCustomerDetails(username);

        assertEquals(expected, found.getUsername());
    }

    @Test
    void unmatchingPasswordShouldReturnError() {
        // Arrange
        customerDetailsRequest.setRepeatedPassword("completelyWrongPassword");

        // Act
        ResponseEntity<?> responseEntity = customerDetailsService.registerWithoutCustomerComplaint(customerDetailsRequest);

        // Assert
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
        Assertions.assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        Assertions.assertEquals(1, ((ErrorResponse) responseEntity.getBody()).getErrors().size());
        Assertions.assertTrue(((((ErrorResponse) responseEntity.getBody()).getErrors()).containsKey("repeatedPassword")));
        Assertions.assertSame("The passwords do not match eachother.", ((ErrorResponse) responseEntity.getBody()).getErrors().get("repeatedPassword"));

    }

    @Test
    void nonUniqueUsernameShouldReturnError() {
        // Arrange
        Mockito.when(customerDetailsRepository.existsByUsername(customerDetailsRequest.getUsername())).thenReturn(true);

        // Act
        ResponseEntity<?> responseEntity = customerDetailsService.registerWithoutCustomerComplaint(customerDetailsRequest);

        // Assert
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
        Assertions.assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        Assertions.assertEquals(1, ((ErrorResponse) responseEntity.getBody()).getErrors().size());

        Assertions.assertTrue(((((ErrorResponse) responseEntity.getBody()).getErrors()).containsKey("username")));
        Assertions.assertSame("The username already exists.", ((ErrorResponse) responseEntity.getBody()).getErrors().get("username"));
    }

    @Test
    void nonUniqueEmailShouldReturnError() {
        Mockito.when(customerDetailsRepository.existsByEmail(customerDetailsRequest.getEmail())).thenReturn(true);

        ResponseEntity<?> responseEntity = customerDetailsService.registerWithoutCustomerComplaint(customerDetailsRequest);

        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
        Assertions.assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        Assertions.assertEquals(1, ((ErrorResponse) responseEntity.getBody()).getErrors().size());

        Assertions.assertTrue(((((ErrorResponse) responseEntity.getBody()).getErrors()).containsKey("email")));
        Assertions.assertSame("The email is already in use.", ((ErrorResponse) responseEntity.getBody()).getErrors().get("email"));
    }

    @Test
    void nonUniqueUsernameAndEmailShouldReturnMultipleErrors() {
        Mockito.when(customerDetailsRepository.existsByEmail(customerDetailsRequest.getEmail())).thenReturn(true);
        Mockito.when(customerDetailsRepository.existsByUsername(customerDetailsRequest.getUsername())).thenReturn(true);

        ResponseEntity<?> responseEntity = customerDetailsService.registerWithoutCustomerComplaint(customerDetailsRequest);

        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
        Assertions.assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        Assertions.assertEquals(2, ((ErrorResponse) responseEntity.getBody()).getErrors().size());

        Assertions.assertTrue(((((ErrorResponse) responseEntity.getBody()).getErrors()).containsKey("username")));
        Assertions.assertSame("The username already exists.", ((ErrorResponse) responseEntity.getBody()).getErrors().get("username"));
        Assertions.assertTrue(((((ErrorResponse) responseEntity.getBody()).getErrors()).containsKey("email")));
        Assertions.assertSame("The email is already in use.", ((ErrorResponse) responseEntity.getBody()).getErrors().get("email"));
    }

    @Test
    void addingAddressToUnknownIdShouldReturnErrorMessage() {

        long id = 1L;

        Mockito.when(customerDetailsRepository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<?> responseEntity = customerDetailsService.addCustomerComplaintToCustomerDetailsById(id, customerComplaintRequest);

        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
        Assertions.assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        Assertions.assertEquals(1, ((ErrorResponse) responseEntity.getBody()).getErrors().size());

        Assertions.assertTrue(((((ErrorResponse) responseEntity.getBody()).getErrors()).containsKey("id")));

        Assertions.assertEquals("The user with id (" + id + ") does not exist.",
                ((ErrorResponse) responseEntity.getBody()).getErrors().get("id"));
    }

}

 */
