package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface FetchMemberFlow {
    List<MemberDto> getAllMembers();

    MemberDto getMemberByMemberId(Long member);

    MemberDto getMemberByMemberId(String member);
}
