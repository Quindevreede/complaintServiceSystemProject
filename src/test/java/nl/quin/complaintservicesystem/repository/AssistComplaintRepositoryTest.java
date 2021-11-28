package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

    @DataJpaTest
    @ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

    class AssistComplaintRepositoryTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private AssistComplaintRepository assistComplaintRepository;

        @Test
        void testFindById() {

            // ARRANGE
            AssistComplaint assistComplaint = new AssistComplaint();
            assistComplaint.setId(1L);
            entityManager.persist(assistComplaint);
            entityManager.flush();

            // ACT
            Optional<AssistComplaint> found = assistComplaintRepository.findById(assistComplaint.getId());

            // ASSERT
            Long expected = 1L;
            Long actual = found.get().getId();
            assertEquals(expected, actual);
        }
    }