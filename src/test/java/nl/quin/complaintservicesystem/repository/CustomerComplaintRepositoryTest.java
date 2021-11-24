package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.CustomerComplaint;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

class CustomerComplaintRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerComplaintRepository customerComplaintRepository;

    @Test
    void testFindById() {
        // Arrange
        CustomerComplaint customerComplaint = new CustomerComplaint();
        entityManager.persist(customerComplaint);
        entityManager.flush();

        // Act
        Optional<CustomerComplaint> found = customerComplaintRepository.findById(customerComplaint.getId());

        // Assert
        Long expected = 1L;
        Long actual = found.get().getId();
        assertEquals(expected, actual);
    }
}
