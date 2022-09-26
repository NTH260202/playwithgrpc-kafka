package com.example.playwithgrpc.repository;

import com.example.playwithgrpc.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface EvenStore extends MongoRepository<Event, UUID> {

}
