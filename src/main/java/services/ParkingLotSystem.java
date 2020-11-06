package services;

import dto.Car;
import dto.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingLotSystem {
    private List<Ticket> tickets;
    private Map<Integer, Ticket> ticketMap;

    private static ParkingLotSystem instance;

    private ParkingLotSystem() {
    }

    public static ParkingLotSystem getInstance() {
        if(instance == null)
            instance = new ParkingLotSystem();

        return instance;
    }


    public Integer generateTicket(Car car) {
        if(this.tickets == null || this.tickets.isEmpty()){
            this.tickets = new ArrayList<>();
            this.ticketMap = new HashMap<>();
        }

        Integer ticketId = this.tickets.size() + 1;
        Ticket ticket = new Ticket(ticketId, car, 10.0, System.currentTimeMillis());
        this.tickets.add(ticket);
        this.ticketMap.put(ticketId, ticket);

        return ticketId;
    }

    public void updateEndTime(long currentTimeMillis, Integer ticketId) {
        Ticket ticket = this.ticketMap.get(ticketId);
        if(ticket == null)
            return;

        ticket.setExitTime(currentTimeMillis);
    }
}
