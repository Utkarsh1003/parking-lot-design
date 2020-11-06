package dto;

import enums.ParkingRule;
import lombok.Getter;
import lombok.Setter;
import services.ParkingRuleFactory;
import services.ParkingService;
import services.VacateService;

import java.util.*;

@Getter
@Setter
public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> parkingFloors;
    private Map<Integer, ParkingFloor> floorMap;

    private ParkingLot() {
    }

    public static ParkingLot getInstancce() {
        if(instance == null)
            instance = new ParkingLot();

        return instance;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        if(this.parkingFloors == null){
            this.parkingFloors = new ArrayList<ParkingFloor>();
            this.floorMap = new HashMap<>();
        }

        this.parkingFloors.add(parkingFloor);
        this.floorMap.put(parkingFloor.getId(), parkingFloor);
    }

    public void parkCar(Car car, ParkingRule parkingRule) {
        ParkingRuleFactory parkingRuleFactory = ParkingRuleFactory.getInstance();
        ParkingService parkingService = parkingRuleFactory.getParkingService(parkingRule);

        parkingService.parkCar(car);
    }

    public void vacate(Integer floorId, Integer slotId) {
        VacateService vacateService = new VacateService();
        vacateService.vacate(floorId, slotId);
    }

    public void getAllocatedSlots() {
        if(this.parkingFloors == null || this.parkingFloors.isEmpty())
            return;

        this.parkingFloors.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getParkingSlots() != null && !e.getParkingSlots().isEmpty())
                .forEach(e -> {
                    List<ParkingSlot> parkingSlots = e.getParkingSlots();
                    System.out.println("Parking floor " + e.getFloorNumber() + " has ");
                    for (ParkingSlot parkingSlot : parkingSlots) {
                        if(!parkingSlot.isVacant()){
                            System.out.println("   Slot" + parkingSlot.getId() + " with car " + parkingSlot.getVehicle().getLicenceNumber() + " " +  parkingSlot.getVehicle().getColor());
                        }
                    }
                });

        return;
    }

    public void getFreeSlots() {
        if(this.parkingFloors == null || this.parkingFloors.isEmpty())
            return;

        this.parkingFloors.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getParkingSlots() != null && !e.getParkingSlots().isEmpty())
                .forEach(e -> {
                    List<ParkingSlot> parkingSlots = e.getParkingSlots();
                    System.out.println("Parking floor " + e.getFloorNumber() + " has ");
                    for (ParkingSlot parkingSlot : parkingSlots) {
                        if(parkingSlot.isVacant()){
                            System.out.println("   Slot" + parkingSlot.getId());
                        }
                    }
                });

        return;
    }
}
