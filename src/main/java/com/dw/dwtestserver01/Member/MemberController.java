package com.dw.dwtestserver01.Member;


import com.dw.dwtestserver01.common.dto.MultiResponseDto;
import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService,
                            MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post memberPostDto) {
        MemberEntity member = memberService.createMember(memberPostDto);
        MemberDto.Response response = memberMapper.memberToMemberResponse(member);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getAllMember(MemberDto.Get getMember){
    List <MemberEntity> member = memberService.getAllMember(getMember);
        return new ResponseEntity<>(
                new SingleResponseDto<>(memberMapper.getAllOfMember(member)),
                HttpStatus.OK
        );

    }

    @GetMapping("/{userId}")
    public ResponseEntity getMember(@PathVariable("userId") String userId) {
        List<MemberEntity> getMember = memberService.findByUserId(userId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(memberMapper.getMemberByUserId(getMember)),
                HttpStatus.OK
        );

    }

}
