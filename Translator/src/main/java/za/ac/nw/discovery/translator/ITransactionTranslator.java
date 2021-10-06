package za.ac.nw.discovery.translator;

import za.ac.nw.discovery.domain.dto.TransactionDto;

import java.util.List;

public interface ITransactionTranslator {

    List<TransactionDto> getAllMilesTransactions();
}
