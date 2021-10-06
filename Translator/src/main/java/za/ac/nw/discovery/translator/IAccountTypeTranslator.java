package za.ac.nw.discovery.translator;

import za.ac.nw.discovery.domain.dto.AccountTypeDto;

import java.util.List;

public interface IAccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();
}
