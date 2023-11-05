package Service;

import Models.Vehicle;
import Models.VehicleType;
import Repository.VehicleRepository;

public class VehicleService {
    /* why have we created the vehicleService?
    Because we don't want the TicketService to connect with vehicle repository directly
     */
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleRepository.getVehicleFromVehicleNumber(vehicleNumber);
    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType){
        return vehicleRepository.addVehicle(new Vehicle(vehicleNumber,vehicleType ));
    }
}
