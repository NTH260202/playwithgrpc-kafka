package com.example.playwithgrpc.repository;

import com.example.playwithgrpc.model.event.CreateBookingEvent;
import com.example.playwithgrpc.model.event.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EventStore extends MongoRepository<Event, UUID> {

}
