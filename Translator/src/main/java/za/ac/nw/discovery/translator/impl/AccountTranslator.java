package za.ac.nw.discovery.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nw.discovery.domain.dto.AccountDto;
import za.ac.nw.discovery.domain.dto.AccountTypeDto;
import za.ac.nw.discovery.domain.persistence.Account;
import za.ac.nw.discovery.domain.persistence.AccountType;
import za.ac.nw.discovery.repository.persistence.AccountRepository;
import za.ac.nw.discovery.translator.IAccountTranslator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AccountTranslator implements IAccountTranslator {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountTranslator(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getMemberAccounts(Long memberId) {
        List<AccountDto> accountDtos = new ArrayList<>();
        try{
            for (Account account : accountRepository.findAll()){
                accountDtos.add(new AccountDto(account));
            }
        } catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountDtos;
    }

    @Override
    public AccountDto getAccount(Long accountId) {
        try {
            Account accountDto = accountRepository.getById(accountId);
            return new AccountDto(accountDto);
        } catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        try {
            Account account = accountRepository.save(accountDto.getAccount());
            return new AccountDto(account);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public void updateAccountBalance(Long accountId, Double balance) {
        try {
            accountRepository.updateAccountBalance(accountId, balance);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update the DB", e);
        }
    }

}
