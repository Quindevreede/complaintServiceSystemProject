/*package nl.quin.complaintservicesystem;


import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.payload.request.UserPostRequest;
import nl.quin.complaintservicesystem.repository.UserRepository;
import nl.quin.complaintservicesystem.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername("johndoe");
        this.user.setPassword("se7en");
    }

    @Test
    void testCreateCustomer() {
        UserPostRequest userPostRequest = new UserPostRequest();
        userPostRequest.setUsername("johndoe");
        userPostRequest.setPassword("se7en");
        String username = userService.createUser(userPostRequest);
        assertEquals(userPostRequest.getUsername(), username);
    }

}

//TODO org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'webSecurityConfiguration': Requested bean is currently in creation: Is there an unresolvable circular reference?

*/
