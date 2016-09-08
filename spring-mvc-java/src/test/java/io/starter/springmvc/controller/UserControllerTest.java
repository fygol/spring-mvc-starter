package io.starter.springmvc.controller;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.starter.springmvc.config.RootConfig;
import io.starter.springmvc.config.WebConfig;
import io.starter.springmvc.domain.User;
import io.starter.springmvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class, UserControllerTest.Config.class})
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    WebApplicationContext ctx;

    @Autowired
    UserService userService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testGetById() throws Exception {
        User user = new User();
        user.setEmail("mock@mail.com");
        when(userService.findById(anyLong())).thenReturn(user);

        mockMvc
            .perform(get("/user/1").accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk());

        verify(userService).findById(anyLong());
    }

    @Configuration
    static class Config {

        @Bean
        UserService userService() {
            UserService userService = mock(UserService.class);
            return userService;
        }
    }
}
