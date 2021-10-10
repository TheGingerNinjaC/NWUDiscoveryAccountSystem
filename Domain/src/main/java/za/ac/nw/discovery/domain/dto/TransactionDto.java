package za.ac.nw.discovery.domain.dto;

import io.swagger.annotations.ApiModel;
import za.ac.nw.discovery.domain.persistence.Transaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Transaction",
description = "A DTO that represents the Transaction")
public class TransactionDto implements Serializable {

    private Long accountId;
    private Double amount;
    private LocalDate transactionDate;

    public TransactionDto() {
    }

    public TransactionDto(Long accountId, Double amount, LocalDate transactionDate) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionDto(Transaction transaction){
        this.setAccountId(transaction.getAccountId());
        this.setAmount(transaction.getAmount());
        this.setTransactionDate(transaction.getTransactionDate());
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountTypeId) {
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
        TransactionDto that = (TransactionDto) o;
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
}
