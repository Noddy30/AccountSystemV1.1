package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.time.LocalDate;

public interface ModifyMemberFlow {
    MemberDto deleteMember(Long member);

    MemberDto updateMember(Long memberId, Long milesAmount, LocalDate memberStartDate);

    MemberDto updateMember(String memberId, String milesAmount, LocalDate memberStartDate);
}
