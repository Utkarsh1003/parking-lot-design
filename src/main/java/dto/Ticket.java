package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private Integer ticketNumber;
    private Vehicle vehicle;
    private Double amount;
    private Long entryTime;
    private Long ExitTime;

    public Ticket(Integer ticketNumber, Vehicle vehicle, Double amount, Long entryTime) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.amount = amount;
        this.entryTime = entryTime;
    }
}
