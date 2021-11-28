package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerComplaintTest {

    private CustomerComplaint customerComplaint;

    //ARRANGE
    @BeforeEach
    void setUp() {
        this.customerComplaint = new CustomerComplaint();
        this.customerComplaint.setOrderNumber("12345");
        this.customerComplaint.setCustomerCommentary("Print is TOO DARK");
    }

    @Test
    void testGetCustomerComplaint() {

        //ACT
        String expectedOrderNumber = "12345";
        String actualOrderNumber = this.customerComplaint.getOrderNumber();
        String expectedCustomerCommentary = "Print is TOO DARK";
        String actualCustomerCommentary = this.customerComplaint.getCustomerCommentary();

        //ASSERT
        assertEquals(expectedOrderNumber, actualOrderNumber);
        assertEquals(expectedCustomerCommentary, actualCustomerCommentary);
    }

    @Test
    void testSetFirstName() {

        //ACT
        String expectedUsername = "johndoe";
        this.customerComplaint.setUsername("peterparker");
        String actualUsername = this.customerComplaint.getUsername();
        String expectedOrderNumber = "12345";
        this.customerComplaint.setOrderNumber("98765");
        String actualOrderNumber = this.customerComplaint.getOrderNumber();
        String expectedCustomerCommentary = "Print is TOO DARK";
        this.customerComplaint.setCustomerCommentary("Print is TOO BRIGHT");
        String actualCustomerCommentary= this.customerComplaint.getCustomerCommentary();

        //ASSERT
        assertNotEquals(expectedUsername, actualUsername);
        assertNotEquals(expectedOrderNumber, actualOrderNumber);
        assertNotEquals(expectedCustomerCommentary, actualCustomerCommentary);
    }

}