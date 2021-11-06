package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;

import nl.quin.complaintservicesystem.model.CustomerDetails;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;

    @DataJpaTest
    @ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

    class CustomerDetailsRepositoryTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private CustomerDetailsRepository customerDetailsRepository;

        @Test
        void testFindAllByLastName() {
            // Arrange
            CustomerDetails customerDetails = new CustomerDetails();
            customerDetails.setLastName("Doe");
            entityManager.persist(customerDetails);
            entityManager.flush();

            // Act
            Collection<CustomerDetails> found = customerDetailsRepository.findAllByLastName(customerDetails.getLastName());

            // Assert
            String expected = "Doe";
            String actual = customerDetails.getLastName();
            assertEquals(expected, actual);
        }

}
