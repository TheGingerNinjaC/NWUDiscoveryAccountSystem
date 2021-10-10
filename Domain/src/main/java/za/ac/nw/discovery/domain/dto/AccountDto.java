package za.ac.nw.discovery.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import za.ac.nw.discovery.domain.persistence.Account;
import za.ac.nw.discovery.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Account",
description = "A DTO representing the Account")
public class AccountDto implements Serializable {

    private Long accountTypeId;
    private Long memberId;
    private Double balance;
    private LocalDate openDate;

    public AccountDto() {
    }

    public AccountDto(Long accountTypeId, Long memberId, Double balance, LocalDate openDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.balance = balance;
        this.openDate = openDate;
    }

    public AccountDto(Account account) {
        this.setAccountTypeId(account.getAccountTypeId());
        this.setMemberId(account.getMemberId());
        this.setBalance(account.getBalance());
        this.setOpenDate(account.getOpenDate());
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(balance, that.balance) && Objects.equals(openDate, that.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, memberId, balance, openDate);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }

    @JsonIgnore
    public Account getAccount() {
        return new Account(getAccountTypeId(), getMemberId(), getBalance(), getOpenDate());
    }
}
