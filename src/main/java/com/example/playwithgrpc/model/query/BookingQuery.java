package com.example.playwithgrpc.model.query;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "booking_query")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingQuery {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "patient_id", columnDefinition = "BINARY(16)")
    private UUID patientId;

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "dentist_id", columnDefinition = "BINARY(16)")
    private UUID dentistId;
    private String note;

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "voucher_id", columnDefinition = "BINARY(16)")
    private UUID voucherId;
}
