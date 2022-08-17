package com.example.playwithgrpc.service.impl;

import com.example.playwithgrpc.mapper.AccountMapper;
import com.example.playwithgrpc.model.entity.Account;
import com.example.playwithgrpc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceRepoImpl {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @CachePut
    public List<Account> getByName(String name) {
        List<AccountRepository.Account> accountRepositories = accountRepository.searchAccountsByFullName(name);
        List<Account> accounts = accountRepositories.stream().map(accountMapper::mapAccountRepoToAccount).collect(Collectors.toList());
        return accounts;
    }
}
