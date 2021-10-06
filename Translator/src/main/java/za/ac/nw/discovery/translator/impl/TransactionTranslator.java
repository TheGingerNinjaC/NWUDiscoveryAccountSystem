package za.ac.nw.discovery.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.TransactionDto;
import za.ac.nw.discovery.repository.persistence.TransactionRepository;
import za.ac.nw.discovery.translator.ITransactionTranslator;

import java.util.List;

@Component
public class TransactionTranslator implements ITransactionTranslator {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionTranslator(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDto> getAllMilesTransactions() {
        return null;
    }
}
