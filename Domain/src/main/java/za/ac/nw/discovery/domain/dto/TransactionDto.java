package za.ac.nw.discovery.domain.dto;

import za.ac.nw.discovery.domain.persistence.Transaction;

import java.io.Serializable;
import java.time.LocalDate;

public class TransactionDto implements Serializable {

    private Long accountTypeId;
    private Long memberId;
    private Double amount;
    private LocalDate transactionDate;

    public TransactionDto() {
    }

    public TransactionDto(Long accountTypeId, Long memberId, Double amount, LocalDate transactionDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionDto(Transaction transaction){
        this.setAccountTypeId(transaction.getAccountTypeId());
        this.setMemberId(transaction.getMemberId());
        this.setAmount(transaction.getAmount());
        this.setTransactionDate(transaction.getTransactionDate());
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
}
