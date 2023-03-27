package elevators_project.elevator;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;

public class DefaultElevator implements Elevator {
    private int id;
    private int storeysNum;
    private int currentFloor;
    private int destinationFloor;
    private DestinationChoosingStrategy destinationChoosingStrategy;

    public DefaultElevator(int id, int storeysNum, int currentFloor, int destinationFloor) {
        this.id = id;
        this.storeysNum = storeysNum;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public void pickup(ElevatorOrder order) {
    }

    public void step() {
    }

    private void updateDestination() {

    }

    public int getId() {
        return this.id;
    }

    public void setCurrentFloor(int currentFloor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentFloor'");
    }

    public void setDestinationFloor(int destinationFloor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDestinationFloor'");
    }

    public String status() {
        return "(" + this.id + ", " + this.currentFloor + ", " + this.destinationFloor + ")";
    }

}
