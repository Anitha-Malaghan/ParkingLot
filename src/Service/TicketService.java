package Service;

import Exceptions.NoParkingSpotFoundExceptions;
import Models.*;
import Repository.TicketRepository;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingLotService parkingLotService;
    private TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService, GateService gateService,
                         ParkingLotService parkingLotService,
                         TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.parkingLotService = parkingLotService;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotFoundExceptions {
        /*get the vehicle details from the DB, if the Vehicle is not present then
        create a vehicle object and store in the DB.
        1.Who will interact with vehicle database?
        repository
        2. Should we have repo for every entity?
        yes. let's create repo package
         */
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }
        Gate gate = gateService.getGateUsingId(gateId);

       //Spot Assigment strategy to be part of parking lot service
        ParkingSpot parkingSpot = parkingLotService.getparkingSpot(vehicle, gate);
        if(parkingSpot == null){
            throw new NoParkingSpotFoundExceptions("No parking spot available");
        }

        //update parking spot
        //ParkingSpot parkingSpot = parkingSpotService.assignParkingSpot(ParkingSpot);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());
        ticket.setParkingSpot(parkingSpot);
        // save the ticket
        ticketRepository.saveTicket(ticket);

        return ticket;

    }
}
