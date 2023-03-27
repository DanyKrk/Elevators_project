package elevators_project.elevatorsystem;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.elevator.DefaultElevator;
import elevators_project.elevator.Elevator;
import elevators_project.elevatorchoosingstrategy.ElevatorChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;

import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private int storeysNum;
    private ElevatorChoosingStrategy elevatorChoosingStrategy;
    private DestinationChoosingStrategy destinationChoosingStrategy;

    public ElevatorSystem(int storeysNum, int elevatorsNum) {
        this.storeysNum = storeysNum;
        // for (int i = 0; i < elevatorsNum; i++) {
        // elevators.add(new Elevator(storeysNum));
        // }
    }

    public void pickup(int floor, int direction) {
        ElevatorOrder order = new ElevatorOrder(floor, direction);
        DefaultElevator chosenElevator = elevatorChoosingStrategy.chooseElevator(this.elevators, order);
        chosenElevator.pickup(order);

    }

    public void update(int id, int curr_fl, int dest_fl) {
    }

    public void step() {
    }

    public String status() {
        return null;
    }
}
