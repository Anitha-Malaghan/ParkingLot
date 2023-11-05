package DTO;

import Models.Ticket;
//HTTPREQUEST - HTTPRESPONSE
public class GenerateTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {

        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {

        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {

        this.responseStatus = responseStatus;
    }
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
