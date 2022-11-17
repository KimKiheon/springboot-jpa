package com.example.springbootjpa.domain.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    private String username;
    private String password;
    private String message;
    public UserResponse(String username, String password){
        this.username=username;
        this.password=password;
    }
}
