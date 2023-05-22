package com.dw.dwtestserver01.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberEntity memberPostDtoToMember(MemberDto.Post memberPostDto);

    MemberDto.Response memberToMemberResponse(MemberEntity createdMember);

    List<MemberDto.Get> getAllOfMember(List<MemberEntity> getMember);

    List<MemberDto.Get> getMemberByUserId(List<MemberEntity> userId);

}
