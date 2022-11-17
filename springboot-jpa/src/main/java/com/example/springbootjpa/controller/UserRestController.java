package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.UserRequest;
import com.example.springbootjpa.domain.dto.UserResponse;
import com.example.springbootjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Long id) {
        UserResponse userResponse = userService.getUser(id);
        return ResponseEntity.ok().body(userResponse);
    }
    @PostMapping ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.add(userRequest);
        return ResponseEntity.ok().body(userResponse);
    }
}
