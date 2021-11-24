package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.ProductionComplaint;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

class ProductionComplaintRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductionComplaintRepository productionComplaintRepository;

    @Test
    void testFindById() {
        // Arrange
        ProductionComplaint productionComplaint = new ProductionComplaint();
        productionComplaint.setId(1L);
        entityManager.persist(productionComplaint);
        entityManager.flush();

        // Act
        Optional<ProductionComplaint> found = productionComplaintRepository.findById(productionComplaint.getId());

        // Assert
        Long expected = 1L;
        Long actual = found.get().getId();
        assertEquals(expected, actual);
    }
}
