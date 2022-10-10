package com.example.playwithgrpc.mapper;

import com.example.playwithgrpc.model.command.BookingCommand;
import com.example.playwithgrpc.model.event.CreateBookingEvent;
import com.example.playwithgrpc.model.query.BookingQuery;
import com.example.playwithgrpc.model.request.CreateBookingCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingCommand mapCreateBookingCommandToBookingCommand(CreateBookingCommand createBookingCommand);
    CreateBookingEvent mapCreateBookingCommandToCreateBookingEvent(CreateBookingCommand createBookingCommand);
    BookingQuery mapCreateBookingEventToBookingQuery(CreateBookingEvent createBookingEvent);
    void updateCreateBookingEventToBookingQuery(CreateBookingEvent createBookingEvent, @MappingTarget BookingQuery bookingQuery);
}
