package elevators_project.elevatororder;

import elevators_project.util.Direction;

public class ElevatorOrder {
    private int orderFloor;
    private Direction direction;

    public ElevatorOrder(int orderFloor, int directionNum) {
        this.orderFloor = orderFloor;
        if (directionNum >= 0) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.DOWN;
        }
    }

    public int getOrderFloor() {
        return this.orderFloor;
    }
}
