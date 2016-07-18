package io.starter.springmvc.controller;

import io.starter.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {
        if(errors.hasErrors()) {
            System.out.println("Validation errors");
        } else {
            System.out.println("Validation ok");
        }

        user.setTimestamp(System.currentTimeMillis());

        return user;
    }

}
