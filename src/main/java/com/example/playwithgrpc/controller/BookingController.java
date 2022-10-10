package com.example.playwithgrpc.controller;

import com.example.playwithgrpc.model.request.CreateBookingCommand;
import com.example.playwithgrpc.service.impl.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingServiceImpl bookingService;
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateBookingCommand createBookingCommand) {
        bookingService.create(createBookingCommand);
        return ResponseEntity.ok("Creating booking is successfully");
    }

}
