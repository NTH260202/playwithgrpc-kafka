package com.example.playwithgrpc.repository;

import com.example.playwithgrpc.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Query(value = "SELECT CONCAT(a.lastName, ' ', a.firstName) as fullName FROM Account a WHERE CONCAT(a.lastName, ' ', a.firstName) LIKE %?1%")
    List<Account> searchAccountsByFullName(String search);

    public interface Account {
        String getFullName();
    }
    com.example.playwithgrpc.model.entity.Account getAccountById(UUID id);
}
