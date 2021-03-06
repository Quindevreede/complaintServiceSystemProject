package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.ReceiptUpload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

class ReceiptUploadRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReceiptUploadRepository receiptUploadRepository;

    @Test
    void testFindById() {

        // ARRANGE
        ReceiptUpload receiptUpload = new ReceiptUpload();
        entityManager.persist(receiptUpload);
        entityManager.flush();

        // ACT
        Optional<ReceiptUpload> found = receiptUploadRepository.findById(receiptUpload.getId());

        // ASSERT
        Long expected = 7L;
        Long actual = found.get().getId();
        assertEquals(expected, actual);
    }
}