package com.varun.parkinglot.service;

import org.springframework.stereotype.Service;

import com.varun.parkinglot.dto.ParkVehicleRequest;
import com.varun.parkinglot.dto.ParkVehicleResponse;
import com.varun.parkinglot.models.ParkingLot;
import com.varun.parkinglot.models.Ticket;
import com.varun.parkinglot.models.Vehicle;

@Service
public class ParkingService {

    private final ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkVehicleResponse parkVehicle(
            ParkVehicleRequest request) {

        Vehicle vehicle =
                new Vehicle(
                        request.getVehicleNumber(),
                        request.getVehicleType()
                );

        Ticket ticket = parkingLot.parkVehicle(vehicle);

        return new ParkVehicleResponse(
                ticket.getId(),
                ticket.getVehicle().getVehicleNumber(),
                ticket.getParkingSpot().getId(),
                ticket.getEntryTime()
        );
    }
    
    public void unparkVehicle(String ticketId) {
        parkingLot.unparkVehicle(ticketId);
    }

    public String getParkingStatus() {
        return "Hello, Welcome to the CSOD Parking Lot!";
    }

    public Ticket getTicket(String ticketId) {
        return parkingLot.getTicket(ticketId);
    }
}