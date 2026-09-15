package com.varun.parkinglot.dto;

import java.time.*;

public class ParkVehicleResponse {
    
    private String ticketId;;
    private String vehicleNumber;
    private String spotId;
    private LocalDateTime entryTime;

    public ParkVehicleResponse(String ticketId, String vehicleNumber, String spotId, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.spotId = spotId;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

}
