package za.ac.nw.discovery.logic.flow;

import za.ac.nw.discovery.domain.dto.AccountDto;

import java.util.List;

public interface IAccountFlow {
    List<AccountDto> getMemberAccounts(Long memberId);
    AccountDto getAccount(Long accountId);

    AccountDto createAccount(AccountDto account);
}
