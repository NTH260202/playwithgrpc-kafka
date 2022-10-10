package com.example.playwithgrpc.listener;

import com.example.playwithgrpc.model.EventModel;
import com.example.playwithgrpc.model.dto.EventMessage;
import com.example.playwithgrpc.model.event.Event;
import com.example.playwithgrpc.service.BookingProjector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaListeners {
    private final BookingProjector bookingProjector;
    @KafkaListener(topics = "reflectoring-1", groupId = "reflectoring-group")
    public void listen(EventMessage message) {
        log.info("Listener receives event [{}]", message);
        Event event = message.getEvents().get(0);
        bookingProjector.project(event.getId(), event);
    }
}
