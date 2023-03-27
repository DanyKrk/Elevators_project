package elevators_project.elevatorchoosingstrategy;

import java.util.List;

import elevators_project.elevator.Elevator;
import elevators_project.elevatororder.ElevatorOrder;

public class MyElevatorChoosingStrategy implements ElevatorChoosingStrategy {

    @Override
    public Elevator chooseElevator(List<Elevator> elevators, ElevatorOrder order) {
        int minCost = Integer.MAX_VALUE;
        Elevator chosenElevator = null;
        for (Elevator elevator : elevators) {
            int elevatorCost = elevator.calculateNumberOfSteps(order) + elevator.getOrders().size();
            if (minCost > elevatorCost) {
                minCost = elevatorCost;
                chosenElevator = elevator;
            }
        }
        return chosenElevator;
    }
}
