package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "DISCOVERY")
public class AccountType implements Serializable {


    private static final long serialVersionUID = 7419039683014995220L;

    @SequenceGenerator(name= "DISCOVERY_SEQ", sequenceName= "ACCOUNT_SYSTEM.DISCOVERY_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "DISCOVERY_SEQ")

    private String AT_ID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate dateCreated;

    public AccountType() {
    }

    public AccountType(String AT_ID, String mnemonic, String accountTypeName, LocalDate dateCreated) {
        this.AT_ID = AT_ID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.dateCreated = dateCreated;
    }
    @Id
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

    private Set<AccountTransaction> accountTransactions;

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(AT_ID, that.AT_ID) &&
                Objects.equals(mnemonic, that.mnemonic) &&
                Objects.equals(accountTypeName, that.accountTypeName) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AT_ID, mnemonic, accountTypeName, dateCreated, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "AT_ID='" + AT_ID + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", dateCreated=" + dateCreated +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}