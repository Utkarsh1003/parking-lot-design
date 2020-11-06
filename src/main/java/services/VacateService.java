package services;

import dto.ParkingFloor;
import dto.ParkingLot;
import dto.ParkingSlot;

public class VacateService {
    public Boolean vacate(Integer floorId, Integer slotId){
        ParkingLot parkingLot = ParkingLot.getInstancce();
        if(parkingLot.getParkingFloors() == null || parkingLot.getParkingFloors().isEmpty())
            return false;

        ParkingFloor floor = parkingLot.getFloorMap().get(floorId);
        if(floor == null)
            return false;

        if(floor.getParkingSlots() == null || floor.getParkingSlots().isEmpty())
            return false;

        ParkingSlot slot = floor.getSlotMap().get(slotId);
        if(slot == null)
            return false;

        slot.setVehicle(null);
        slot.setVacant(true);
        slot.setTicketId(null);

        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();
        parkingLotSystem.updateEndTime(System.currentTimeMillis(), slot.getTicketId());

        return true;
    }
}
