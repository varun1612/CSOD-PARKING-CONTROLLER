package com.varun.parkinglot.models;
import com.varun.parkinglot.enums.ParkingSpotType;
public class ParkingSpot {
    private String id;
    private ParkingSpotType spotType;
    private Vehicle vehicle;

    public ParkingSpot(String id, ParkingSpotType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.vehicle = null;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

}
