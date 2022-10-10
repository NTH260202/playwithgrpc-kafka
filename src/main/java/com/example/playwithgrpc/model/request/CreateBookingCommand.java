package com.example.playwithgrpc.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingCommand {
    private UUID dentistId;
    private String note;
    private UUID voucherId;
}
