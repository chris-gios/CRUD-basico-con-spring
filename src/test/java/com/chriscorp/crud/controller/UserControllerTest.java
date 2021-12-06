package com.chriscorp.crud.controller;


import com.chriscorp.crud.model.User;
import com.chriscorp.crud.service.userImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//@ExtendWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {CrudApplication.class})
//@WebMvcTest(value = UserController.class)
//@WebMvcTest
//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @InjectMocks
//    private UserController userController;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;



    @Test
    void getAllUser() {
    }

    @Test
    @DisplayName("Test getAllUser()")
    public void findAllUsers_InputsAreValid_ReturnUserList() throws Exception {
        when(userService.getAllUser()).thenReturn(Arrays.asList(new User()));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user"));

        verify(userService, times(1)).getAllUser();
    }

//    @Test
//    public void whenGetAllUser_then200IsReceived() throws IOException {
//
//        // Given
//        String name = RandomStringUtils.randomAlphabetic(8);
//        HttpUriRequest request = new HttpGet("/api/user");
//
//        // When
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//
//        // Then
//        assertThat(
//                httpResponse.getStatusLine().getStatusCode(),
//                equalTo(HttpStatus.SC_OK));
//    }
//
//    @Test
//    public void whenGetAllUser_then200IsReceived() throws Exception {
//        mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void whenGetUserById_then200IsReceived() throws Exception {
//        User user = new User(1,
//                "Chris",
//                "test",
//                20,
//                LocalDate.of(2000, 10, 10),
//                "chris@gmail.com",
//                "1235684");
//        mockMvc.perform(get("/api/user/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }


}