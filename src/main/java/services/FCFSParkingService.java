package services;

import dto.*;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FCFSParkingService implements ParkingService{

    public Boolean parkCar(Car car) {
        List<ParkingFloor> parkingFloors = ParkingLot.getInstancce().getParkingFloors();
        if(parkingFloors == null || parkingFloors.isEmpty()){
            System.out.println("Can not park");
            return false;
        }


        Predicate<ParkingFloor> allocateCab = new AllocateCab(car);
        boolean isAllocated = parkingFloors.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getParkingSlots() != null && !e.getParkingSlots().isEmpty())
                .anyMatch(allocateCab);

        if(isAllocated){
            return true;
        }else {
            System.out.println("Sorry, parking lot is full");
            return false;
        }
    }
}
