package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.UserResponse;
import com.example.springbootjpa.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Test
    @DisplayName("유저 정보 조회")
    void getUser() throws Exception {
        UserResponse userResponse = new UserResponse("kiheon", "1123");
        given(userService.getUser(1L)).willReturn(userResponse);
        Integer id = 1;
        String url = String.format("/api/v1/users/%d",id);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.username").value("kiheon"))
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.password").value("1123"))
                .andDo(print());
        verify(userService).getUser(1L);

    }
}
