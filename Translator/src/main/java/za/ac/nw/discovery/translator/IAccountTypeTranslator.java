package za.ac.nw.discovery.translator;

import za.ac.nw.discovery.domain.dto.AccountTypeDto;
import za.ac.nw.discovery.domain.persistence.AccountType;

import java.util.List;

public interface IAccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();
    AccountTypeDto create(AccountTypeDto accountTypeDto);
    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
