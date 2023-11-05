package Controller;

import DTO.GenerateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import DTO.ResponseStatus;
import Exceptions.NoParkingSpotFoundExceptions;
import Models.Gate;
import Models.Ticket;
import Models.Vehicle;
import Service.TicketService;

import java.util.Date;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(
            GenerateTicketRequestDto generateTicketRequestDto){
        //1.get vehicle id from the DB
        //2.Add vehicle in the DB.

        //2 ways
        //1. repo to insert the data Repo.insertVehicle()
        //2.Service to handle this Service.insertVehicle(); :: Better Approach

        // Always pass only required details to service.
        //not all details of request are applicable for all service.



        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try {
            Ticket ticket = ticketService.
                    generateTicket(generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                            generateTicketRequestDto.getGateId());

            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoParkingSpotFoundExceptions e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setResponseMessage(e.getMessage());
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setResponseMessage(e.getMessage());

        }


        return responseDto;
    }
}
