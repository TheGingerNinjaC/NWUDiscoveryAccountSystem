package za.ac.nw.discovery.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.TransactionDto;
import za.ac.nw.discovery.logic.flow.IFetchTransactionFlow;
import za.ac.nw.discovery.translator.impl.TransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchTransactionFlow implements IFetchTransactionFlow {

    public final TransactionTranslator transactionTranslator;

    @Autowired
    public FetchTransactionFlow(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public List<TransactionDto> getAllMilesTransactions() {
        return transactionTranslator.getAllMilesTransactions();
    }
}
