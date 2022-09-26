package com.example.playwithgrpc.controller;

import com.example.playwithgrpc.model.entity.Clinic;
import com.example.playwithgrpc.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinic")
@RequiredArgsConstructor
@Slf4j
public class ClinicController {
    private final ClinicRepository clinicRepository;
    @PostMapping
    public ResponseEntity<?> getByName() {
        Clinic clinic = new Clinic();
        clinic.setName("Nha khoa Kim");
        clinicRepository.save(clinic);
        return ResponseEntity.ok(clinic);
    }
}
