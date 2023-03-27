package elevators_project.elevatorsystem;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.destinationchoosingstrategy.MyDestinationChoosingStrategy;
import elevators_project.elevator.DefaultElevator;
import elevators_project.elevator.Elevator;
import elevators_project.elevatorchoosingstrategy.ElevatorChoosingStrategy;
import elevators_project.elevatorchoosingstrategy.MyElevatorChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.exceptions.WrongFloorException;
import elevators_project.exceptions.WrongIdException;
import elevators_project.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private int floorsNum;
    private int elevatorsNum;
    private ElevatorChoosingStrategy elevatorChoosingStrategy;
    private DestinationChoosingStrategy destinationChoosingStrategy;

    public ElevatorSystem(int floorsNum, int elevatorsNum) {
        this.floorsNum = floorsNum;
        this.elevatorsNum = elevatorsNum;
        destinationChoosingStrategy = new MyDestinationChoosingStrategy();
        elevatorChoosingStrategy = new MyElevatorChoosingStrategy();
        elevators = new ArrayList<Elevator>();
        for (int i = 0; i < elevatorsNum; i++) {
            elevators.add(new DefaultElevator(i, floorsNum, destinationChoosingStrategy));
        }
    }

    public void pickup(int floor, int direction) throws WrongFloorException {
        if (floor >= floorsNum || floor < 0) {
            throw new WrongFloorException("There is no floor: " + floor);
        }
        ElevatorOrder order = new ElevatorOrder(floor, direction);
        Elevator chosenElevator = elevatorChoosingStrategy.chooseElevator(this.elevators, order);
        chosenElevator.pickup(order);
    }

    public void order(int id, int orderFloor) throws WrongFloorException, WrongIdException {
        Elevator elevator = null;
        for (int i = 0; i < elevatorsNum; i++) {
            if (elevators.get(i).getId() == id) {
                elevator = elevators.get(i);
            }
        }
        if (elevator == null) {
            throw new WrongIdException("There is no elevator with id: " + id);
        }
        if (orderFloor >= floorsNum || orderFloor < 0) {
            throw new WrongFloorException("There is no floor: " + orderFloor);
        }
        int directionNum;
        if (elevator.getDirection() == Direction.UP) {
            directionNum = 1;
        } else {
            directionNum = -1;
        }
        // TODO - do something better than positive/negative numbers
        ElevatorOrder order = new ElevatorOrder(orderFloor, directionNum);
        elevator.pickup(order);
    }

    public void update(int id, int currentFloor, int destinationFloor) throws WrongIdException, WrongFloorException {
        Elevator elevator = null;
        for (int i = 0; i < elevatorsNum; i++) {
            if (elevators.get(i).getId() == id) {
                elevator = elevators.get(i);
            }
        }
        if (elevator == null) {
            throw new WrongIdException("There is no elevator with id: " + id);
        }
        elevator.update(currentFloor, destinationFloor);
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
