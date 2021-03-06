package za.ac.nw.discovery.logic.flow;

import za.ac.nw.discovery.domain.dto.AccountTypeDto;

import java.util.List;

public interface IFetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
