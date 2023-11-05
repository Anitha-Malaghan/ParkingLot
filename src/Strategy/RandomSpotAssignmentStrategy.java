package Strategy;

import Models.Gate;
import Models.ParkingSpot;
import Models.ParkingSpotStatus;
import Models.VehicleType;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    //Whichever were first available parking spot of the same type will be assigned.
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate, List<ParkingSpot> parkingSpots) {
        //loop over all the parking spot and find the first matching and available spot
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)&&
            parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
                return parkingSpot;
            }
        }
        return null;
    }
}
