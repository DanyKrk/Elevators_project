package elevators_project.elevatorsystem;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.elevator.DefaultElevator;
import elevators_project.elevator.Elevator;
import elevators_project.elevatorchoosingstrategy.ElevatorChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private int storeysNum;
    private int elevatorsNum;
    private ElevatorChoosingStrategy elevatorChoosingStrategy;
    private DestinationChoosingStrategy destinationChoosingStrategy;

    public ElevatorSystem(int storeysNum, int elevatorsNum) {
        this.storeysNum = storeysNum;
        this.elevatorsNum = elevatorsNum;
        elevators = new ArrayList<Elevator>();
        for (int i = 0; i < elevatorsNum; i++) {
            elevators.add(new DefaultElevator(i, storeysNum, 0, 0));
        }
    }

    public void pickup(int floor, int direction) {
        ElevatorOrder order = new ElevatorOrder(floor, direction);
        Elevator chosenElevator = elevatorChoosingStrategy.chooseElevator(this.elevators, order);
        chosenElevator.pickup(order);

    }

    public void update(int id, int currentFloor, int destinationFloor) {
        Elevator elevator = null;
        for (int i = 0; i < elevatorsNum; i++) {
            if (elevators.get(i).getId() == id) {
                elevator = elevators.get(i);
            }
        }
        if (elevator == null) {
            // TODO - exception
            return;
        }
        elevator.setCurrentFloor(currentFloor);
        elevator.setDestinationFloor(destinationFloor);
    }

    public void step() {
        for (int i = 0; i < elevatorsNum; i++) {
            elevators.get(i).step();
        }
    }

    public String status() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elevatorsNum; i++) {
            sb.append(elevators.get(i).status());
            if (i < elevatorsNum - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
