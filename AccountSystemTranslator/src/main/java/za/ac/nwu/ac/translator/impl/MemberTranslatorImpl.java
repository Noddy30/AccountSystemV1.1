package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllmembers() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try {
            for (Member member : memberRepository.findAll()){
                memberDtos.add(new MemberDto(member));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return memberDtos;
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        try{
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public MemberDto getMemberByMemberIdNativeQuery(String memberId) {
        try{
            Member member = memberRepository.getMemberByMemberIdNativeQuery(memberId);
            return new MemberDto(member);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public MemberDto getMemberByMemberId(String memberId) {
        try{
            Member member = memberRepository.getMemberByMemberId(memberId);
            return new MemberDto(member);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public MemberDto getMemberDtoByMemberId(String memberId) {
        try{
            return memberRepository.getMemberDtoByMemberId(memberId);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public void someMethod() {

    }
}
