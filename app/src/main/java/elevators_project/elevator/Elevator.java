package elevators_project.elevator;

import elevators_project.elevatororder.ElevatorOrder;

public interface Elevator {
    public void pickup(ElevatorOrder order);

    public void step();

    public int getId();

    public void setCurrentFloor(int currentFloor);

    public void setDestinationFloor(int destinationFloor);

    public String status();
}
