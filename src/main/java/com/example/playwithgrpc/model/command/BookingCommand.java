package com.example.playwithgrpc.model.command;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "booking_command")
public class BookingCommand {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;
    private UUID dentistId;
    private String note;
    private UUID voucherId;
    private UUID patientId;
}
