package elevators_project.elevator;

import javax.tools.Diagnostic;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.exceptions.WrongFloorException;

public class DefaultElevator implements Elevator {
    private int id;
    private int floorsNum;
    private int currentFloor;
    private int destinationFloor;
    private DestinationChoosingStrategy destinationChoosingStrategy;

    public DefaultElevator(int id, int storeysNum, int currentFloor, int destinationFloor) {
        this.id = id;
        this.floorsNum = storeysNum;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public void pickup(ElevatorOrder order) {
    }

    public void step() {
    }

    public int getId() {
        return this.id;
    }

    public void setCurrentFloor(int currentFloor) throws WrongFloorException {
        if (currentFloor > floorsNum || currentFloor < 0) {
            throw new WrongFloorException("There is no floor " + currentFloor);
        }
        this.currentFloor = currentFloor;
    }

    public void setDestinationFloor(int destinationFloor) throws WrongFloorException {
        if (destinationFloor > floorsNum || destinationFloor < 0) {
            throw new WrongFloorException("There is no floor " + destinationFloor);
        }
        this.destinationFloor = destinationFloor;
    }

    public String status() {
        return "(" + this.id + ", " + this.currentFloor + ", " + this.destinationFloor + ")";
    }

}
