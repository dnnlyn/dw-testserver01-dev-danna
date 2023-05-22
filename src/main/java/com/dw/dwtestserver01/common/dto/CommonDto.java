package com.dw.dwtestserver01.common.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class CommonDto {
    @Getter
    public static class Login {
        @NotBlank
        private String user_id;
        @NotBlank
        private String password;
    }
}
