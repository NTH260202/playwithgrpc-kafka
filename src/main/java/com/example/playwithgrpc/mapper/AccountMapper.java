package com.example.playwithgrpc.mapper;

import com.example.playwithgrpc.model.dto.AccountDTO;
import com.example.playwithgrpc.repository.AccountRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO mapAccountRepoToAccount(AccountRepository.Account accountRepo);
}
