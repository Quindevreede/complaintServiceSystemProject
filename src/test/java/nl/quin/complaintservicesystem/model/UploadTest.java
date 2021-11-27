package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UploadTest {

    private Upload upload;

    //ARRANGE
    @BeforeEach
    void setUp() {

        this.upload = new Upload();
        this.upload.setId(123L);
        this.upload.setTitle("Frankenstein");
        this.upload.setDescription("Frankenstein's Monster");
        this.upload.setOrderNumberUpload("123");
    }

    @Test
    void testGetCustomerDetails() {

        //ACT
        Long expectedId = 123L;
        Long actualId = this.upload.getId();
        String expectedTitle = "Frankenstein";
        String actualTitle = this.upload.getTitle();
        String expectedDescription = "Frankenstein's Monster";
        String actualDescription = this.upload.getDescription();
        String expectedOrderNumberUpload = "123";
        String actualOrderNumberUpload = this.upload.getOrderNumberUpload();

        //ASSERT
        assertEquals(expectedId, actualId);
        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedDescription, actualDescription);
        assertEquals(expectedOrderNumberUpload, actualOrderNumberUpload);
    }

    @Test
    void testSetFirstName() {

        //ACT
        Long expectedId = 123L;
        this.upload.setId(456L);
        Long actualId = this.upload.getId();
        String expectedTitle = "Frankenstein";
        this.upload.setTitle("Dracula");
        String actualTitle = this.upload.getTitle();
        String expectedDescription = "Frankenstein's Monster";
        this.upload.setDescription("Dracula's Teeth");
        String actualDescription = this.upload.getDescription();
        String expectedOrderNumberUpload = "123";
        this.upload.setOrderNumberUpload("456");
        String actualOrderNumberUpload = this.upload.getOrderNumberUpload();

        //ASSERT
        assertNotEquals(expectedId, actualId);
        assertNotEquals(expectedTitle, actualTitle);
        assertNotEquals(expectedDescription, actualDescription);
        assertNotEquals(expectedOrderNumberUpload, actualOrderNumberUpload);
    }

}