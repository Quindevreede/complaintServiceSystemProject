package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerReplyTest {

    private CustomerReply customerReply;

    //ARRANGE
    @BeforeEach
    void setUp() {
        this.customerReply = new CustomerReply();
        this.customerReply.setId(123L);
        this.customerReply.setReprintOrRefund("REPRINT");
        this.customerReply.setCustomerCommentary("Be sure that reprint doesnt come out too dark");
    }

    @Test
    void testGetCustomerDetails() {

        //ACT
        Long expectedId = 123L;
        Long actualId = this.customerReply.getId();
        String expectedReprintOrRefund = "REPRINT";
        String actualReprintOrRefund = this.customerReply.getReprintOrRefund();
        String expectedCustomerCommentary = "Be sure that reprint doesnt come out too dark";
        String actualCustomerCommentary = this.customerReply.getCustomerCommentary();
        Timestamp expectedTimestamp = Timestamp.valueOf(LocalDateTime.now());

        //ASSERT
        assertEquals(expectedId, actualId);
        assertEquals(expectedReprintOrRefund, actualReprintOrRefund);
        assertEquals(expectedCustomerCommentary, actualCustomerCommentary);
    }

    @Test
    void testSetFirstName() {

        //ACT
        Long expectedId = 123L;
        this.customerReply.setId(456L);
        Long actualId = this.customerReply.getId();
        String expectedReprintOrRefund = "REPRINT";
        this.customerReply.setReprintOrRefund("REFUND");
        String actualReprintOrRefund = this.customerReply.getReprintOrRefund();
        String expectedCustomerCommentary = "Be sure that reprint doesnt come out too dark";
        this.customerReply.setCustomerCommentary("\"Be sure that reprint doesnt come out too bright");
        String actualCustomerCommentary = this.customerReply.getCustomerCommentary();
        Timestamp expectedTimestamp = Timestamp.valueOf(LocalDateTime.now());

        //ASSERT
        assertNotEquals(expectedId, actualId);
        assertNotEquals(expectedReprintOrRefund, actualReprintOrRefund);
        assertNotEquals(expectedCustomerCommentary, actualCustomerCommentary);
    }

}