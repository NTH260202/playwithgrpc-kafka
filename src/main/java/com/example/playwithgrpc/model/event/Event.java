package com.example.playwithgrpc.model.event;

import com.example.playwithgrpc.model.enumerate.EventType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.EventObject;
import java.util.UUID;

@Document()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private UUID id;
    @Field
    private LocalDateTime createdDate = LocalDateTime.now();
    @Field
    private EventType eventType;
    @Field
    private Object eventModel;
}
