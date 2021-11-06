package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDetailsTest {

    @Test
    void getFirstName() {
        //Arrange
       CustomerDetails customer = new CustomerDetails();
        //Act
        customer.setFirstName("John");
        //Assert
        assertEquals("John", customer.getFirstName());
    }

    @Test
    void setFirstName() {
        //Arrange
        CustomerDetails customer = new CustomerDetails();
        //Act
        customer.setFirstName("John");
        customer.setFirstName("Harry");
        customer.setFirstName("John");
        //Assert
        assertEquals("John", customer.getFirstName());
    }

    @Test
    void getLastName() {
        //Arrange
        CustomerDetails customer = new CustomerDetails();
        //Act
        customer.setLastName("Doe");
        //Assert
        assertEquals("Doe", customer.getLastName());
    }

    @Test
    void setLastName() {
        //Arrange
        CustomerDetails customer = new CustomerDetails();
        //Act
        customer.setLastName("Doe");
        customer.setLastName("Berry");
        customer.setLastName("Doe");
        //Assert
        assertEquals("Doe", customer.getLastName());
    }

    @Test
    void getEmail() {
        //Arrange
        CustomerDetails customer = new CustomerDetails();
        //Act
        customer.setEmail("johndoe@hotmail.com");
        //Assert
        assertEquals("johndoe@hotmail.com", customer.getEmail());
    }

    @Test
    void setEmail() {
        //Arrange
        CustomerDetails customer = new CustomerDetails();
        //Act
        customer.setEmail("johndoe@hotmail.com");
        customer.setEmail("harryberry@hotmail.com");
        customer.setEmail("johndoe@hotmail.com");
        //Assert
        assertEquals("johndoe@hotmail.com", customer.getEmail());
    }

}