package com.example.playwithgrpc.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.UUID;
@Entity
@Table(name = "clinic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            insertable = false,
            nullable = false,
            columnDefinition = "BINARY(16)",
            updatable = false
    )
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "avg_rating_score")
    private Float avgRatingScore;

    @Column(name = "status")
    private String status;

    @Column(name = "start_time_shift_1")
    private Time startTimeShift1;

    @Column(name = "end_time_shift_1")
    private Time endTimeShift1;

    @Column(name = "start_time_shift_2")
    private Time startTimeShift2;

    @Column(name = "end_time_shift_2")
    private Time endTimeShift2;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "booking_gap")
    private Integer bookingGap;

    @Column(name = "facebook_page_id")
    private String facebookPageId;

    @Column(name = "expired_day")
    private Integer expiredDay = 3;
}
