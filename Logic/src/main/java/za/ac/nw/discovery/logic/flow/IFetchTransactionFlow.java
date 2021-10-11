package za.ac.nw.discovery.logic.flow;

import za.ac.nw.discovery.domain.dto.AccountTransactionDto;

import java.util.List;

public interface IFetchTransactionFlow {
    List<AccountTransactionDto> getAllMilesTransactions();
    AccountTransactionDto createTransaction(AccountTransactionDto transaction);

    AccountTransactionDto addMiles(AccountTransactionDto accountTransaction);
    AccountTransactionDto subtractMiles(AccountTransactionDto accountTransaction);
}
