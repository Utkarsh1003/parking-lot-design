package dto;

import enums.SlotType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingFloor {
    private Integer id;
    private String floorNumber;
    private List<ParkingSlot> parkingSlots;
    private Map<Integer, ParkingSlot> slotMap;

    public ParkingFloor(Integer id, String floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
    }

    public void addSlots(Integer noOfSlots) {
        int initialCount = 0;
        if(this.parkingSlots == null){
            this.parkingSlots = new ArrayList<ParkingSlot>();
            this.slotMap = new HashMap<>();
        }
        else
            initialCount = this.parkingSlots.size();

        for (int i = initialCount; i < noOfSlots; i++) {
            ParkingSlot parkingSlot = new ParkingSlot(SlotType.NORMAL, i, true);

            this.parkingSlots.add(parkingSlot);
            this.slotMap.put(i, parkingSlot);
        }
    }
}
