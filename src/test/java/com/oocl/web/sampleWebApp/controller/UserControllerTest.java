package com.oocl.web.sampleWebApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.web.sampleWebApp.model.User;
import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_201_status_when_create_user() throws Exception {

        User user = new User("444");
        ObjectMapper objectMapper = new ObjectMapper();
        String example= objectMapper.writeValueAsString(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(example))
                .andDo(print())
                .andExpect(status().isCreated());

    }
    @Test
    public void should_return_200_status_when_get_users() throws Exception {
        //String example=  "{\"name\":\"ddd\"}";
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
