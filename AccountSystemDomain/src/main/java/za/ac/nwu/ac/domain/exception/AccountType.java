package za.ac.nwu.ac.domain.exception;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "DISCOVERY")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 6801531496679307812L;
    @Id
    @SequenceGenerator(name= "DISCOVERY_SEQ", sequenceName= "ACCOUNT_SYSTEM.DISCOVERY_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "DISCOVERY_SEQ")

    private String AT_ID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate dateCreated;

    private Set<AccountTransaction>accountTransaction;

    public AccountType(String AT_ID, String mnemonic, String accountTypeName, LocalDate dateCreated) {
        this.AT_ID = AT_ID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.dateCreated = dateCreated;
    }

    public AccountType() {
    }
    @Column(name= "ACCOUNT_TYPE_ID")
    public String getAT_ID() {
        return AT_ID;
    }

    public void setAT_ID(String AT_ID) {
        this.AT_ID = AT_ID;
    }
    @Column(name= "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    @Column(name= "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    @Column(name= "CREATION_DATE")
    public LocalDate getDateCreated() {
        return dateCreated;
    }


    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransaction(){
        return accountTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(AT_ID, that.AT_ID) &&
                Objects.equals(mnemonic, that.mnemonic) &&
                Objects.equals(accountTypeName, that.accountTypeName) &&
                Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AT_ID, mnemonic, accountTypeName, dateCreated);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "AT_ID='" + AT_ID + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.Objects;
//import java.util.Set;
//
//
//@Table(name = "DEMO_ACCOUNT_TYPE", schema = "DISCOVERY")
//public class AccountType implements Serializable {
//
//    private static final long serialVersionUID = -8948619005714287927L;
//
//    private Long accountTypeId;
//    private String mnemonic;
//    private String accountTypeName;
//    private LocalDate creationDate;
//
//    private  Set<AccountTransaction> accountTransaction;
//
//    public AccountType() {
//    }
//
//    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
//        this.accountTypeId = accountTypeId;
//        this.mnemonic = mnemonic;
//        this.accountTypeName = accountTypeName;
//        this.creationDate = creationDate;
//    }
//
//    @Id
//    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VIT_RSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
//    @Column(name = "ACCOUNT_TYPE_ID")
//    public Long getAccountTypeId() {
//        return accountTypeId;
//    }
//
//    @Column(name = "MNEMONIC")
//    public String getMnemonic() {
//        return mnemonic;
//    }
//
//    @Column(name = "ACCOUNT_TYPE_NAME")
//    public String getAccountTypeName() {
//        return accountTypeName;
//    }
//
//    @Column(name = "CREATION_DATE")
//    public LocalDate getCreationDate() {
//        return creationDate;
//    }
//
//    public void setAccountTypeId(Long accountTypeId) {
//        this.accountTypeId = accountTypeId;
//    }
//
//    public void setMnemonic(String mnemonic) {
//        this.mnemonic = mnemonic;
//    }
//
//    public void setAccountTypeName(String accountTypeName) {
//        this.accountTypeName = accountTypeName;
//    }
//
//    public void setCreationDate(LocalDate creationDate) {
//        this.creationDate = creationDate;
//    }
//    @OneToMany(targetEntity = AccountTransaction.class, mappedBy = "accountType", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
//    public Set<AccountTransaction> getAccountTransaction(){
//        return accountTransaction;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AccountType that = (AccountType) o;
//        return Objects.equals(accountTypeId, that.accountTypeId) &&
//                Objects.equals(mnemonic, that.mnemonic) &&
//                Objects.equals(accountTypeName, that.accountTypeName) &&
//                Objects.equals(creationDate, that.creationDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
//    }
//
//    @Override
//    public String toString() {
//
//        return "AccountType{" +
//                "accountTypeId=" + accountTypeId +
//                ", mnemonic='" + mnemonic + '\'' +
//                ", accountTypeName='" + accountTypeName + '\'' +
//                ", creationDate=" + creationDate +
//                '}';
//    }
//}
