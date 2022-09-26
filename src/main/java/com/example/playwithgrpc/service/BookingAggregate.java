package com.example.playwithgrpc.service;

import com.example.playwithgrpc.mapper.BookingMapper;
import com.example.playwithgrpc.model.command.BookingCommand;
import com.example.playwithgrpc.model.request.CreateBookingCommand;
import com.example.playwithgrpc.repository.BookingCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingAggregate {
    private final BookingCommandRepository bookingCommandRepository;
    private final BookingMapper bookingMapper;
    public BookingCommand handleCreateBookingCommand(CreateBookingCommand command) {
        BookingCommand bookingCommand = bookingMapper.mapCreateBookingCommandToBookingCommand(command);
        bookingCommandRepository.save(bookingCommand);
        return bookingCommand;
    }
}
