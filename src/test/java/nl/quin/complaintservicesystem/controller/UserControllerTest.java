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
    void indexTest() throws Exception {
        mvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void indexTest1() throws Exception {
        mvc.perform(get("/users/johndoe"))
                .andExpect(status().isOk());
    }

}



