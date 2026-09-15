package com.varun.parkinglot.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParkingSpotNotAvailableException.class)
    public ResponseEntity<Map<String, String>> handleParkingSpotNotAvailable(
            ParkingSpotNotAvailableException exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("message", exception.getMessage()));
    }

    @ExceptionHandler(VehicleAlreadyParkedException.class)
    public ResponseEntity<Map<String, String>> handleVehicleAlreadyParked(
            VehicleAlreadyParkedException exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("message", exception.getMessage()));
    }
}