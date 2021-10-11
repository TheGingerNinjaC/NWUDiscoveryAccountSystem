package za.ac.nw.discovery.translator;

import za.ac.nw.discovery.domain.dto.AccountDto;

import java.util.List;

public interface IAccountTranslator {
    List<AccountDto> getMemberAccounts(Long memberId);
    AccountDto getAccount(Long accountId);

    AccountDto createAccount(AccountDto account);
    void updateAccountBalance(Long accountId, Double balance);
}
