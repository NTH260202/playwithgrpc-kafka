package com.example.playwithgrpc.model.event;

import com.example.playwithgrpc.model.EventModel;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookingEvent extends EventModel {
    private UUID dentistId;
    private UUID voucherId;
    private String note;
}
