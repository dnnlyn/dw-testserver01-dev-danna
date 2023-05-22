package com.dw.dwtestserver01.login;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;

@Getter
public class LoginDto {
    @Data
    public static class Post {
        @NotBlank
        private String userId;
        @NotBlank
        private String password;
    }
}
