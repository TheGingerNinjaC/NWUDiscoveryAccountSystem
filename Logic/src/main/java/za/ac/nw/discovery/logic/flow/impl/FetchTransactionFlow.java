package za.ac.nw.discovery.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.AccountDto;
import za.ac.nw.discovery.domain.dto.AccountTransactionDto;
import za.ac.nw.discovery.logic.flow.IFetchTransactionFlow;
import za.ac.nw.discovery.translator.impl.AccountTranslator;
import za.ac.nw.discovery.translator.impl.TransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Component
public class FetchTransactionFlow implements IFetchTransactionFlow {

    public final TransactionTranslator transactionTranslator;
    public final AccountTranslator accountTranslator;

    @Autowired
    public FetchTransactionFlow(TransactionTranslator transactionTranslator, AccountTranslator accountTranslator) {
        this.transactionTranslator = transactionTranslator;
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<AccountTransactionDto> getAllMilesTransactions() {
        return transactionTranslator.getAllMilesTransactions();
    }

    @Override
    public AccountTransactionDto createTransaction(AccountTransactionDto transaction) {
        if (transaction.getTransactionDate() == null)
        {
            transaction.setTransactionDate(LocalDate.now());
        }

        return transactionTranslator.createTransaction(transaction);
    }

    @Override
    public AccountTransactionDto addMiles(AccountTransactionDto accountTransaction) {
        try {
            if (accountTransaction.getTransactionDate() == null) {
                accountTransaction.setTransactionDate(LocalDate.now());
            }
            AccountTransactionDto accountTransactionDto = transactionTranslator.createTransaction(accountTransaction);

            //now we need to update the account balance
            //get the current balance
            AccountDto accountDto = accountTranslator.getAccount(accountTransaction.getAccountId());
            Double balance = accountDto.getBalance() + accountTransaction.getAmount();

            accountTranslator.updateAccountBalance(accountTransaction.getAccountId(), balance);

            return accountTransactionDto;
        } catch (Exception e){
            throw new RuntimeException("Problem executing transaction", e);
        }
    }

    @Override
    public AccountTransactionDto subtractMiles(AccountTransactionDto accountTransaction) {
        try {
            AccountDto accountDto = accountTranslator.getAccount(accountTransaction.getAccountId());
            Double balance = accountDto.getBalance() - accountTransaction.getAmount();

            if (balance > 0) {
                if (accountTransaction.getTransactionDate() == null) {
                    accountTransaction.setTransactionDate(LocalDate.now());
                }
                AccountTransactionDto accountTransactionDto = transactionTranslator.createTransaction(accountTransaction);


                accountTranslator.updateAccountBalance(accountTransaction.getAccountId(), balance);

                return accountTransactionDto;
            }
            else
            {
                throw new RuntimeException("Insufficient funds");
            }
        } catch (Exception e){
            throw new RuntimeException("Problem executing transaction", e);
        }
    }
}
