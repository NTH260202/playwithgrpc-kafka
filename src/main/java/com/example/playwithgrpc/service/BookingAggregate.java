package com.example.playwithgrpc.service;

import com.example.playwithgrpc.mapper.BookingMapper;
import com.example.playwithgrpc.model.EventModel;
import com.example.playwithgrpc.model.enumerate.EventType;
import com.example.playwithgrpc.model.event.CreateBookingEvent;
import com.example.playwithgrpc.model.event.Event;
import com.example.playwithgrpc.model.request.CreateBookingCommand;
import com.example.playwithgrpc.repository.EventStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingAggregate {
    private final EventStore eventStore;
    private final BookingMapper bookingMapper;
    public List<Event> handleCreateBookingCommand(CreateBookingCommand command) {
        CreateBookingEvent createBookingEvent = bookingMapper.mapCreateBookingCommandToCreateBookingEvent(command);
        log.info("{} is an event!", createBookingEvent);
        Event event = new Event();
        event.setEventType(EventType.CREATE_BOOKING);
        event.setEventModel(createBookingEvent);
        event.setCreatedDate(LocalDateTime.now());
        eventStore.save(event);
        return List.of(event);
    }
}
