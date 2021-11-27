package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerComplaint;
import nl.quin.complaintservicesystem.repository.CustomerComplaintRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void testGetCustomerComplaintByIdThrowException() {
        when(customerComplaintRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            customerComplaintService.getCustomerComplaintById(1L);

        });
    }

    @Test
    public void testGetCustomerComplaint() {
        customerComplaint = new CustomerComplaint();
        customerComplaint.setId(1L);
        customerComplaint.setOrderNumber("777");

        Mockito

                .when(customerComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(customerComplaint));

        String expected = "777";

        customerComplaintService.getCustomerComplaintById(1L);
        assertEquals(expected, customerComplaint.getOrderNumber());
    }

    @Test
    public void createCustomerComplaintTest() {
        customerComplaint = new CustomerComplaint();
        customerComplaint.setId(1L);
        customerComplaint.setOrderNumber("777");
        customerComplaint.setCustomerCommentary("No Colours");

        customerComplaintRepository.save(customerComplaint);

        verify(customerComplaintRepository, times(1)).save(customerComplaintCaptor.capture());
        var customerComplaint1 = customerComplaintCaptor.getValue();

        assertThat(customerComplaint1.getOrderNumber()).isEqualTo("777");
        assertThat(customerComplaint1.getCustomerCommentary()).isEqualTo("No Colours");
        assertThat(customerComplaint1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCustomerComplaintDeleteThrowExceptionTest() {
        assertThrows(UserNotFoundException.class, () -> customerComplaintService.getCustomerComplaintById(1L));
    }

    @Test
    public void deleteCustomerComplaintTest() {
        customerComplaint = new CustomerComplaint();
        customerComplaint.setId(1L);
        customerComplaint.setOrderNumber("777");

        customerComplaintRepository.delete(customerComplaint);

        Mockito

                .when(customerComplaintRepository
                        .findById(1L)).thenReturn(Optional.of(customerComplaint));

        customerComplaintService.deleteCustomerComplaint(1L);
        verify(customerComplaintRepository, times(1)).delete(customerComplaint);
    }

}