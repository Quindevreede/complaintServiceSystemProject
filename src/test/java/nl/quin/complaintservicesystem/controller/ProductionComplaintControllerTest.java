package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.service.ProductionComplaintService;
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
public class ProductionComplaintControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ProductionComplaintService productionComplaintService;

    @Test
    void initialEndpointTestIfUnauthorized() throws Exception {

        // ACT
        mvc.perform(get("/production_complaint"))

        // ASSERT
                .andExpect(status().isUnauthorized());
    }

}