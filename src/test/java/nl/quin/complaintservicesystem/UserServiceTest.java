package nl.quin.complaintservicesystem;


import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.payload.request.UserPostRequest;
import nl.quin.complaintservicesystem.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    //arrange
/*    @Test
    void testCreateCustomer() {
        UserPostRequest userPostRequest = new UserPostRequest();
        userPostRequest.setUsername("quin");
        String username = userService.createUser(userPostRequest);

        assertEquals(userPostRequest.getUsername(), username);
    }

 */

    @Test
    void testCreateCustomer() {
        UserPostRequest userPostRequest = new UserPostRequest();
        userPostRequest.setUsername("quin");
        userPostRequest.setPassword("p4ssw0rd");
        String username = userService.createUser(userPostRequest);
        assertEquals(userPostRequest.getUsername(), username);
    }

    }



/*
import nl.quin.complaintservicesystem.model.Customer;
import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.repository.CustomerRepository;

import nl.quin.complaintservicesystem.repository.UserRepository;
import nl.quin.complaintservicesystem.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;


@TestConfiguration
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User();

        Mockito
                .when(userRepository.findByLastName(user.getLastName()))
                .thenReturn(user);

    }

    @Test
    public void testGetEmployeeByName() {
        String name = "Einstein";
        Customer found = userService.getUserByLastName(name);

        assertThat(found.getLastName()).isEqualTo(name);
    }

}

 */