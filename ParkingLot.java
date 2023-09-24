package pr.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ParkingLot {

    private static final int NUM_CAR_SLOTS = 10;
    private static final int NUM_SCOOTER_SLOTS = 10;

    private Map<String, Vehicle> parkedVehicles;
    private List<Vehicle>[] carSlots;
    private List<Vehicle>[] scooterSlots;
    private Random rand;

    public ParkingLot() {
        parkedVehicles = new HashMap<>();
        carSlots = new List[2];
        carSlots[0] = new ArrayList<>();
        carSlots[1] = new ArrayList<>();
        scooterSlots = new List[2];
        scooterSlots[0] = new ArrayList<>();
        scooterSlots[1] = new ArrayList<>();
        rand = new Random();
    }

    public void parkVehicle(Vehicle vehicle) {
        List<Vehicle>[] slots = getSlotsForVehicle(vehicle);
        int laneIndex = rand.nextInt(slots.length);
        List<Vehicle> lane = slots[laneIndex];
        int slotIndex = findEmptySlot(lane);
        if (slotIndex == -1) {
            System.out.println("Sorry, there are no empty slots for " + vehicle.getType());
            return;
        }
        lane.set(slotIndex, vehicle);
        parkedVehicles.put(vehicle.getRegNo(), vehicle);
        System.out.println("Parked " + vehicle.getType() + " with registration number " + vehicle.getRegNo() + " in lane " + (laneIndex + 1) + " slot " + (slotIndex + 1));
    }

    private List<Vehicle>[] getSlotsForVehicle(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return carSlots;
        } else if (vehicle instanceof Scooter) {
            return scooterSlots;
        } else {
            throw new IllegalArgumentException("Unknown vehicle type: " + vehicle.getClass().getSimpleName());
        }
    }

    private int findEmptySlot(List<Vehicle> lane) {
        for (int i = 0; i < lane.size(); i++) {
            if (lane.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    public void removeVehicle(String regNo) {
        Vehicle vehicle = parkedVehicles.get(regNo);
        if (vehicle == null) {
            System.out.println("Vehicle with registration number " + regNo + " is not parked here");
            return;
        }
        List<Vehicle>[] slots = getSlotsForVehicle(vehicle);
        List<Vehicle> lane = findLaneContainingVehicle(slots, vehicle);
        int slotIndex = lane.indexOf(vehicle);
        lane.set(slotIndex, null);
        parkedVehicles.remove(regNo);
        System.out.println("Removed " + vehicle.getType() + " with registration number " + regNo);
        moveVehiclesInLane(lane, slotIndex);
    }

    private List<Vehicle> findLaneContainingVehicle(List<Vehicle>[] slots, Vehicle vehicle) {
        for (List<Vehicle> lane : slots) {
            if (lane.contains(vehicle)) {
                return lane;
            }
        }
        throw new IllegalArgumentException("Vehicle not found in any lane");
    }

    private void moveVehiclesInLane(List<Vehicle> lane, int startIndex) {
        int i = startIndex + 1;
        while (i < lane.size() && lane.get(i) != null) {
            Vehicle vehicle = lane.get(i);
            lane.set(i - 1, vehicle);
            lane.set(i, null);
            i++;
        }
    }

    public int getNumCars() {
        int numCars = 0;
        for (List<Vehicle> lane : carSlots) {
            for (Vehicle vehicle : lane) {
                if (vehicle != null) {
                    numCars++;
                }
            }
        }
        return numCars;
    }

    public int getNumScooters() {
        int numScooters = 0;
        for (List<Vehicle> lane : scooterSlots) {
            for (Vehicle vehicle : lane) {
                if (vehicle != null) {
                    numScooters++;
                }
            }
        }
        return numScooters;
    }

    public void displayOccupiedSlots() {
        System.out.println("Occupied slots:");
        displayLaneOccupiedSlots(carSlots, "Car");
        displayLaneOccupiedSlots(scooterSlots, "Scooter");
    }

    private void displayLaneOccupiedSlots(List<Vehicle>[] slots, String vehicleType) {
        int laneIndex = 1;
        for (List<Vehicle> lane : slots) {
            System.out.print(vehicleType + " lane " + laneIndex + ": ");
            boolean isFirst = true;
            for (Vehicle vehicle : lane) {
                if (vehicle != null) {
                    if (!isFirst) {
                        System.out.print(", ");
                    }
                    System.out.print(vehicle.getRegNo());
                    isFirst = false;
                }
            }
            System.out.println();
            laneIndex++;
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter option number:");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Display number of cars");
            System.out.println("4. Display number of scooters");
            System.out.println("5. Display occupied slots");
            System.out.println("6. Quit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter vehicle type (car or scooter):");
                    String vehicleType = scanner.next();
                    System.out.println("Enter registration number:");
                    String regNo = scanner.next();
                    if (vehicleType.equalsIgnoreCase("car")) {
                        parkingLot.parkVehicle(new Car(regNo));
                    } else if (vehicleType.equalsIgnoreCase("scooter")) {
                        parkingLot.parkVehicle(new Scooter(regNo));
                    } else {
                        System.out.println("Unknown vehicle type");
                    }
                    break;
                case 2:
                    System.out.println("Enter registration number:");
                    regNo = scanner.next();
                    parkingLot.removeVehicle(regNo);
                    break;
                case 3:
                    System.out.println("Number of cars parked: " + parkingLot.getNumCars());
                    break;
                case 4:
                    System.out.println("Number of scooters parked: " + parkingLot.getNumScooters());
                    break;
                case 5:
                    parkingLot.displayOccupiedSlots();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

}

abstract class Vehicle {
    private String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public abstract String getType();
}

class Car extends Vehicle {
    public Car(String regNo) {
        super(regNo);
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class Scooter extends Vehicle {
    public Scooter(String regNo) {
		super(regNo);
		// TODO Auto-generated constructor stub
	}

	
    @Override
    public String getType() {
        return "Scooter";
    }
}