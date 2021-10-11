package za.ac.nw.discovery.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.AccountTransactionDto;
import za.ac.nw.discovery.domain.persistence.AccountTransaction;
import za.ac.nw.discovery.repository.persistence.AccountTransactionRepository;
import za.ac.nw.discovery.translator.ITransactionTranslator;

import java.util.List;

@Component
public class TransactionTranslator implements ITransactionTranslator {

    private final AccountTransactionRepository transactionRepository;

    @Autowired
    public TransactionTranslator(AccountTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<AccountTransactionDto> getAllMilesTransactions() {
        return null;
    }

    @Override
    public AccountTransactionDto createTransaction(AccountTransactionDto transactionDto) {
        try{
            AccountTransaction transaction = transactionRepository.save(transactionDto.getTransaction());
            return new AccountTransactionDto(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTransactionDto addMiles(AccountTransactionDto accountTransactionDto) {
        try{
            AccountTransaction transaction = transactionRepository.save(accountTransactionDto.getTransaction());
            return new AccountTransactionDto(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
