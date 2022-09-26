package com.example.playwithgrpc.model.request;

import java.util.UUID;

public class CreateBookingCommand {
    private UUID dentistId;
    private String note;
    private UUID voucherId;
}
