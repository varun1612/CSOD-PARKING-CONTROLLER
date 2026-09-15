package com.varun.parkinglot.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import com.varun.parkinglot.enums.ParkingSpotType;
import com.varun.parkinglot.models.ParkingLot;
import com.varun.parkinglot.models.ParkingSpot;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingConfig {
    
    @Bean
    public ParkingLot parkingLot() {

        ParkingSpot spot1 = new ParkingSpot("S1", ParkingSpotType.CAR);
        ParkingSpot spot2 = new ParkingSpot("S2", ParkingSpotType.BIKE);
        ParkingSpot spot3 = new ParkingSpot("S3", ParkingSpotType.TRUCK);

        List<ParkingSpot> parkingSpots = new ArrayList<>(); 
        parkingSpots.add(spot1);
        parkingSpots.add(spot2);
        parkingSpots.add(spot3);        

        return new ParkingLot("MyParkingLot", parkingSpots);
    }
}
