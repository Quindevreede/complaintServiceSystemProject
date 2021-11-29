package nl.quin.complaintservicesystem.service;

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
    void getUserIsNullErrorTest() {

        // ARRANGE
        String assistedBy = null;

        // ACT
        Mockito
                .when(userRepository
                        .findById("johndoe")).thenReturn(Optional.of(user));

        // ASSERT
        assertNull(assistedBy, "assistedBy should not be found");
    }

    @Test
    public void getUserTest() {

        // ARRANGE
        user = new User();
        user.setUsername("johndoe");

        // ACT
        Mockito
                .when(userRepository
                        .findById("johndoe")).thenReturn(Optional.of(user));

        String expected = "johndoe";

        // ASSERT
        userService.getUser("johndoe");
        assertEquals(expected, user.getUsername());
    }

    @Test
    public void createUserTest() {

        // ARRANGE
        user = new User();
        user.setUsername("johndoe");
        user.setPassword("se7en");

        userRepository.save(user);

        // ACT
        verify(userRepository, times(1)).save(userCaptor.capture());
        var user1 = userCaptor.getValue();

        // ASSERT
        assertThat(user1.getUsername()).isEqualTo("johndoe");
        assertThat(user1.getPassword()).isEqualTo("se7en");
    }

    @Test
    public void deleteUserTest() {

        // ARRANGE
        user = new User();
        user.setUsername("johndoe");

        userRepository.delete(user);

        // ACT
        Mockito
                .when(userRepository
                        .findById("johndoe")).thenReturn(Optional.of(user));

        userService.deleteUser("johndoe");

        // ASSERT
        verify(userRepository, times(1)).delete(user);
    }

}
