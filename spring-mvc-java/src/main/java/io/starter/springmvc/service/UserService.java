package io.starter.springmvc.service;

import io.starter.springmvc.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User findById(Long id) {
        User user = new User();
        user.setTimestamp(System.currentTimeMillis());
        user.setEmail("aaa@mail.com");
        user.setPassword("secret4u");

        return user;
    }
}
