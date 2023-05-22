package com.dw.dwtestserver01.Member;



import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.time.LocalDate;


@Data
@Builder
public class MemberDto {

    @Getter
    public static class Post {
        @NotBlank
        private String userId;
        @NotBlank
        private String password;
        @NotBlank
        private String fullName;
        @NotBlank
        private String address;
        @DateTimeFormat
        private LocalDate birthDay;
    }

    @Data
    public static class Response{
            @NotBlank
            private String userId;
            @NotBlank
            private String password;
            @NotBlank
            private String fullName;
            @NotBlank
            private String address;
            @DateTimeFormat
            private LocalDate birthDay;
    }

    @Data
    public static class Get{
        @NotBlank
        private String userId;
        @NotBlank
        private String fullName;
        @NotBlank
        private String address;
        @DateTimeFormat
        private LocalDate birthDay;
    }

    @Data
    public static class Login{
        @NotBlank
        private String userId;
        @NotBlank
        private String password;
    }
}
