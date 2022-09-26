package com.example.playwithgrpc.listener;

import com.example.playwithgrpc.model.event.Event;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidIdentifiedEntityEventListener extends AbstractMongoEventListener<Event> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Event> event) {

        super.onBeforeConvert(event);
        Event entity = event.getSource();

        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}
