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
    @Column(name = "patient_id")
    private UUID patientId;
    @Column(name = "dentist_id")
    private UUID dentistId;
    private String note;
    @Column(name = "voucher_id")
    private UUID voucherId;
}
