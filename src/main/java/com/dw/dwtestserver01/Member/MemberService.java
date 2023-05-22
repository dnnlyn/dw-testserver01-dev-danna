package com.dw.dwtestserver01.Member;
import com.dw.dwtestserver01.common.exception.BusinessLogicException;
import com.dw.dwtestserver01.common.exception.ExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository,
                         MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }


    public MemberEntity createMember(MemberDto.Post memberPostDto) {
        MemberEntity savedMember = memberRepository.save(memberMapper.memberPostDtoToMember(memberPostDto));
        return savedMember;
    }

    public List<MemberEntity> getAllMember(MemberDto.Get getMember){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MemberEntity findByUserId(String userId) {
        Optional<MemberEntity> optionalMember = memberRepository.findByUserId(userId);
        return optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

}
