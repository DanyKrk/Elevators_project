package elevators_project.destinationchoosingstrategy;

import java.util.List;

import elevators_project.elevator.ElevatorState;
import elevators_project.elevatororder.ElevatorOrder;

public interface DestinationChoosingStrategy {
    public ElevatorOrder getCurrentlyServedOrder(List<ElevatorOrder> orders, ElevatorState state);
}
