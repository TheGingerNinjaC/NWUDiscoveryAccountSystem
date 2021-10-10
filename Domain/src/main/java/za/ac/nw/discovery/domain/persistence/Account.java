package za.ac.nw.discovery.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

    private Long accountId;
    private Long accountTypeId;
    private Long memberId;
    private Double balance;
    private LocalDate openDate;

    public Account() {
    }

    public Account(Long accountId, Long accountTypeId, Long memberId, Double balance, LocalDate openDate) {
        this.accountId = accountId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.balance = balance;
        this.openDate = openDate;
    }

    public Account(Long accountTypeId, Long memberId, Double balance, LocalDate openDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.balance = balance;
        this.openDate = openDate;
    }

    @Id
    @Column(name = "Account_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getAccountId() {
        return accountId;
    }

    @Column(name = "Account_Type_Id")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    @Column(name = "Member_Id")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "Balance")
    public Double getBalance() {
        return balance;
    }

    @Column(name = "Open_Date")
    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(accountTypeId, account.accountTypeId) && Objects.equals(memberId, account.memberId) && Objects.equals(balance, account.balance) && Objects.equals(openDate, account.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountTypeId, memberId, balance, openDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }
}
