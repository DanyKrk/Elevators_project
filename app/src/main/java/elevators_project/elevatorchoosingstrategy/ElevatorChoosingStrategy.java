package elevators_project.elevatorchoosingstrategy;

import java.util.List;

import elevators_project.elevator.DefaultElevator;
import elevators_project.elevator.Elevator;
import elevators_project.elevatororder.ElevatorOrder;

public interface ElevatorChoosingStrategy {
    DefaultElevator chooseElevator(List<Elevator> elevators, ElevatorOrder order);
}
