package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.service.CustomerDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerDetailsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CustomerDetailsService customerDetailsService;

    @Test
    void indexTest() throws Exception {
        mvc.perform(get("/customer_details"))
                .andExpect(status().isUnauthorized());
    }

}
