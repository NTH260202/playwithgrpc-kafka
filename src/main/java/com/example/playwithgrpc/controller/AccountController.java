package com.example.playwithgrpc.controller;

import com.example.playwithgrpc.model.request.AccountDTO;
import com.example.playwithgrpc.service.impl.AccountServiceRepoImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountServiceRepoImpl accountService;

    @GetMapping
    public ResponseEntity<?> getByName(@RequestParam("name") String name) {
        List<AccountDTO> accounts = accountService.getByName(name);
        log.info(accounts.toString());
        List<AccountDTO> accounts1 = accountService.getByName(name);
        log.info(accounts1.toString());
        return ResponseEntity.ok(accounts);
    }

}
