/*package nl.quin.complaintservicesystem.repository;

import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;

@DataJpaTest
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})

class CustomerComplaintDetailsRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerComplaintDetailsRepository customerComplaintDetailsRepository;

    @Test
    void testFindAllByLastName() {
        // given
        CustomerComplaintDetails customerComplaintDetails = new CustomerComplaintDetails();
        customerComplaintDetails.setLastName("Doe");
        entityManager.persist(customerComplaintDetails);
        entityManager.flush();

        // when
        Collection<CustomerComplaintDetails> found = customerComplaintDetailsRepository.findAllByLastName(customerComplaintDetails.getLastName());

        // then
        String expected = "Doe";
        String actual = customerComplaintDetails.getLastName();
        assertEquals(expected, actual);
    }
}




 */