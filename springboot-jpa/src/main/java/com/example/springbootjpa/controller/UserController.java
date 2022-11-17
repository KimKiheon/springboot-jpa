package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.domain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/articles")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    public String Select(@PathVariable Long id, Model model) {
        Optional<User> optionalArticle = userRepository.findById(id);
        if (optionalArticle.isEmpty()) return "users/error";
        model.addAttribute("article",optionalArticle.get());
        return "users/show";
    }
}
