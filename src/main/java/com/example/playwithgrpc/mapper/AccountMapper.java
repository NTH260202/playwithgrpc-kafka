package com.example.playwithgrpc.mapper;

import com.example.playwithgrpc.model.request.AccountDTO;
import com.example.playwithgrpc.repository.jpa.AccountRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO mapAccountRepoToAccount(AccountRepository.Account accountRepo);
}
