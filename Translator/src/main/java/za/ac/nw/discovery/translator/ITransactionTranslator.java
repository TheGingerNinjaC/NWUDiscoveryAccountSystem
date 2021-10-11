package za.ac.nw.discovery.translator;

import za.ac.nw.discovery.domain.dto.AccountTransactionDto;

import java.util.List;

public interface ITransactionTranslator {

    List<AccountTransactionDto> getAllMilesTransactions();
    AccountTransactionDto createTransaction(AccountTransactionDto transactionDto);

    AccountTransactionDto addMiles(AccountTransactionDto accountTransactionDto);
}
