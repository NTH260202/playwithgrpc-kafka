package com.example.playwithgrpc.service;

import com.example.playwithgrpc.mapper.BookingMapper;
import com.example.playwithgrpc.model.enumerate.EventType;
import com.example.playwithgrpc.model.event.CreateBookingEvent;
import com.example.playwithgrpc.model.event.Event;
import com.example.playwithgrpc.model.query.BookingQuery;
import com.example.playwithgrpc.repository.jpa.BookingQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookingProjector {
    private final BookingQueryRepository repository;
    private final BookingMapper bookingMapper;

    public void project(UUID bookingId, Event event) {
        if (event.getEventType().equals(EventType.CREATE_BOOKING)) {
            boolean isCasted = event.getEventModel() != null;
            log.info("{}: " + isCasted, event.getEventModel());
            apply(bookingId, (CreateBookingEvent) event.getEventModel());
        }
    }

    public void apply(UUID bookingId, CreateBookingEvent event) {
        BookingQuery bookingQuery = repository.getBookingQueryById(bookingId);
        if (bookingQuery == null) {
            bookingQuery = new BookingQuery();
        }
        bookingQuery = bookingMapper.updateCreateBookingEventToBookingQuery(event, bookingQuery);
        log.info("{} booking is updated!", bookingQuery.getDentistId());
        repository.save(bookingQuery);
    }
}
