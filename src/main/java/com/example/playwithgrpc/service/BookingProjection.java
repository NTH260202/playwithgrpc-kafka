package com.example.playwithgrpc.service;

import com.example.playwithgrpc.model.query.BookingQuery;
import com.example.playwithgrpc.model.request.BookingByUserQuery;
import com.example.playwithgrpc.repository.jpa.BookingQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingProjection {
    private final BookingQueryRepository bookingQueryRepository;
    public List<BookingQuery> handle(BookingByUserQuery query) {
        if(query.getPatientId() != null) {
            return bookingQueryRepository.findByDentistId(query.getPatientId());
        }
        if(query.getDentistId() != null) {
            return bookingQueryRepository.findByDentistId(query.getDentistId());
        }
        return new ArrayList<>();
    }
}
