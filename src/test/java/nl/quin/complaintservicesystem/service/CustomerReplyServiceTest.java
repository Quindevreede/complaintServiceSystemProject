package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerReply;
import nl.quin.complaintservicesystem.repository.CustomerReplyRepository;
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
class CustomerReplyServiceTest {

    @Mock
    CustomerReply customerReply;

    @InjectMocks
    CustomerReplyService customerReplyService;

    @Mock
    CustomerReplyRepository customerReplyRepository;

    @Captor
    ArgumentCaptor<CustomerReply> customerReplyCaptor;

    @Test
    void testGetCustomerReplyByIdThrowException() {
        when(customerReplyRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            customerReplyService.getCustomerReplyById(1L);

        });
    }

    @Test
    public void testGetCustomerReply() {
        customerReply = new CustomerReply();
        customerReply.setReprintOrRefund("REPRINT");

        Mockito
                .when(customerReplyRepository
                        .findById(1L)).thenReturn(Optional.of(customerReply));

        String expected = "REPRINT";

        customerReplyService.getCustomerReplyById(1L);
        assertEquals(expected, customerReply.getReprintOrRefund());
    }

    @Test
    public void createCustomerReplyTest() {
        customerReply = new CustomerReply();
        customerReply.setId(1L);
        customerReply.setReprintOrRefund("REPRINT");
        customerReply.setCustomerCommentary("Need print by next tuesday");

        customerReplyRepository.save(customerReply);

        verify(customerReplyRepository, times(1)).save(customerReplyCaptor.capture());
        var customerReply1 = customerReplyCaptor.getValue();

        assertThat(customerReply1.getReprintOrRefund()).isEqualTo("REPRINT");
        assertThat(customerReply1.getCustomerCommentary()).isEqualTo("Need print by next tuesday");
        assertThat(customerReply1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCustomerReplyDeleteThrowExceptionTest() {
        assertThrows(UserNotFoundException.class, () -> customerReplyService.getCustomerReplyById(1L));
    }

    @Test
    public void deleteCustomerReplyTest() {
        customerReply = new CustomerReply();
        customerReply.setId(1L);
        customerReply.setReprintOrRefund("REPRINT");

        customerReplyRepository.delete(customerReply);

        Mockito
                .when(customerReplyRepository
                        .findById(1L)).thenReturn(Optional.of(customerReply));

        customerReplyService.deleteCustomerReply(1L);
        verify(customerReplyRepository, times(1)).delete(customerReply);
    }

}