package elevators_project.elevator;

import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.exceptions.WrongFloorException;

public interface Elevator {
    public void pickup(ElevatorOrder order);

    public void step();

    public int getId();

    public void setCurrentFloor(int currentFloor) throws WrongFloorException;

    public void setDestinationFloor(int destinationFloor) throws WrongFloorException;

    public String status();

    public void update(int currentFloor, int destinationFloor) throws WrongFloorException;
}
