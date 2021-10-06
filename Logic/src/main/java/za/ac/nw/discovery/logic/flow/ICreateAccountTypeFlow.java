package za.ac.nw.discovery.logic.flow;

import za.ac.nw.discovery.domain.dto.AccountTypeDto;

public interface ICreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);
}
