package Models;

public class Vehicle extends BaseEntity{
    private String number;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.number = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    //Objectcontainer.get("ticketService");
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
