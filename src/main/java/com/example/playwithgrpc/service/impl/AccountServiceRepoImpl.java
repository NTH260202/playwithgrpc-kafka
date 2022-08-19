package com.example.playwithgrpc.service.impl;

import com.example.playwithgrpc.mapper.AccountMapper;
import com.example.playwithgrpc.model.dto.AccountDTO;
import com.example.playwithgrpc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceRepoImpl {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Cacheable(value = "Account", key = "#name")
    public List<AccountDTO> getByName(String name) {
        List<AccountRepository.Account> accountRepositories = accountRepository.searchAccountsByFullName(name);
        List<AccountDTO> accounts = accountRepositories.stream().map(accountMapper::mapAccountRepoToAccount).collect(Collectors.toList());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }
}
