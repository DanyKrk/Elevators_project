package elevators_project.elevator;

import elevators_project.elevatororder.ElevatorOrder;

public interface Elevator {
    public void pickup(ElevatorOrder order);

    public void step();

}
