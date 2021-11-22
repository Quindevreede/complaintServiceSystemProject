package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AssistComplaintTest {

    private AssistComplaint assistComplaint;

    //ARRANGE
    @BeforeEach
    void setUp() {

        this.assistComplaint = new AssistComplaint();
        this.assistComplaint.setId(123L);
        this.assistComplaint.setAssistedBy("James");
        this.assistComplaint.setAssistDepartment("DeskAssist");
        this.assistComplaint.setAssistCommentary("REPRINT, without extra costs");
        this.assistComplaint.setExtraCosts(BigDecimal.valueOf(6.66));
        this.assistComplaint.setInvoiceLink("http://localhost:666/receipt_upload/files/2/download");
    }

    @Test
    void testGetId() {
        assertNotNull(this.assistComplaint.getId());
    }

    @Test
    void testGetCustomerDetails() {

        //ACT
        Long expectedId = 123L;
        Long actualId = this.assistComplaint.getId();
        String expectedAssistedBy = "James";
        String actualAssistedBy = this.assistComplaint.getAssistedBy();
        String expectedAssistDepartment = "DeskAssist";
        String actualAssistDepartment = this.assistComplaint.getAssistDepartment();
        String expectedAssistCommentary = "REPRINT, without extra costs";
        String actualAssistCommentary = this.assistComplaint.getAssistCommentary();
        BigDecimal expectedExtraCosts = BigDecimal.valueOf(6.66);
        BigDecimal actualExtraCosts = this.assistComplaint.getExtraCosts();
        String expectedInvoiceLink = "http://localhost:666/receipt_upload/files/2/download";
        String actualInvoiceLink = this.assistComplaint.getInvoiceLink();

        //ASSERT
        assertEquals(expectedId, actualId);
        assertEquals(expectedAssistedBy, actualAssistedBy);
        assertEquals(expectedAssistDepartment, actualAssistDepartment);
        assertEquals(expectedAssistCommentary, actualAssistCommentary);
        assertEquals(expectedExtraCosts, actualExtraCosts);
        assertEquals(expectedInvoiceLink, actualInvoiceLink);
    }

    @Test
    void testSetFirstName() {

        //ACT
        Long expectedId = 123L;
        this.assistComplaint.setId(456L);
        Long actualId = this.assistComplaint.id;
        String expectedAssistedBy = "James";
        this.assistComplaint.setAssistedBy("Peter");
        String actualAssistedBy = this.assistComplaint.getAssistedBy();
        String expectedAssistDepartment = "DeskAssist";
        this.assistComplaint.setAssistDepartment("PhoneAssist");
        String actualAssistDepartment = this.assistComplaint.getAssistDepartment();
        String expectedAssistCommentary = "REPRINT, without extra costs";
        this.assistComplaint.setAssistCommentary("REPRINT, But with €9.99 extra costs");
        String actualAssistCommentary = this.assistComplaint.getAssistCommentary();
        BigDecimal expectedExtraCosts = BigDecimal.valueOf(6.66);
        this.assistComplaint.setExtraCosts(BigDecimal.valueOf(9.99));
        BigDecimal actualExtraCosts = this.assistComplaint.getExtraCosts();
        String expectedInvoiceLink = "http://localhost:666/receipt_upload/files/1/download";
        this.assistComplaint.setInvoiceLink("http://localhost:666/receipt_upload/files/2/download");
        String actualInvoiceLink = this.assistComplaint.getInvoiceLink();

        //ASSERT

        assertNotEquals(expectedId, actualId);
        assertNotEquals(expectedAssistedBy, actualAssistedBy);
        assertNotEquals(expectedAssistDepartment, actualAssistDepartment);
        assertNotEquals(expectedAssistCommentary, actualAssistCommentary);
        assertNotEquals(expectedExtraCosts, actualExtraCosts);
        assertNotEquals(expectedInvoiceLink, actualInvoiceLink);
    }

}