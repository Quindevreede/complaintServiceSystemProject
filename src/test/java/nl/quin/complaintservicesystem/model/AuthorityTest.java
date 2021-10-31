package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorityTest {

    @Test
    void getUsername() {
        //Arrange
        Authority authority = new Authority();
        //Act
        authority.setUsername("Harry");
        //Assert
        assertEquals("Harry", authority.getUsername());
    }

    @Test
    void setUsername() {
        //Arrange
        Authority authority = new Authority();
        //Act
        authority.setUsername("Harry");
        //Assert
        assertEquals("Harry", authority.getUsername());
    }

    @Test
    void getAuthority() {
        //Arrange
        Authority authority = new Authority();
        //Act
        authority.setAuthority("ROLE_USER");
        //Assert
        assertEquals("ROLE_USER", authority.getAuthority());
    }

    @Test
    void setAuthority() {
        //Arrange
        Authority authority = new Authority();
        //Act
        authority.setAuthority("ROLE_USER");
        //Assert
        assertEquals("ROLE_USER", authority.getAuthority());
    }
}