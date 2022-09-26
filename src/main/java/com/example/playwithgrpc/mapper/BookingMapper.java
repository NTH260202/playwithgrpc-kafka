package com.example.playwithgrpc.mapper;

import com.example.playwithgrpc.model.command.BookingCommand;
import com.example.playwithgrpc.model.query.BookingQuery;
import com.example.playwithgrpc.model.request.CreateBookingCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingCommand mapCreateBookingCommandToBookingCommand(CreateBookingCommand createBookingCommand);
}
