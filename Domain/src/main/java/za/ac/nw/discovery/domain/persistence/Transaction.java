package za.ac.nw.discovery.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="Transaction")
public class Transaction implements Serializable {

    private Long transactionId;
    private Long accountId;
    private Double amount;
    private LocalDate transactionDate;

    public Transaction() {
    }

    public Transaction(Long transactionId, Long accountId, Double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Transaction(Long accountId, Double amount, LocalDate transactionDate) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @Column(name = "Transaction_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getTransactionId() {
        return transactionId;
    }

    @Column(name = "Account_Id")
    public Long getAccountId() {
        return accountId;
    }

    @Column(name = "Amount")
    public Double getAmount() {
        return amount;
    }

    @Column(name = "Transaction_Date")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountId, that.accountId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountTypeId=" + accountId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
