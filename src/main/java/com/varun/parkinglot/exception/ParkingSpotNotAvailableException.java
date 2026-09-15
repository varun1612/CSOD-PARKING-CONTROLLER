package com.varun.parkinglot.exception;

public class ParkingSpotNotAvailableException extends RuntimeException {
        public ParkingSpotNotAvailableException(String message) {
            super(message);
        }
}
