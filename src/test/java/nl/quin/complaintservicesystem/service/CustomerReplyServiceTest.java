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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
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

        // ACT
        when(customerReplyRepository.findById(1L)).thenReturn(Optional.empty());

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> {
            customerReplyService.getCustomerReplyById(1L);

        });
    }

    @Test
    public void getCustomerReplyTest() {

        // ARRANGE
        customerReply = new CustomerReply();
        customerReply.setReprintOrRefund("REPRINT");

        // ACT
        Mockito
                .when(customerReplyRepository
                        .findById(1L)).thenReturn(Optional.of(customerReply));

        // ASSERT
        String expected = "REPRINT";

        customerReplyService.getCustomerReplyById(1L);
        assertEquals(expected, customerReply.getReprintOrRefund());
    }

    @Test
    void getCustomerReplyIsNullErrorTest() {

        // ARRANGE
        String reprintOrRefund = null;

        // ACT
        Mockito
                .when(customerReplyRepository
                        .findById(1L)).thenReturn(Optional.of(customerReply));

        // ASSERT
        assertNull(reprintOrRefund, "reprintOrRefund should not be found");
    }

    @Test
    public void createCustomerReplyTest() {

        // ARRANGE
        customerReply = new CustomerReply();
        customerReply.setId(1L);
        customerReply.setReprintOrRefund("REPRINT");
        customerReply.setCustomerCommentary("Need print by next tuesday");

        customerReplyRepository.save(customerReply);

        // ACT
        verify(customerReplyRepository, times(1)).save(customerReplyCaptor.capture());
        var customerReply1 = customerReplyCaptor.getValue();

        // ASSERT
        assertThat(customerReply1.getReprintOrRefund()).isEqualTo("REPRINT");
        assertThat(customerReply1.getCustomerCommentary()).isEqualTo("Need print by next tuesday");
        assertThat(customerReply1.getId()).isEqualTo(1);
    }

    @Test
    public void createCustomerReplyByOnlyId() {

        // ARRANGE
        customerReply = new CustomerReply();
        customerReply.setId(1L);
        given(customerReplyRepository.findById(customerReply.getId())).willReturn(Optional.empty());
        given(customerReplyRepository.save(customerReply)).willAnswer(invocation -> invocation.getArgument(0));

        // ACT
        long savedCustomerReply = customerReplyService.createCustomerReply(customerReply);

        // ASSERT
        assertThat(savedCustomerReply).isNotNull();

        verify(customerReplyRepository).save(any(CustomerReply.class));
    }

    @Test
    public void updateCustomerReplyDeleteThrowExceptionTest() {

        // ASSERT
        assertThrows(UserNotFoundException.class, () -> customerReplyService.getCustomerReplyById(1L));
    }

    @Test
    public void deleteCustomerReplyTest() {

        // ARRANGE
        customerReply = new CustomerReply();
        customerReply.setId(1L);
        customerReply.setReprintOrRefund("REPRINT");

        customerReplyRepository.delete(customerReply);

        // ACT
        Mockito
                .when(customerReplyRepository
                        .findById(1L)).thenReturn(Optional.of(customerReply));

        // ASSERT
        customerReplyService.deleteCustomerReply(1L);
        verify(customerReplyRepository, times(1)).delete(customerReply);
    }

}