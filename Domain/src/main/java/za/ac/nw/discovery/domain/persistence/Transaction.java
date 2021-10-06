package za.ac.nw.discovery.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="Transaction")
public class Transaction implements Serializable {

    private Long transactionId;
    private Long accountTypeId;
    private Long memberId;
    private Double amount;
    private LocalDate transactionDate;

    public Transaction() {
    }

    public Transaction(Long transactionId, Long accountTypeId, Long memberId, Double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @Column(name = "Transaction_Id")
    public Long getTransactionId() {
        return transactionId;
    }

    @Column(name = "Account_Type_Id")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    @Column(name = "Member_Id")
    public Long getMemberId() {
        return memberId;
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

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
