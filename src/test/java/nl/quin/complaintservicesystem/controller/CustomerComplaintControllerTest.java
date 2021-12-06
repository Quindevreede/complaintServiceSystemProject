package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.service.CustomerComplaintService;
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
public class CustomerComplaintControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CustomerComplaintService customerComplaintService;

    @Test
    void initialEndpointTestIfUnauthorized() throws Exception {

        // ACT
        mvc.perform(get("/customer_complaint"))

                // ASSERT
                .andExpect(status().isOk());
    }

}
