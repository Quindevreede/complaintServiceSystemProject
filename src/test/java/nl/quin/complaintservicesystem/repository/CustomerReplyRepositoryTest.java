package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.CustomerReply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

class CustomerReplyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerReplyRepository customerReplyRepository;

    @Test
    void testFindByIdWithMandatoryFields() {

        // ARRANGE
        CustomerReply customerReply = new CustomerReply();
        customerReply.setId(1L);
        customerReply.setReprintOrRefund("REPRINT");
        entityManager.persist(customerReply);
        entityManager.flush();

        // ACT
        Optional<CustomerReply> found = customerReplyRepository.findById(customerReply.getId());

        // ASSERT
        Long expected = 1L;
        Long actual = found.get().getId();
        assertEquals(expected, actual);
    }
}
