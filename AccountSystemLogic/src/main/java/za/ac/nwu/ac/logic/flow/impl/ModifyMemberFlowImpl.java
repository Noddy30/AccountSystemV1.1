package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("modifyMemberFlowName")
public class ModifyMemberFlowImpl implements ModifyMemberFlow {


    private final MemberTranslator memberTranslator;

    @Autowired
    public ModifyMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto deleteMember(Long member) {
        return null;
    }

    @Override
    public MemberDto updateMember(Long memberId, Long milesAmount, LocalDate memberStartDate) {
        return null;
    }

    @Override
    public MemberDto updateMember(String memberId, String milesAmount, LocalDate memberStartDate) {
        return null;
    }
}
