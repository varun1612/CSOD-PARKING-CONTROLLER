package com.varun.parkinglot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.varun.parkinglot.service.ParkingService;
import com.varun.parkinglot.dto.ParkVehicleResponse;
import com.varun.parkinglot.models.Ticket;
import com.varun.parkinglot.dto.ParkVehicleRequest;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/park")
    public ResponseEntity<ParkVehicleResponse> parkVehicle(
            @Valid @RequestBody ParkVehicleRequest request) {

        ParkVehicleResponse response =
                parkingService.parkVehicle(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/unpark/{ticketId}")
    public ResponseEntity<String> unparkVehicle(
            @PathVariable String ticketId) {
        parkingService.unparkVehicle(ticketId);
        return ResponseEntity.ok("Vehicle unparked successfully.");
    }

    @GetMapping("/status")
    public ResponseEntity<String> getParkingStatusMessage() {
        String statusMessage = parkingService.getParkingStatus();
        return ResponseEntity.ok(statusMessage);    
    }

    @GetMapping("/parking/{ticketId}")
    public ResponseEntity<Ticket> getParkingDetails(@PathVariable String ticketId) {
        Ticket ticket = parkingService.getTicket(ticketId);
        return ResponseEntity.ok(ticket);
    }   
}
