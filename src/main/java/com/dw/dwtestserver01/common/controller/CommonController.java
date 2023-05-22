package com.dw.dwtestserver01.common.controller;

import com.dw.dwtestserver01.common.dto.CommonDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
@Validated
public class CommonController {
    @PostMapping("/login")
    public String commonLogin(@Valid @RequestBody CommonDto.Login loginPostDto) {
        if (loginPostDto.getUser_id().equals("RINIER") && loginPostDto.getPassword().equals("123")) {
            return "valid";
        }

        if (loginPostDto.getUser_id().equals("JIMUEL") && loginPostDto.getPassword().equals("123")) {
            return "valid";
        }


        return "invalid";
    }
}
