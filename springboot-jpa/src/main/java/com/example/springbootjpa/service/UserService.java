package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserResponse;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponse getArticle(Long id){
        Optional<User> optionalArticle = userRepository.findById(id);
        if(optionalArticle.isPresent()){
            User user = optionalArticle.get();
            return User.of(user);
        }
        return null;
    }
}
