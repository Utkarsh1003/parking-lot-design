package dto;

import enums.SlotType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private SlotType type;
    private Vehicle vehicle;
    private Integer id;
    private Integer ticketId;

    public ParkingSlot(SlotType type, Integer id, boolean vacant) {
        this.type = type;
        this.id = id;
        this.vacant = vacant;
    }

    private boolean vacant;
}
