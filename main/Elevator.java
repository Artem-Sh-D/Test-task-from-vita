import java.util.ArrayList;

public class Elevator {
    private Integer numberFloor = 1;
    private ElevatorState state = ElevatorState.STANDING_OPEN;
    private ElevatorType type;  


    public Elevator(ElevatorType type) {
        this.type = type;
    }

    public void pushButtonFloor(int numberButton, ElevatorType type, ArrayList<Floor> floors) throws InterruptedException {
        if(numberButton < 20 && numberButton >= 1) {
            changeFloor(numberButton,floors,type);
        } else {
            System.out.println("Такой кнопки не существует. Выберите этаж от 1 до 20");
        }
    }

    public void changeFloor(int newFloor, ArrayList<Floor> floors, ElevatorType type) throws InterruptedException {
        if(newFloor > this.numberFloor) {
            absenceBetweenDoors();
            System.out.println("Двери лифта закрываются...");
            Thread.sleep(1000);
            this.state = ElevatorState.CLOSING;
            System.out.println("Лифт начинает свое движение...");
            System.out.println("Лифт поднимается вверх...");
            this.state = ElevatorState.GO_UP;
            for(int i = this.numberFloor; i != newFloor; i++) {
                Thread.sleep(1000);
                setStateFloor(floors, type);
                System.out.println("Состояние лифта: " + getState() + ". Этаж лифта: " + i);
            }
            this.numberFloor = newFloor;
            System.out.println("Лифт прибыл на назначенный этаж...");
            Thread.sleep(3000);
            System.out.println("Лифт открывает двери...");
            this.state = ElevatorState.OPENING;
            Thread.sleep(3000);
            System.out.println("Лифт стоит с открытыми дверьми...");
            this.state = ElevatorState.STANDING_OPEN;
        }else if (newFloor < this.numberFloor) {
            absenceBetweenDoors();
            System.out.println("Двери лифта закрываются...");
            Thread.sleep(1000);
            this.state = ElevatorState.CLOSING;
            System.out.println("Лифт начинает свое движение...");
            System.out.println("Лифт опускается вниз...");
            this.state = ElevatorState.GO_DOWN;
            for(int i = this.numberFloor; i != newFloor; i--) {
                Thread.sleep(1000);
                setStateFloor(floors, type);
                System.out.println("Состояние лифта: " + getState() + ". Этаж лифта: " + i);
            }
            this.numberFloor = newFloor;
            System.out.println("Лифт прибыл на назначенный этаж...");
            Thread.sleep(3000);
            System.out.println("Лифт открывает двери...");
            this.state = ElevatorState.OPENING;
            Thread.sleep(3000);
            System.out.println("Лифт стоит с открытыми дверьми...");
            this.state = ElevatorState.STANDING_OPEN;
        } else {
            System.out.println("Лифт открывает двери...");
            this.state = ElevatorState.OPENING;
            Thread.sleep(3000);
            System.out.println("Лифт стоит с открытыми дверьми...");
            this.state = ElevatorState.STANDING_OPEN;
        }
    }

    private void setStateFloor(ArrayList<Floor> floors, ElevatorType type) {
        for(Floor floor : floors) {
            if(type == ElevatorType.PASSENGER) {
                floor.setPassengerElevatorFloor(numberFloor);
                floor.setPassengerElevatorState(state);
            } else if (type == ElevatorType.SERVICE) {
                floor.setServiceElevatorFloor(numberFloor);
                floor.setServiceElevatorState(state);
            }
        }
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void movementBetweenDoors() {
        System.out.println("Между дверьми обнаружен объект");
    }

    public void absenceBetweenDoors() {
        System.out.println("Между дверьми объект не обнаружен...");
    }
    public void buttonCallDispatcher() {
        System.out.println("Идет вызов диспетчера...");
    }
    public void setState(ElevatorState state) {
        this.state = state;
    }

    public ElevatorType getType() {
        return type;
    }

    public enum ElevatorState {
        GO_UP, GO_DOWN, OPENING, CLOSING, STANDING_OPEN
    }

    public enum ElevatorType {
        PASSENGER, SERVICE
    }
}
