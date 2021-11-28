package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.AssistComplaint;
import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerComplaintServiceTest {

    @Mock
    CustomerComplaint customerComplaint;

    @InjectMocks
    CustomerComplaintService customerComplaintService;

    @Mock
    CustomerComplaintRepository customerComplaintRepository;

    @Captor
    ArgumentCaptor<CustomerComplaint> customerComplaintCaptor;

    @Test
    void getAllCustomerComplaintsTest() {

        // ARRANGE
        List<CustomerComplaint> customerComplaints = new ArrayList();
        customerComplaints.add(new CustomerComplaint(1L, "111", "Faded Colours"));
        customerComplaints.add(new CustomerComplaint(2L, "222", "Too many Colours"));
        customerComplaints.add(new CustomerComplaint(3L, "333", "No Colours"));

        // ACT
        given(customerComplaintRepository.findAll()).willReturn(customerComplaints);

        // ASSERT
        List<CustomerComplaint> expected = customerComplaintService.customerComplaintRepository.findAll();
        assertEquals(expected,customerComplaints);
    }

    @Test
    void testGetCustomerComplaintByIdThrowException() {

        // ACT
        when(customerComplaintRepository.findById(1L)).thenReturn(Optional.empty());

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> {
            customerComplaintService.getCustomerComplaintById(1L);

        });
    }

    @Test
    void getCustomerComplaintIsNullErrorTest() {

        // ARRANGE
        String ordernumber = null;

        // ACT
        Mockito
                .when(customerComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(customerComplaint));

        // ASSERT
        assertNull(ordernumber, "ordernumber should not be found");
    }

    @Test
    public void testGetCustomerComplaint() {

        // ARRANGE
        customerComplaint = new CustomerComplaint();
        customerComplaint.setId(1L);
        customerComplaint.setOrderNumber("777");

        // ACT
        Mockito
                .when(customerComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(customerComplaint));

        // ASSERT
        String expected = "777";

        customerComplaintService.getCustomerComplaintById(1L);
        assertEquals(expected, customerComplaint.getOrderNumber());
    }

    @Test
    public void createCustomerComplaintTest() {

        // ARRANGE
        customerComplaint = new CustomerComplaint();
        customerComplaint.setId(1L);
        customerComplaint.setOrderNumber("777");
        customerComplaint.setCustomerCommentary("No Colours");

        customerComplaintRepository.save(customerComplaint);

        // ACT
        verify(customerComplaintRepository, times(1)).save(customerComplaintCaptor.capture());
        var customerComplaint1 = customerComplaintCaptor.getValue();

        // ASSERT
        assertThat(customerComplaint1.getOrderNumber()).isEqualTo("777");
        assertThat(customerComplaint1.getCustomerCommentary()).isEqualTo("No Colours");
        assertThat(customerComplaint1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCustomerComplaintDeleteThrowExceptionTest() {

        // ASSERT
           assertThrows(UserNotFoundException.class, () -> customerComplaintService.getCustomerComplaintById(1L));
    }

    @Test
    public void deleteCustomerComplaintTest() {

        // ARRANGE
        customerComplaint = new CustomerComplaint();
        customerComplaint.setId(1L);
        customerComplaint.setOrderNumber("777");

        customerComplaintRepository.delete(customerComplaint);

        // ACT
        Mockito
                .when(customerComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(customerComplaint));

        // ASSERT
        customerComplaintService.deleteCustomerComplaint(1L);
        verify(customerComplaintRepository, times(1)).delete(customerComplaint);
    }

}