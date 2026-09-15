package com.varun.parkinglot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.varun.parkinglot.enums.VehicleType;

public class ParkVehicleRequest {
    
    @NotBlank
    private String vehicleNumber;

    @NotNull
    private VehicleType vehicleType;

    
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
