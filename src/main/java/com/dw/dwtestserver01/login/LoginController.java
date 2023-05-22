package com.dw.dwtestserver01.login;

import com.dw.dwtestserver01.Member.MemberDto;
import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping
    public ResponseEntity login(@Valid @RequestBody LoginDto.Post loginDto) {
        return new ResponseEntity<>(
                new SingleResponseDto<>(loginService.Login(loginDto)), HttpStatus.ACCEPTED
        );
    }
}
