package com.example.playwithgrpc.repository.jpa;

import com.example.playwithgrpc.model.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicRepository extends JpaRepository<Clinic, UUID> {
    Clinic getClinicById(UUID id);
}
