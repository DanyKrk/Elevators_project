package elevators_project.elevator;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;

public class DefaultElevator implements Elevator {
    private int storeysNum;
    private DestinationChoosingStrategy destinationChoosingStrategy;

    public DefaultElevator(int storeysNum) {
        this.storeysNum = storeysNum;
    }

    public void pickup(ElevatorOrder order) {
    }

    public void step() {

    }

}
