package nl.quin.complaintservicesystem.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AuthorityTest {

    private Authority authority;

    //ARRANGE
    @BeforeEach
    void setUp() {
        this.authority = new Authority("johndoe", "USER");
    }

    @Test
    void testGetUserName() {

    //ACT
        String expectedUserName = "johndoe";
        String actualUserName = this.authority.getUsername();
        String expectedAuthority = "USER";
        String actualAuthority = this.authority.getAuthority();

    //ASSERT
        assertEquals(expectedUserName, actualUserName);
        assertEquals(expectedAuthority, actualAuthority);
    }

    @Test
    void testSetUserName() {

        //ACT
        String expectedUserName = "johndoe";
        this.authority.setUsername("peterparker");
        String actualUserName = this.authority.getUsername();
        String expectedAuthority = "USER";
        this.authority.setAuthority("ADMIN");
        String actualAuthority = this.authority.getAuthority();

        //ASSERT
        assertNotEquals(expectedUserName, actualUserName);
        assertNotEquals(expectedAuthority, actualAuthority);
    }

}