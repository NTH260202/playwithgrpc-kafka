package com.example.playwithgrpc.repository;

import com.example.playwithgrpc.model.command.BookingCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookingCommandRepository extends JpaRepository<BookingCommand, UUID> {
}
