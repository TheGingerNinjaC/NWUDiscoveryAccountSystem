package za.ac.nw.discovery.logic.flow;

import za.ac.nw.discovery.domain.dto.TransactionDto;

import java.util.List;

public interface IFetchTransactionFlow {
    List<TransactionDto> getAllMilesTransactions();
    TransactionDto createTransaction(TransactionDto transaction);
}
