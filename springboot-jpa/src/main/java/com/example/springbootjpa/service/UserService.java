package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserRequest;
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

    public UserResponse getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        UserResponse userResponse = User.toDTO(optionalUser.get());
        return userResponse;
    }

    public UserResponse add(UserRequest userRequest) {
        UserResponse userResponse;
        if (userRepository.findByUsername(userRequest.getUsername()).isEmpty()) {
            User newUser = userRepository.save(userRequest.toEntity());
            userResponse = User.toDTO((newUser));
            userResponse.setMessage("등록 완료");
        } else {
            userResponse = new UserResponse(userRequest.getUsername(), userRequest.getPassword());
            userResponse.setMessage("해당 username은 중복입니다");
        }
        return userResponse;
    }
}
