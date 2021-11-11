package nl.quin.complaintservicesystem.controller;
/*
import nl.quin.complaintservicesystem.TestJunitJupiterApplication;
import nl.quin.complaintservicesystem.model.CustomerDetails;
import nl.quin.complaintservicesystem.service.CustomerDetailsService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration(classes={TestJunitJupiterApplication.class})
public class CustomerDetailsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerDetailsService customerDetailsService;

    @Test
    public void testEndpointCustomers() throws Exception {

        CustomerDetails customerDetails = new CustomerDetails("Albert", "Einstein");
        List<CustomerDetails> allCustomers = Arrays.asList(customerDetails);

        given(customerDetailsService.getAllCustomerDetails()).willReturn(allCustomerDetails);

        mvc.perform(get("/customer_details")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].lastName", is(customerDetails.getLastName())));
    }

}
*/

