package com.example.playwithgrpc.model.dto;

import com.example.playwithgrpc.model.EventModel;
import com.example.playwithgrpc.model.event.Event;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class EventMessage{
    private List<Event> events;
}
