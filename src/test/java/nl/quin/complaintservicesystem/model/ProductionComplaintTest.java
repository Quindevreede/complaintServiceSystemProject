package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProductionComplaintTest {

    private ProductionComplaint productionComplaint;

    //ARRANGE
    @BeforeEach
    void setUp() {
        this.productionComplaint = new ProductionComplaint();
        this.productionComplaint.setId(123L);
        this.productionComplaint.setAssistedBy("James");
        this.productionComplaint.setProductionDepartment("DeskAssist");
        this.productionComplaint.setProductionCommentary("REPRINT, without extra costs");
    }

    @Test
    void testGetCustomerDetails() {

        //ACT
        Long expectedId = 123L;
        Long actualId = this.productionComplaint.getId();
        String expectedAssistedBy = "James";
        String actualAssistedBy = this.productionComplaint.getAssistedBy();
        String expectedProductionDepartment = "DeskAssist";
        String actualProductionDepartment = this.productionComplaint.getProductionDepartment();
        String expectedProductionCommentary = "REPRINT, without extra costs";
        String actualProductionCommentary = this.productionComplaint.getProductionCommentary();

        //ASSERT
        assertEquals(expectedId,actualId);
        assertEquals(expectedAssistedBy, actualAssistedBy);
        assertEquals(expectedProductionDepartment, actualProductionDepartment);
        assertEquals(expectedProductionCommentary, actualProductionCommentary);
    }

    @Test
    void testSetFirstName() {

        //ACT
        Long expectedId = 123l;
        this.productionComplaint.setId(456L);
        Long actualId = this.productionComplaint.getId();
        String expectedAssistedBy = "James";
        this.productionComplaint.setAssistedBy("Peter");
        String actualAssistedBy = this.productionComplaint.getAssistedBy();
        String expectedProductionDepartment = "DeskAssist";
        this.productionComplaint.setProductionDepartment("PhoneAssist");
        String actualProductionDepartment = this.productionComplaint.getProductionDepartment();
        String expectedProductionCommentary = "REPRINT, without extra costs";
        this.productionComplaint.setProductionCommentary("REPRINT, But with €9.99 extra costs");
        String actualProductionCommentary = this.productionComplaint.getProductionCommentary();

        //ASSERT
        assertNotEquals(expectedId, actualId);
        assertNotEquals(expectedAssistedBy, actualAssistedBy);
        assertNotEquals(expectedProductionDepartment, actualProductionDepartment);
        assertNotEquals(expectedProductionCommentary, actualProductionCommentary);

    }

}