package net.idrok.tester.controller;

import com.fasterxml.jackson.annotation.OptBoolean;
import net.idrok.tester.entity.Role;
import net.idrok.tester.entity.User;
import net.idrok.tester.security.JwtUtil;
import net.idrok.tester.security.Token;
import net.idrok.tester.security.UserMaxsus;
import net.idrok.tester.service.UserService;
import net.idrok.tester.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(maxAge = 3600)
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/auth")
    public Token auth(@RequestBody UserMaxsus userMaxsus){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userMaxsus.getUsername(), userMaxsus.getPassword()));
        System.out.println();
        User u = userService.getByLogin(userMaxsus.getUsername()).get();
        String token = jwtUtil.generateToken(u.getLogin(), u.getRole().toString());
        return new Token(token);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody User user){
        return new UserDTO(userService.create(user));
    }

    @PostMapping("/update")
    public ResponseEntity<UserDTO> updateAccount(@RequestBody User user){
        if(getCurrentuser().getId() == user.getId())
        return ResponseEntity.ok(new UserDTO(userService.update(user)));
        return  ResponseEntity.badRequest().build();
    }

    @GetMapping("/current")
    public UserDTO getCurrentuser(){
        return userService.getCurrentUser();
    }
}
