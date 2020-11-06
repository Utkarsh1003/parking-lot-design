package services;

import dto.Car;
import dto.ParkingFloor;
import dto.ParkingSlot;
import lombok.AllArgsConstructor;

import java.util.function.Predicate;

@AllArgsConstructor
public class AllocateCab implements Predicate<ParkingFloor> {

    Car car;

    @Override
    public boolean test(ParkingFloor parkingFloor) {
        ParkingSlot parkingSlot = parkingFloor.getParkingSlots().stream().filter(ParkingSlot::isVacant).findFirst().orElse(null);
        if(parkingSlot == null) return false;
        parkingSlot.setVacant(false);
        parkingSlot.setVehicle(car);
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();
        parkingSlot.setTicketId(parkingLotSystem.generateTicket(car));
        return true;
    }
}
