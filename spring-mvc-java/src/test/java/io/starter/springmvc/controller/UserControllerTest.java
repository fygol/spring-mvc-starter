package io.starter.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.starter.springmvc.config.RootConfig;
import io.starter.springmvc.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    WebApplicationContext ctx;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testGetById() throws Exception {
        mockMvc
            .perform(get("/user/1").accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());
    }
}
