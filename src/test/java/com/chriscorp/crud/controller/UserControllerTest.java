package com.chriscorp.crud.controller;


import com.chriscorp.crud.CrudApplication;
import com.chriscorp.crud.model.User;
import com.chriscorp.crud.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//@ExtendWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ CrudApplication.class })
class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    private void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

//    @Test
//    void getAllUser() {
//    }

//    @Test
//    public void whenGetAllUser_then200IsReceived() throws IOException {
//
//        // Given
////        String name = RandomStringUtils .randomAlphabetic( 8 );
//        HttpUriRequest request = new HttpGet( "/api/user");
//
//        // When
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
//
//        // Then
//        assertThat(
//                httpResponse.getStatusLine().getStatusCode(),
//                equalTo(HttpStatus.SC_OK));
//    }

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
//                LocalDate.of(2000,10,10),
//                "chris@gmail.com",
//                "1235684");
//        mockMvc.perform(get("/api/user/1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }








}