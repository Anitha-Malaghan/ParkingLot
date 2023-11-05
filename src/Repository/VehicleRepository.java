package Repository;

import Models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    /*
    We can have DB and Push the data in DB and retrieve it.
    currently as i don't have database to connect to database as an alternative
    I am making use of in memory database: map which is going to store vehicle
     */
    Map<String, Vehicle> vehicleStore;

    //Constructor
    public VehicleRepository() {
        vehicleStore = new HashMap<>();
    }

    public Vehicle getVehicleFromVehicleNumber(String vehicleNumber){
        return vehicleStore.get(vehicleNumber);
    }
    public Vehicle addVehicle(Vehicle vehicle){
        vehicleStore.put(vehicle.getNumber(), vehicle);
        return vehicle;
    }

}
