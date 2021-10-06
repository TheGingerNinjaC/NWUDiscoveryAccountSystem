package za.ac.nw.discovery.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.AccountTypeDto;
import za.ac.nw.discovery.logic.flow.IFetchAccountTypeFlow;
import za.ac.nw.discovery.translator.impl.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlow implements IFetchAccountTypeFlow {

    public final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlow(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        return accountTypeTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }
}
