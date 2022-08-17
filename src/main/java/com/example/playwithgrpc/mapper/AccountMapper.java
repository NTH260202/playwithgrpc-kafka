package com.example.playwithgrpc.mapper;

import com.example.playwithgrpc.model.entity.Account;
import com.example.playwithgrpc.repository.AccountRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account mapAccountRepoToAccount(AccountRepository.Account accountRepo) {
        Account account = new Account();
        account.setFullName(accountRepo.getFullName());
        return account;
    }
}
