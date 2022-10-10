package com.example.playwithgrpc.service.impl;

import com.example.playwithgrpc.model.dto.EventMessage;
import com.example.playwithgrpc.model.event.CreateBookingEvent;
import com.example.playwithgrpc.model.event.Event;
import com.example.playwithgrpc.model.query.BookingQuery;
import com.example.playwithgrpc.model.request.CreateBookingCommand;
import com.example.playwithgrpc.repository.jpa.BookingQueryRepository;
import com.example.playwithgrpc.service.BookingAggregate;
import com.example.playwithgrpc.service.BookingProjection;
import com.example.playwithgrpc.service.BookingProjector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl {
    private final BookingAggregate bookingAggregate;
    private final BookingQueryRepository bookingQueryRepository;

    private final KafkaTemplate<String, EventMessage> eventMessageKafkaTemplate;
    public void create(CreateBookingCommand command) {
        List<Event> events = bookingAggregate.handleCreateBookingCommand(command);


        EventMessage message = new EventMessage();
        message.setEvents(events);
        ListenableFuture<SendResult<String, EventMessage>> future =
                eventMessageKafkaTemplate.send("reflectoring-1", message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, EventMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Send message failure");
            }

            @Override
            public void onSuccess(SendResult<String, EventMessage> result) {
                log.info("Message is sent!");
            }
        });
    }
}
