package com.Blog.demo.ControllerTest;

import antlr.build.Tool;
import com.Blog.demo.Controller.UserController;
import com.Blog.demo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void saveUserTest(){
    User usr1=new User(1L,"Abv","ewc","test@123gmail.com");
    Assertions.assertEquals("Abv",usr1.getUserFirstName());
    Assertions.assertFalse(usr1.getUserEmail().isEmpty());
    }

    @Test
    public void getUser() throws Exception {
        User usr1=new User(1L,"Abv","ewc","test@123gmail.com");
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
    }
}
