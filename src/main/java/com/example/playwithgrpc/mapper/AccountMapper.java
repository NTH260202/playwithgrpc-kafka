package com.example.playwithgrpc.mapper;

import com.example.playwithgrpc.model.dto.AccountDTO;
import com.example.playwithgrpc.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDTO mapAccountRepoToAccount(AccountRepository.Account accountRepo) {
        AccountDTO account = new AccountDTO();
        account.setFullName(accountRepo.getFullName());
        return account;
    }
}
