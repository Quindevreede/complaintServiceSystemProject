package nl.quin.complaintservicesystem.controller;

import nl.quin.complaintservicesystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    void initialEndpointTestIfOk() throws Exception {

        // ACT
        mvc.perform(get("/users"))

        // ASSERT
                .andExpect(status().isOk());
    }

    @Test
    void initialEndpointTestIfOk1() throws Exception {

        // ACT
        mvc.perform(get("/users/johndoe"))

        // ASSERT
                .andExpect(status().isOk());
    }

}



