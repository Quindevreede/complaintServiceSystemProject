package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
    @ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

    class CustomerDetailsRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Test
    void testFindByIdWithMandatoryFields() {

        // ARRANGE
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName("John");
        customerDetails.setLastName("Doe");
        customerDetails.setEmail("johndoe@hotmail.com");
        entityManager.persist(customerDetails);
        entityManager.flush();

        // ACT
        Optional<CustomerDetails> found = customerDetailsRepository.findById(customerDetails.getId());

        // ASSERT
        Long expected = 1L;
        Long actual = found.get().getId();
        assertEquals(expected, actual);
    }
}
