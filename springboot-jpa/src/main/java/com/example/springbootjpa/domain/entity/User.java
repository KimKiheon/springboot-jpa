package com.example.springbootjpa.domain.entity;

import com.example.springbootjpa.domain.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getPassword());
    }
}
