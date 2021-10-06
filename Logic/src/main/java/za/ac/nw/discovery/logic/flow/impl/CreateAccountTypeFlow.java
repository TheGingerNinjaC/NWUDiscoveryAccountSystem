package za.ac.nw.discovery.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.AccountTypeDto;
import za.ac.nw.discovery.logic.flow.ICreateAccountTypeFlow;
import za.ac.nw.discovery.translator.impl.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlow implements ICreateAccountTypeFlow {

    public final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public CreateAccountTypeFlow(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    public AccountTypeDto create(AccountTypeDto accountType){
        if (accountType.getCreationDate() == null){
            accountType.setCreationDate(LocalDate.now());
        }

        return accountTypeTranslator.create(accountType);
    }
}
