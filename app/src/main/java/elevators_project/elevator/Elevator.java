package elevators_project.elevator;

import java.util.List;

import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.exceptions.WrongFloorException;
import elevators_project.util.Direction;

public interface Elevator {

    public void pickup(ElevatorOrder order);

    public void step();

    public int getId();

    public void setCurrentFloor(int currentFloor) throws WrongFloorException;

    public void setDestinationFloor(int destinationFloor) throws WrongFloorException;

    public String status();

    public void update(int currentFloor, int destinationFloor) throws WrongFloorException;

    public List<ElevatorOrder> getOrders();

    public int calculateNumberOfSteps(ElevatorOrder order);

    public Direction getDirection();
}
