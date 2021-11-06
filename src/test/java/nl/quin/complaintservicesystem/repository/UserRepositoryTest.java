package nl.quin.complaintservicesystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;
import java.util.Optional;


@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})
class UserRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private UserRepository userRepository;

    public User user = new User();

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername("johndoe");
        this.user.setPassword("se7en");
    }

    @Test
    void testFindByLastLast() {

        // Arrange

        entityManager.persist(user);
        entityManager.flush();

        // Act
        Optional<User> found = userRepository.findByUsername(user.getUsername());

        // Assert
        String expected = "johndoe";
        String actual = found.get().getUsername();
        assertEquals(expected, actual);
    }

}