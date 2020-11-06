package services;

import dto.ParkingFloor;
import dto.ParkingSlot;

import java.util.List;
import java.util.function.Predicate;

public class EligibleFloor implements Predicate<ParkingFloor> {
    @Override
    public boolean test(ParkingFloor parkingFloor) {
        List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
        for (ParkingSlot parkingSlot : parkingSlots) {
            if(parkingSlot.isVacant())
                return true;
        }
        return false;
    }
}
