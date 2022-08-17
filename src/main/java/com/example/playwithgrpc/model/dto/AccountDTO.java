package com.example.playwithgrpc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String userId;
    private String username;
    private String fullName;
    private int age;
}
