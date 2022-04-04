package net.idrok.tester.controller;

import com.fasterxml.jackson.annotation.OptBoolean;
import net.idrok.tester.entity.User;
import net.idrok.tester.security.UserMaxsus;
import net.idrok.tester.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserMaxsus userMaxsus){

        return "token qaytar";
    }
}
