package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    User user;

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void GetUserTest() {
        user = new User();
        user.setUsername("johndoe");

        Mockito

                .when(userRepository
                        .findById("johndoe")).thenReturn(Optional.of(user));

        String expected = "johndoe";

        userService.getUser("johndoe");
        assertEquals(expected, user.getUsername());
    }

    @Test
    void testGetUserIsNullError() {
        String username = null;
        Mockito

                .when(userRepository
                        .findById("johndoe")).thenReturn(Optional.of(user));

        // Assert the response
        assertNull(username, "username should not be found");
    }

    @Test
    public void createUserTest() {
        user = new User();
        user.setUsername("johndoe");
        user.setPassword("se7en");

        userRepository.save(user);

        verify(userRepository, times(1)).save(userCaptor.capture());
        var user1 = userCaptor.getValue();

        assertThat(user1.getUsername()).isEqualTo("johndoe");
        assertThat(user1.getPassword()).isEqualTo("se7en");
    }



    @Test
    public void deleteUserTest() {
        user = new User();
        user.setUsername("johndoe");

        userRepository.delete(user);

        Mockito

                .when(userRepository
                        .findById("johndoe")).thenReturn(Optional.of(user));

        userService.deleteUser("johndoe");
        verify(userRepository, times(1)).delete(user);
    }

}
