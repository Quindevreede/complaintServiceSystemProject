package nl.quin.complaintservicesystem.controller;


import nl.quin.complaintservicesystem.ComplaintServiceSystemApplication;
import nl.quin.complaintservicesystem.model.User;
import nl.quin.complaintservicesystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
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
@ContextConfiguration(classes={ComplaintServiceSystemApplication.class})
class UserCustomerComplaintControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername("johndoe");
        this.user.setPassword("p4ssw0rd");
    }

    @Test
    public void testEndpointGetAllUsers() throws Exception {

        User user = new User();
        List<User> allUsers = Arrays.asList(user);

 //       given(service.getAllUsers()).willReturn(allUsers);
        given(service.getUsers()).willReturn(allUsers);

        mvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].lastName", is("johndoe")));
//TODO klopt $[0].lastName? Heb al userName geprobeerd..
//TODO No qualifying bean of type 'nl.quin.complaintservicesystem.service.UserAuthenticateService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
    }

}