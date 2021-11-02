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

class CustomerAssistEmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerAssistEmployeeRepository customerAssistEmployeeRepository;

    @Test
    void testFindAllByLastName() {
        // given
        CustomerAssistEmployee customerAssistEmployee = new CustomerAssistEmployee();
        customerAssistEmployee.setLastName("Manson");
        entityManager.persist(customerAssistEmployee);
        entityManager.flush();

        // when
        Collection<CustomerAssistEmployee> found = customerAssistEmployeeRepository.findAllByLastName(customerAssistEmployee.getLastName());

        // then
        String expected = "Manson";
        String actual = customerAssistEmployee.getLastName();
        assertEquals(expected, actual);
    }


}

 */