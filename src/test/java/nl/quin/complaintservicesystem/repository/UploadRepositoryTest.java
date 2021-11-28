package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.Upload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

class UploadRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UploadRepository uploadRepository;

    @Test
    void testFindById() {

        // ARRANGE
        Upload upload = new Upload();
        entityManager.persist(upload);
        entityManager.flush();

        // ACT
        Optional<Upload> found = uploadRepository.findById(upload.getId());

        // ASSERT
        Long expected = 1L;
        Long actual = found.get().getId();
        assertEquals(expected, actual);
    }
}