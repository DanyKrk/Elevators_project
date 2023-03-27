package elevators_project.destinationchoosingstrategy;

import java.util.List;

import elevators_project.elevator.ElevatorState;
import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.util.Direction;

public interface DestinationChoosingStrategy {
    public ElevatorOrder getNextServedOrder(List<ElevatorOrder> orders, Direction lastDirection);
}
