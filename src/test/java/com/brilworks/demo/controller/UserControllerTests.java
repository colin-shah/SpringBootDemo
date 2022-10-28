package com.brilworks.demo.controller;

import com.brilworks.demo.DTO.UserDTO;
import com.brilworks.demo.entity.User;
import com.brilworks.demo.repositories.UserRepositories;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
    }

    @Test
    @Order(1)
    void test_fetchAllUsers() throws Exception {
        // given - precondition or setup
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User("Colin Shah"));
        listOfUsers.add(new User("Shah Colin"));
        userRepositories.saveAll(listOfUsers);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/user"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        Matchers.is(listOfUsers.size())));

    }

    @Test
    @Order(2)
    void test_createUser() throws Exception {
        // given - precondition or setup
        UserDTO request = new UserDTO();
        request.setName("Colin Shah");

        // when - action or behaviour that we are going test
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(3)
    void test_fetchSingleUsers() throws Exception {
        // given - precondition or setup
        User user = new User("Colin Shah");
        userRepositories.save(user);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", Matchers.is(user.getName())));

    }
}
