import dto.Car;
import dto.ParkingFloor;
import dto.ParkingLot;
import enums.ParkingRule;

public class MainApp {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstancce();
        ParkingFloor parkingFloor = new ParkingFloor(1, "G");
        parkingFloor.addSlots(6);
        parkingLot.addParkingFloor(parkingFloor);

        parkingFloor = new ParkingFloor(2, "F");
        parkingFloor.addSlots(6);
        parkingLot.addParkingFloor(parkingFloor);

        Car car1 = new Car("Car A", "KA-01-HH-1234", "white");
        Car car2 = new Car("Car B", "KA-01-HH-9999", "white");
        Car car3 = new Car("Car C", "KA-01-BB-0001", "black");
        Car car4 = new Car("Car D", "KA-01-HH-7777", "red");
        Car car5 = new Car("Car E", "KA-01-HH-2701", "blue");
        Car car6 = new Car("Car F", "KA-01-HH-3141", "black");
        Car car9 = new Car("Car I", "KA-01-HH-3142", "yellow");


        parkingLot.parkCar(car1, ParkingRule.FCFS);
        parkingLot.parkCar(car2, ParkingRule.FCFS);
        parkingLot.parkCar(car3, ParkingRule.FCFS);
        parkingLot.parkCar(car4, ParkingRule.FCFS);
        parkingLot.parkCar(car5, ParkingRule.FCFS);
        parkingLot.parkCar(car6, ParkingRule.FCFS);
        parkingLot.parkCar(car9, ParkingRule.FCFS);

        parkingLot.getAllocatedSlots();
        parkingLot.getFreeSlots();

        parkingLot.vacate(1, 3);

        parkingLot.getAllocatedSlots();
        parkingLot.getFreeSlots();

        Car car7 = new Car("Car G", "KA-01-p-333", "white");
        parkingLot.parkCar(car7, ParkingRule.FCFS);

        parkingLot.getAllocatedSlots();
        parkingLot.getFreeSlots();

        Car car8 = new Car("Car H", "DL-12-AA-9999", "white");
        parkingLot.parkCar(car8, ParkingRule.FCFS);
    }
}
