package za.ac.nwu.ac.domain.exception;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "DEMO_ACCOUNT_TX", schema = "DISCOVERY")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = -8178985468958706058L;

    private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }
    @Id
    @SequenceGenerator(name= "DISCOVERY_SEQ", sequenceName= "ACCOUNT_SYSTEM.DISCOVERY_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "DISCOVERY_SEQ")
    @Column(name = "ACCOUNT_TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    //@Column(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountTypeId(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.Objects;
//
//@Table(name = "DEMO_ACCOUNT_TYPE", schema = "DISCOVERY")
//public class AccountTransaction implements Serializable {
//
//    private static final long serialVersionUID = -8178985468958706058L;
//
//    private Long transactionId;
//    private AccountType accountType;
//    private Long memberId;
//    private Long amount;
//    private LocalDate transactionDate;
//
//    public AccountTransaction() {
//    }
//
//    public AccountTransaction(Long transactionId, AccountType accountTypeId, Long memberId, Long amount, LocalDate transactionDate) {
//        this.transactionId = transactionId;
//        this.accountType = accountTypeId;
//        this.memberId = memberId;
//        this.amount = amount;
//        this.transactionDate = transactionDate;
//    }
//
//    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VIT_RSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
//    @Id
//    @Column(name = "TX_ID")
//    public Long getTransactionId() {
//        return transactionId;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ACCOUNT_TYPE_ID")
//    public AccountType getAccountType() {
//        return this.accountType;
//    }
//    public void setTransactionId(Long transactionId) {
//        this.transactionId = transactionId;
//    }
//
//    public void setAccountTypeId(AccountType accountType) {
//        this.accountType = accountType;
//    }
//
//    @Column(name = "MEMBER_ID")
//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }
//
//    @Column(name = "AMOUNT")
//    public Long getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Long amount) {
//        this.amount = amount;
//    }
//
//    @Column(name = "TX_DATE")
//    public LocalDate getTransactionDate() {
//        return transactionDate;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ACCOUNT_TYPE_ID")
//    public void setTransactionDate(LocalDate transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AccountTransaction that = (AccountTransaction) o;
//        return Objects.equals(transactionId, that.transactionId) &&
//                Objects.equals(accountType, that.accountType) &&
//                Objects.equals(memberId, that.memberId) &&
//                Objects.equals(amount, that.amount) &&
//                Objects.equals(transactionDate, that.transactionDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
//    }
//
//    @Override
//    public String toString() {
//        return "AccountTransaction{" +
//                "transactionId=" + transactionId +
//                ", accountType=" + accountType +
//                ", memberId=" + memberId +
//                ", amount=" + amount +
//                ", transactionDate=" + transactionDate +
//                '}';
//    }
//}
