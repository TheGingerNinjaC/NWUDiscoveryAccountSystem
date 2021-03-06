package za.ac.nw.discovery.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import za.ac.nw.discovery.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction",
description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private Long accountId;
    private Double amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long accountId, Double amount, LocalDate transactionDate) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction transaction){
        this.setAccountId(transaction.getAccountId());
        this.setAmount(transaction.getAmount());
        this.setTransactionDate(transaction.getTransactionDate());
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }

    @JsonIgnore
    public AccountTransaction getTransaction() {
        return new AccountTransaction(getAccountId(), getAmount(), getTransactionDate());
    }
}
