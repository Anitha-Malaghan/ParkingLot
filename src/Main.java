import Controller.TicketController;
import Repository.VehicleRepository;
import Service.TicketService;
import Service.VehicleService;

public class Main {
    public static void main(String[] args) {
        //order of dependency matters a lot.
        /*VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);

        TicketService ticketService = new TicketService();
        TicketController ticketController = new TicketController();

        ObjectContainer objectContainer = new ObjectContainer();
        objectContainer.register("TicketController", ticketController);
        objectContainer.register("TicketService", ticketService);*/
        System.out.println("Hello world!");
        //Assignment: Implement Generate Bill
    }
}