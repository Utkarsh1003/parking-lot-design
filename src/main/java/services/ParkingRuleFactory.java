package services;

import dto.ParkingLot;
import enums.ParkingRule;

public class ParkingRuleFactory {
    private static ParkingRuleFactory instance;

    private FCFSParkingService fcfsParkingService;

    private ParkingRuleFactory() {
        this.fcfsParkingService = new FCFSParkingService();
    }

    public static ParkingRuleFactory getInstance() {
        if(instance == null)
            instance = new ParkingRuleFactory();

        return instance;
    }

    public ParkingService getParkingService(ParkingRule parkingRule){
        if(ParkingRule.FCFS.equals(parkingRule))
            return this.fcfsParkingService;

        return this.fcfsParkingService;
    }
}
