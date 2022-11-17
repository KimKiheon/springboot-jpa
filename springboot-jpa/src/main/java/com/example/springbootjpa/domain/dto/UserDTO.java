package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    public User toEntity(){
        return new User(this.id, this.username, this.password);
    }
}
