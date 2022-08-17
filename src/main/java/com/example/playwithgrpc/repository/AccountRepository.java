package com.example.playwithgrpc.repository;

import com.example.playwithgrpc.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT CONCAT(a.lastName, ' ', a.firstName) as fullName FROM Account a WHERE CONCAT(a.lastName, ' ', a.firstName) LIKE %?1%")
    List<Account> searchAccountsByFullName(String search);

    public interface Account {
        String getFullName();
        String setFullName();
    }
}
