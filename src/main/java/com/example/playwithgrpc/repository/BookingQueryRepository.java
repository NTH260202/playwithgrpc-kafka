package com.example.playwithgrpc.repository;

import com.example.playwithgrpc.model.query.BookingQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BookingQueryRepository extends JpaRepository<BookingQuery, UUID> {

    List<BookingQuery> findByDentistId(UUID dentistId);
    List<BookingQuery> findByPatientId(UUID patientId);
}
