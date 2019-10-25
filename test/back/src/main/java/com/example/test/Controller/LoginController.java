package com.example.test.Controller;

import com.example.test.Forms.LoginForm;
import com.example.test.Service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String data) throws JsonProcessingException {
        LoginForm loginForm=objectMapper.readValue(data, LoginForm.class);
        userService.putNewOnlineUser(loginForm);
        return ResponseEntity.ok().build();
    }
}
