package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername("johndoe");
        this.user.setPassword("p4ssw0rd");
    }

    @Test
    void testGetUserName() {
        String expectedUserName = "johndoe";
        String actualUserName = this.user.getUsername();
        assertEquals(expectedUserName, actualUserName);
    }

}