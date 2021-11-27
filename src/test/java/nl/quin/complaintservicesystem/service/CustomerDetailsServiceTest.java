package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.UserNotFoundException;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.repository.CustomerDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerDetailsServiceTest {

    @Mock
    CustomerDetails customerDetails;

    @InjectMocks
    CustomerDetailsService customerDetailsService;

    @Mock
    CustomerDetailsRepository customerDetailsRepository;

    @Captor
    ArgumentCaptor<CustomerDetails> customerDetailsCaptor;

    @Test
    void getAllAssistComplaintsTest() {
        List<CustomerDetails> customerDetails = new ArrayList();
        customerDetails.add(new CustomerDetails(1L,"John", "Doe", "johndoe@hotmail.com"));
        customerDetails.add(new CustomerDetails(2L,"John", "Doe", "johndoe@hotmail.com"));
        customerDetails.add(new CustomerDetails(3L,"John", "Doe", "johndoe@hotmail.com"));

        given(customerDetailsRepository.findAll()).willReturn(customerDetails);

        List<CustomerDetails> expected = customerDetailsService.customerDetailsRepository.findAll();
        assertEquals(expected,customerDetails);
    }

    @Test
    void getCustomerDetailsByIdThrowExceptionTest() {
        when(customerDetailsRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            customerDetailsService.getCustomerById(1L);

        });
    }

    @Test
    public void getCustomerTest() {
        customerDetails = new CustomerDetails();
        customerDetails.setLastName("Doe");
        customerDetails.setId(1L);

        Mockito

                .when(customerDetailsRepository
                        .findById(1L)).thenReturn(Optional.of(customerDetails));

        String expected = "Doe";

        customerDetailsService.getCustomerById(1L);
        assertEquals(expected, customerDetails.getLastName());
    }

    @Test
    public void createCustomerTest() {
        customerDetails = new CustomerDetails();
        customerDetails.setId(1L);
        customerDetails.setFirstName("John");
        customerDetails.setLastName("Doe");
        customerDetails.setEmail("johndoe@hotmail.com");

        customerDetailsRepository.save(customerDetails);

        verify(customerDetailsRepository, times(1)).save(customerDetailsCaptor.capture());
        var customerDetails1 = customerDetailsCaptor.getValue();

        assertThat(customerDetails1.getFirstName()).isEqualTo("John");
        assertThat(customerDetails1.getLastName()).isEqualTo("Doe");
        assertThat(customerDetails1.getEmail()).isEqualTo("johndoe@hotmail.com");
        assertThat(customerDetails1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCustomerThrowExceptionTest() {
        assertThrows(UserNotFoundException.class, () -> customerDetailsService.getCustomerById(1L));
    }

    @Test
    public void deleteCustomerDetailsTest() {
        customerDetails = new CustomerDetails();
        customerDetails.setId(1L);
        customerDetails.setLastName("Doe");

        customerDetailsRepository.delete(customerDetails);

        Mockito

                .when(customerDetailsRepository
                        .findById(1L)).thenReturn(Optional.of(customerDetails));

        customerDetailsService.deleteCustomer(1L);
        verify(customerDetailsRepository, times(1)).delete(customerDetails);
    }

}



