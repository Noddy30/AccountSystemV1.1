package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(value = "Member",
        description = "A DTO that represents the Member")

public class MemberDto implements Serializable {

    private static final long serialVersionUID = 3430928232260107341L;

    private Integer memberId;
    private Long milesAmount;
    private LocalDate memberStartDate;

    public MemberDto() {
    }

    public MemberDto(Integer memberId, Long milesAmount, LocalDate memberStartDate) {
        this.memberId = memberId;
        this.milesAmount = milesAmount;
        this.memberStartDate = memberStartDate;
    }

    @ApiModelProperty(position=1,
            value= "Member ID",
            name="MEMBER_ID",
            notes="Unique Id for Member",
            dataType= "java.lang.Sting",
            example="156",
            required=true)
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }


    @ApiModelProperty(position=2,
            value= "Miles Amount",
            name="Miles Amount",
            notes="The amount of miles",
            dataType= "java.lang.String",
            example="5000",
            allowEmptyValue=false,
            required=true)
    public Long getMilesAmount() {
        return milesAmount;
    }

    public void setMilesAmount(Long milesAmount) {
        this.milesAmount = milesAmount;
    }


    @ApiModelProperty(position=3,
            value= "Member Start Date",
            name="Member Start Date",
            notes="Start Date",
            dataType= "java.lang.String",
            example="2020-01-01",
            allowEmptyValue=true,
            required=false)
    public LocalDate getMemberStartDate() {
        return memberStartDate;
    }

    public void setMemberStartDate(LocalDate memberStartDate) {
        this.memberStartDate = memberStartDate;
    }

    @JsonIgnore
    public Member getMember(){
        return new Member(getMemberId(),getMilesAmount(),getMemberStartDate());
    }

    public MemberDto(Member member){
        this.setMemberId(member.getMemberId());
        this.setMilesAmount(member.getMilesAmount());
        this.setMemberStartDate(member.getMemberStartDate());
    }


}
