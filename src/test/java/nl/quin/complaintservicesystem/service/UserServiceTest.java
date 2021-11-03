/*package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest()
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Mock
    User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername("johndoe");
        this.user.setPassword("se7en");
    }

    @Test
    public void testGetUserByLastName() {


        Mockito
                .when(userRepository.findByUsername(user.getUsername()))
                .thenReturn(user);

        String username = "johndoe";
        String expected = "johndoe";

        User found = userService.getUser(username);

        assertEquals(expected, found.getUsername());
    }

    @Test
    public void testGetUserByLastName2() {

        Mockito
                .doReturn(user)
                .when(userRepository)
                .findByUsername("johndoe");

        String name = "johndoe";
        String expected = "johndoe";

        User found = userService.getUser(username);

        assertEquals(expected, found.getUsername());
    }
}

 */
