package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface MemberTranslator {

    List<MemberDto> getAllmembers();

    MemberDto create(MemberDto memberDto);

    MemberDto getMemberByMemberIdNativeQuery(String memberId);

    MemberDto getMemberByMemberId(String member);

    MemberDto getMemberDtoByMemberId(String memberId);

    void someMethod();
}
