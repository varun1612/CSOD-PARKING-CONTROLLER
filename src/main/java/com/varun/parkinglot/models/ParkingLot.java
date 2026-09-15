package com.varun.parkinglot.models;
import java.util.List;

import com.varun.parkinglot.exception.ParkingSpotNotAvailableException;
import com.varun.parkinglot.exception.VehicleAlreadyParkedException;
import java.util.ArrayList;
import java.time.Duration;

public class ParkingLot {
    private String name;
    private List<ParkingSpot> parkingSpots;
    private List<Vehicle> vehicles;
    private List<Ticket> parkingTickets;
    
    public ParkingLot(String name, List<ParkingSpot> parkingSpots) {
        this.name = name;
        this.parkingSpots = parkingSpots;
        this.vehicles = new ArrayList<>();
        this.parkingTickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;   
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public List<Ticket> getParkingTickets() {
        return parkingTickets;
    }
    public void setParkingTicket(Ticket ticket) {   
        parkingTickets.add(ticket);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        
            for(Vehicle v: vehicles) {
                if(v.getVehicleNumber().equals(vehicle.getVehicleNumber())) {
                    throw new VehicleAlreadyParkedException("Vehicle with number " + vehicle.getVehicleNumber() + " is already parked.");
                }
            }

            ParkingSpot availableSpot = null;
            for (ParkingSpot spot : parkingSpots) {
                if (spot.getVehicle() == null && spot.getSpotType().toString().equals(vehicle.getVehicleType().toString())) {
                    availableSpot = spot;
                    break;  
                }
            }

            if (availableSpot == null) {
                throw new ParkingSpotNotAvailableException("No available parking spot for vehicle type: " + vehicle.getVehicleType());
            }

            availableSpot.parkVehicle(vehicle);
            vehicles.add(vehicle);
            Ticket ticket = new Ticket("TICKET-" + (parkingTickets.size() + 1), vehicle, availableSpot);
            parkingTickets.add(ticket);
            System.out.println("Vehicle " + vehicle.getVehicleNumber() + " parked at spot "+ availableSpot.getId() + ". Ticket ID: " + ticket.getId());
            return ticket;
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = null;
        for (Ticket t : parkingTickets) {
            if (t.getId().equals(ticketId)) {
                ticket = t;
                break;
            }
        }
        if (ticket == null) {
            System.out.println("Ticket not found.");
            return 0.0;
        }
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        Vehicle vehicle = ticket.getVehicle();
        if(parkingSpot.getVehicle() != null && parkingSpot.getVehicle().getVehicleNumber().equals(vehicle.getVehicleNumber())) {
            parkingSpot.removeVehicle();
            vehicles.remove(vehicle);
            parkingTickets.remove(ticket);
            System.out.println("Vehicle " + vehicle.getVehicleNumber() + " removed from spot " + parkingSpot.getId() + "Fee: " + calculateParkingFee(ticket));
            return calculateParkingFee(ticket);
        }
        System.out.println("Vehicle " + vehicle.getVehicleNumber() + " not found in the parking spot " + parkingSpot.getId());
        return 0.0; // Vehicle not found in the parking spot
    }

    private double calculateParkingFee(Ticket ticket) {
        // Implement your parking fee calculation logic here
        // For simplicity, let's assume a flat rate of $10 per hour
        long parkedDurationInHours = Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now()).toHours();
        return parkedDurationInHours * 10.0;
    }

    public Ticket getTicket(String ticketId) {
        for (Ticket t : parkingTickets) {
            if (t.getId().equals(ticketId)) {
                return t;
            }
        }
        return null; // Ticket not found
    }


}
