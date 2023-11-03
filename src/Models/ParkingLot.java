package Models;

import java.util.List;

public class ParkingLot extends BaseEntity{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;



}
