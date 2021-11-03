package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.payload.request.CustomerDetailsRequest;
import nl.quin.complaintservicesystem.payload.request.UserPostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerDetailsServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    CustomerDetailsService customerDetailsService;


    private User user;

    @BeforeEach
    void createUser(){
        user = new User();
        user.setUsername("user1");
        user.setPassword("user1");

        UserPostRequest userPostRequest = new UserPostRequest();
        userPostRequest.setUsername(user.getUsername());
        userPostRequest.setPassword(user.getPassword());
        String userName = userService.createUser(userPostRequest);
        assertEquals(userName,user.getUsername());
    }

    @Test
    void whenCreatingUserWithCustomerDetails_thenIsCreatedOK(){
        //create User and add CustomerDetails
        //Arrange

        CustomerDetailsRequest customerDetailsRequest = new CustomerDetailsRequest();
        customerDetailsRequest.setFirstName("firstName");
        customerDetailsRequest.setLastName("lastName");
        customerDetailsRequest.setEmail("a@gmail.com");//TODO validate
        customerDetailsRequest.setUsername(user.getUsername());
        customerDetailsRequest.setPassword(user.getPassword());
        customerDetailsRequest.setRepeatedPassword(user.getPassword());

        //Act

        //return ResponseEntity.ok(customerDetailsResponse);
        ResponseEntity<?> responseEntity = customerDetailsService.registerWithoutCustomerComplaint(customerDetailsRequest);


        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(ResponseEntity.ok());

        //Assert
        assertEquals(responseEntity.getStatusCodeValue(), HttpStatus.OK.value());

    }

    @Test
    void testcreateCustomerComplaint(){

    }

    @Test
    void testAddCustomerComplaint(){

    }

    @Test
    void testCreateCustomerDetailsResponse(){
        //Arrange



        //Act


        //Assert

    }


}
