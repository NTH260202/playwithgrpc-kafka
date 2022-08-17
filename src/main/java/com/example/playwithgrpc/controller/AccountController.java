package com.example.playwithgrpc.controller;

import com.example.playwithgrpc.model.entity.Account;
import com.example.playwithgrpc.service.impl.AccountServiceRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceRepoImpl accountService;

    @GetMapping
    public ResponseEntity<?> getByName(@RequestParam("name") String name) {
        List<Account> accounts = accountService.getByName(name);
        return ResponseEntity.ok(accounts);
    }

}
