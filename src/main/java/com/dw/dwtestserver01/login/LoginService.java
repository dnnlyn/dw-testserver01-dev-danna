package com.dw.dwtestserver01.login;


import com.dw.dwtestserver01.Member.MemberDto;
import com.dw.dwtestserver01.Member.MemberEntity;
import com.dw.dwtestserver01.Member.MemberRepository;
import com.dw.dwtestserver01.common.exception.ExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class LoginService {
    private final MemberRepository memberRepository;
    /*private final MemberDto.Login memberDto;*/

    public LoginService(MemberRepository memberRepository/*, MemberDto.Login memberDto*/) {
        this.memberRepository = memberRepository;
        /*this.memberDto = memberDto;*/
    }

    public String Login(LoginDto.Post logindto) {
    Optional<MemberEntity> optionalMember =  memberRepository.findByUserId(logindto.getUserId());

        if (optionalMember.isEmpty()) {
        return "User Cannot Be Found";
    }
    MemberEntity foundMember = optionalMember.orElseThrow();
        if (!logindto.getPassword().equals(foundMember.getPassword())) {
        return "Login is not Successful";
    }
        return "Login Successful";
}
    /*    if (memberDto.getUserId().equals(logindto.getUserId()) &&
                memberDto.getPassword().equals(logindto.getPassword())) {
                return true;
        }
        return false;
    }*/
}
