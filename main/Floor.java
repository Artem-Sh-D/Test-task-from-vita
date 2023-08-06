import java.util.ArrayList;
import java.util.Random;

public class Floor {
    private Integer passengerElevatorFloor;
    private Elevator.ElevatorState passengerElevatorState;
    private Integer serviceElevatorFloor;
    private Elevator.ElevatorState serviceElevatorState;
    private Integer number;
    private Boolean isButtonActive;

    public Floor(Integer passengerElevatorFloor,
                 Elevator.ElevatorState passengerElevatorState,
                 Integer serviceElevatorFloor,
                 Elevator.ElevatorState serviceElevatorState,
                 Integer number) {
        this.passengerElevatorFloor = passengerElevatorFloor;
        this.passengerElevatorState = passengerElevatorState;
        this.serviceElevatorFloor = serviceElevatorFloor;
        this.serviceElevatorState = serviceElevatorState;
        this.number = number;
        this.isButtonActive = false;
    }

    public static ArrayList<Floor> createFloors(int count, Elevator passengerElevator, Elevator serviceElevator) {
        ArrayList<Floor> floors = new ArrayList<>();

        for(int i = 0; i < count; ++i) {
            floors.add(new Floor(passengerElevator.getNumberFloor(), serviceElevator.getState(), serviceElevator.getNumberFloor(), passengerElevator.getState(), i + 1));
        }
        return floors;
    }

    public Elevator.ElevatorType pushButtonCallElevator(Elevator elevatorPassenger, Elevator elevatorService, ArrayList<Floor> floors) throws InterruptedException {
        this.isButtonActive = true;
        if((number - elevatorPassenger.getNumberFloor()) < (number - elevatorService.getNumberFloor())) {
            elevatorPassenger.changeFloor(number,floors, Elevator.ElevatorType.PASSENGER);
            this.isButtonActive = false;
            return Elevator.ElevatorType.PASSENGER;
        } else if ((number - elevatorPassenger.getNumberFloor()) > (number - elevatorService.getNumberFloor())) {
            elevatorService.changeFloor(number,floors, Elevator.ElevatorType.SERVICE);
            this.isButtonActive = false;
            return Elevator.ElevatorType.SERVICE;
        } else {
            Double randomNumber = Math.random() * 10;
            if(randomNumber > 5) {
                elevatorPassenger.changeFloor(number,floors, Elevator.ElevatorType.PASSENGER);
                this.isButtonActive = false;
                return Elevator.ElevatorType.PASSENGER;
            } else {
                elevatorService.changeFloor(number,floors, Elevator.ElevatorType.SERVICE);
                this.isButtonActive = false;
                return Elevator.ElevatorType.SERVICE;
            }
        }
    }

    public Integer getPassengerElevatorFloor() {
        return passengerElevatorFloor;
    }

    public void setPassengerElevatorFloor(Integer passengerElevatorFloor) {
        this.passengerElevatorFloor = passengerElevatorFloor;
    }

    public Elevator.ElevatorState getPassengerElevatorState() {
        return passengerElevatorState;
    }

    public void setPassengerElevatorState(Elevator.ElevatorState passengerElevatorState) {
        this.passengerElevatorState = passengerElevatorState;
    }

    public Integer getServiceElevatorFloor() {
        return serviceElevatorFloor;
    }

    public void setServiceElevatorFloor(Integer serviceElevatorFloor) {
        this.serviceElevatorFloor = serviceElevatorFloor;
    }

    public Elevator.ElevatorState getServiceElevatorState() {
        return serviceElevatorState;
    }

    public void setServiceElevatorState(Elevator.ElevatorState serviceElevatorState) {
        this.serviceElevatorState = serviceElevatorState;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                '}';
    }

    public Boolean getButtonActive() {
        return isButtonActive;
    }

    public void setButtonActive(Boolean buttonActive) {
        isButtonActive = buttonActive;
    }
}
