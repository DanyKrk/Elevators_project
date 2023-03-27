package elevators_project.elevatorchoosingstrategy;

import java.util.List;

import elevators_project.elevator.Elevator;
import elevators_project.elevatororder.ElevatorOrder;

public interface ElevatorChoosingStrategy {
    Elevator chooseElevator(List<Elevator> elevators, ElevatorOrder order);
}
