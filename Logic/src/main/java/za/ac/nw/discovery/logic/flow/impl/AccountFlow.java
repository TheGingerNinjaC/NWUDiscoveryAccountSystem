package za.ac.nw.discovery.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.AccountDto;
import za.ac.nw.discovery.logic.flow.IAccountFlow;
import za.ac.nw.discovery.translator.impl.AccountTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class AccountFlow implements IAccountFlow {

    public final AccountTranslator accountTranslator;

    @Autowired
    public AccountFlow(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<AccountDto> getMemberAccounts(Long memberId) {
        return accountTranslator.getMemberAccounts(memberId);
    }

    @Override
    public AccountDto getAccount(Long accountId) {
        return accountTranslator.getAccount(accountId);
    }

    @Override
    public AccountDto createAccount(AccountDto account) {
        return accountTranslator.createAccount(account);
    }
}
