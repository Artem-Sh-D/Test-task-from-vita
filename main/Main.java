import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Elevator elevatorPassenger = new Elevator(Elevator.ElevatorType.PASSENGER);
        Elevator elevatorService = new Elevator(Elevator.ElevatorType.SERVICE);
        ArrayList<Floor> floors = Floor.createFloors(20,elevatorPassenger,elevatorService);
        actionPassengerFirst(elevatorPassenger,elevatorService,floors);
        System.out.println("///////////////////////////               ///////////////////////////");
        actionPassengerSecond(elevatorPassenger,elevatorService,floors);
    }

    public static void actionPassengerFirst(Elevator elevatorPassenger, Elevator elevatorService, ArrayList<Floor> floors) throws InterruptedException {
        Floor floor = floors.get(0);
        System.out.println("Пассажир номер один подходит к дверям лифта...");
        Thread.sleep(1000);
        System.out.println("Пассажир нажимает кнопку вызова лифта...");
        Thread.sleep(1000);
        if(elevatorPassenger.getState() == Elevator.ElevatorState.GO_UP || elevatorPassenger.getState() == Elevator.ElevatorState.GO_DOWN) {
            System.out.println("Лифт занят. Попробуйте нажать кнопку чуть позже...");
        } else {
            Elevator.ElevatorType elevatorType = floor.pushButtonCallElevator(elevatorPassenger,elevatorService,floors);
            if(elevatorType == Elevator.ElevatorType.PASSENGER) {
                System.out.println("Пассажир заходит в лифт...");
                Thread.sleep(1000);
                elevatorPassenger.movementBetweenDoors();
                System.out.println("Пассажир нажал на кнопку под номером 14...");
                elevatorPassenger.changeFloor(14,floors, Elevator.ElevatorType.PASSENGER);
                System.out.println("Пассажир выходит из лифта...");
                System.out.println("Состояние лифта: " + elevatorPassenger.getState() + ". Этаж лифта: " + elevatorPassenger.getNumberFloor() + ". Тип лифта: " + elevatorPassenger.getType());
            } else {
                System.out.println("Пассажир заходит в лифт...");
                Thread.sleep(1000);
                elevatorService.movementBetweenDoors();
                System.out.println("Пассажир нажал на кнопку под номером 14...");
                elevatorService.changeFloor(14,floors, Elevator.ElevatorType.SERVICE);
                System.out.println("Пассажир выходит из лифта...");
                System.out.println("Состояние лифта: " + elevatorService.getState() + ". Этаж лифта: " + elevatorService.getNumberFloor() + ". Тип лифта: " + elevatorService.getType());
            }
        }
    }

    public static void actionPassengerSecond(Elevator elevatorPassenger, Elevator elevatorService, ArrayList<Floor> floors) throws InterruptedException {
        Floor floor = floors.get(14);
        System.out.println("Пассажир номер два подходит к дверям лифта...");
        Thread.sleep(1000);
        System.out.println("Пассажир нажимает кнопку вызова лифта...");
        Thread.sleep(1000);
        if(elevatorPassenger.getState() == Elevator.ElevatorState.GO_UP || elevatorPassenger.getState() == Elevator.ElevatorState.GO_DOWN) {
            System.out.println("Лифт занят. Попробуйте нажать кнопку чуть позже...");
        } else {
            Elevator.ElevatorType elevatorType = floor.pushButtonCallElevator(elevatorPassenger,elevatorService,floors);
            if(elevatorType == Elevator.ElevatorType.PASSENGER) {
                System.out.println("Пассажир заходит в лифт...");
                Thread.sleep(1000);
                elevatorPassenger.movementBetweenDoors();
                System.out.println("Пассажир нажал на кнопку под номером 1...");
                elevatorPassenger.changeFloor(1,floors, Elevator.ElevatorType.PASSENGER);
                System.out.println("Пассажир выходит из лифта...");
                System.out.println("Состояние лифта: " + elevatorPassenger.getState() + ". Этаж лифта: " + elevatorPassenger.getNumberFloor() + ". Тип лифта: " + elevatorPassenger.getType());
            } else {
                System.out.println("Пассажир заходит в лифт...");
                Thread.sleep(1000);
                elevatorService.movementBetweenDoors();
                System.out.println("Пассажир нажал на кнопку под номером 1...");
                elevatorService.changeFloor(1,floors, Elevator.ElevatorType.SERVICE);
                System.out.println("Пассажир выходит из лифта...");
                System.out.println("Состояние лифта: " + elevatorService.getState() + ". Этаж лифта: " + elevatorService.getNumberFloor() + ". Тип лифта: " + elevatorService.getType());
            }
        }
        }
    }
