package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDetailsTest {

    private CustomerDetails customerDetails;

    //ARRANGE
    @BeforeEach
    void setUp() {
        this.customerDetails = new CustomerDetails();
        this.customerDetails.setFirstName("John");
        this.customerDetails.setLastName("Doe");
        this.customerDetails.setEmail("johndoe@hotmail.com");
    }

    @Test
    void testGetId() {
        assertNull(this.customerDetails.getId());
    }

    @Test
    void testGetCustomerDetails() {

        //ACT
        String expectedFirstName = "John";
        String actualFirstName = this.customerDetails.getFirstName();
        String expectedLastName = "Doe";
        String actualLastName = this.customerDetails.getLastName();
        String expectedEmail = "johndoe@hotmail.com";
        String actualEmail = this.customerDetails.getEmail();

        //ASSERT
        assertEquals(expectedFirstName, actualFirstName);
        assertEquals(expectedLastName, actualLastName);
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void testSetFirstName() {

        //ACT
        String expectedFirstName = "John";
        this.customerDetails.setFirstName("Peter");
        String actualFirstName = this.customerDetails.getFirstName();
        String expectedLastName = "Doe";
        this.customerDetails.setLastName("Parker");
        String actualLastName = this.customerDetails.getLastName();
        String expectedEmail = "johndoe@hotmail.com";
        this.customerDetails.setEmail("peterparker@hotmail.com");
        String actualEmail = this.customerDetails.getEmail();

        //ASSERT
        assertNotEquals(expectedFirstName, actualFirstName);
        assertNotEquals(expectedLastName, actualLastName);
        assertNotEquals(expectedEmail, actualEmail);
    }

}