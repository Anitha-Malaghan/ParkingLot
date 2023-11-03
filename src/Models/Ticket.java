package Models;
import java.util.Date;

public class Ticket extends BaseEntity{
    private Gate gate;
    private Vehicle vehicle;
    private  Date entryTime;
    private ParkingSpot parkingSpot;
    private Operator operator;


}
