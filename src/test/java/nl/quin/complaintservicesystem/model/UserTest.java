package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserTest {

    private User user;

    //ARRANGE
    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername("johndoe");
        this.user.setPassword("se7en");
        this.user.setEnabled(true);
    }

    @Test
    void testGetUserName() {

        //ACT
        String expectedUsername = "johndoe";
        String actualUsername = this.user.getUsername();
        String expectedPassword = "se7en";
        String actualPassword = this.user.getPassword();

        //ASSERT
        assertEquals(expectedUsername, actualUsername);
        assertEquals(expectedPassword, actualPassword);
    }

    @Test
    void testSetUserName() {

        //ACT
        String expectedUsername = "johndoe";
        this.user.setUsername("peterparker");
        String actualUsername = this.user.getUsername();
        String expectedPassword = "se7en";
        this.user.setPassword("3ight");
        String actualPassword = this.user.getPassword();

        //ASSERT
        assertNotEquals(expectedUsername, actualUsername);
        assertNotEquals(expectedPassword, actualPassword);
    }

    @Test
    void getterUsername() {
        //Arrange
        User user = new User();
        //Act
        user.setUsername("johndoe");
        //Assert
        assertEquals("johndoe", user.getUsername());
    }

    @Test
    void setterUsername() {
        //Arrange
        User user = new User();
        //Act
        user.setUsername("johndoe");
        user.setUsername("peterparker");
        user.setUsername("johndoe");
        //Assert
        assertEquals("johndoe", user.getUsername());
    }

    @Test
    void getterPassword() {
        //Arrange
        User user = new User();
        //Act
        user.setPassword("se7en");
        //Assert
        assertEquals("se7en", user.getPassword());
    }

    @Test
    void setterPassword() {
        //Arrange
        User user = new User();
        //Act
        user.setPassword("se7en");
        user.setPassword("3i9ht");
        user.setPassword("se7en");
        //Assert
        assertEquals("se7en", user.getPassword());
    }

    @Test
    void setterEnabled() {
        //Arrange
        User user = new User();
        //Act
        user.setEnabled(true);
        user.setEnabled(false);
        user.setEnabled(true);
        //Assert
        assertEquals(true, user.isEnabled());
    }

    @Test
    void getterEnabled() {
        //Arrange
        User user = new User();
        //Act
        user.setPassword("true");
        //Assert
        assertEquals(true, user.isEnabled());
    }

    @Test
    void ifEnabledEmptyOrNullReturnTrue() {
        //Arrange
        User user = new User();
        User user1 = new User();

        //Act
        user.setPassword(null);
        user1.setPassword(null);
        //Assert
        assertEquals(true, user.isEnabled());
        assertEquals(true, user1.isEnabled());
    }

}