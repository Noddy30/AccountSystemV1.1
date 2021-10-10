package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DISCOVERY_MEMBER", schema = "DISCOVERY")
public class Member implements Serializable {

    private static final long serialVersionUID = 6784182638615730900L;

    private Integer memberId;
    private Long accountType;
    private Long accountTransaction;
    private Long milesAmount;
    private LocalDate memberStartDate;

    public Member(Integer memberId, Long milesAmount, LocalDate memberStartDate) {
    }

    public Member(Long memberId, Long milesAmount, LocalDate memberStartDate) {
    }

    public Member(Integer memberId, Long accountType, Long accountTransaction, Long milesAmount, LocalDate memberStartDate) {
        this.memberId = memberId;
        this.accountType = accountType;
        this.accountTransaction = accountTransaction;
        this.milesAmount = milesAmount;
        this.memberStartDate = memberStartDate;
    }

//    public Member(String memberId, String milesAmount, LocalDate memberStartDate) {
//    }

    @Id
    @SequenceGenerator(name = "DISCOVERY_SEQ", sequenceName = "DISCOVERY.DISCOVERY_VITALITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISCOVERY_SEQ")
    @Column(name = "MEMBER_ID")
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    @ManyToOne(targetEntity = AccountType.class, fetch = FetchType.LAZY)
    public Long getAccountType() {
        return accountType;
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    @JoinColumn(name = "ACCOUNT_TX_ID")
    @ManyToOne(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY)
    public Long getAccountTransaction() {
        return accountTransaction;
    }

    public void setAccountTransaction(Long accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    @Column(name = "MILES_AMOUNT")
    public Long getMilesAmount() {
        return milesAmount;
    }

    public void setMilesAmount(Long milesAmount) {
        this.milesAmount = milesAmount;
    }

    @Column(name = "MEMBER_START_DATE")
    public LocalDate getMemberStartDate() {
        return memberStartDate;
    }

    public void setMemberStartDate(LocalDate memberStartDate) {
        this.memberStartDate = memberStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId) &&
                Objects.equals(accountType, member.accountType) &&
                Objects.equals(accountTransaction, member.accountTransaction) &&
                Objects.equals(milesAmount, member.milesAmount) &&
                Objects.equals(memberStartDate, member.memberStartDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountType, accountTransaction, milesAmount, memberStartDate);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", accountType=" + accountType +
                ", accountTransaction=" + accountTransaction +
                ", milesAmount=" + milesAmount +
                ", memberStartDate=" + memberStartDate +
                '}';
    }
}
