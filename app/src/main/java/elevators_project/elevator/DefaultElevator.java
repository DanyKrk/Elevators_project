package elevators_project.elevator;

import java.util.ArrayList;
import java.util.List;

import elevators_project.destinationchoosingstrategy.DestinationChoosingStrategy;
import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.exceptions.WrongFloorException;
import elevators_project.util.Direction;

public class DefaultElevator implements Elevator {
    private int id;
    private int floorsNum;
    private int currentFloor;
    private ElevatorOrder currentlyServedOrder;
    private List<ElevatorOrder> orders;
    private DestinationChoosingStrategy destinationChoosingStrategy;
    private ElevatorState state;
    private Direction direction;

    public DefaultElevator(int id, int floorsNum, DestinationChoosingStrategy strategy) {
        this.id = id;
        this.floorsNum = floorsNum;
        this.currentFloor = 0;
        this.currentlyServedOrder = null;
        this.destinationChoosingStrategy = strategy;
        this.state = ElevatorState.WAITING;
        this.orders = new ArrayList<ElevatorOrder>();
        this.direction = Direction.UP;
    }

    public void pickup(ElevatorOrder order) {
        this.orders.add(order);
        currentlyServedOrder = destinationChoosingStrategy.getNextServedOrder(orders, direction, this.currentFloor);
    }

    public void step() {

    }

    public int getId() {
        return this.id;
    }

    public void setCurrentFloor(int currentFloor) throws WrongFloorException {
        if (currentFloor > floorsNum || currentFloor < 0) {
            throw new WrongFloorException("There is no floor " + currentFloor);
        }
        this.currentFloor = currentFloor;
    }

    public void setDestinationFloor(int destinationFloor) throws WrongFloorException {
        if (destinationFloor > floorsNum || destinationFloor < 0) {
            throw new WrongFloorException("There is no floor " + destinationFloor);
        }
        int directionNum = destinationFloor - this.currentFloor;
        ElevatorOrder order = new ElevatorOrder(destinationFloor, directionNum);
        this.orders.add(order);
        this.currentlyServedOrder = order;
    }

    public String status() {
        int destinationFloor = this.currentFloor;
        if (this.currentlyServedOrder != null) {
            destinationFloor = this.currentlyServedOrder.getOrderFloor();
        }
        return "(" + this.id + ", " + this.currentFloor + ", " + destinationFloor + ", "
                + this.state + ")";
    }

    public void update(int currentFloor, int destinationFloor) throws WrongFloorException {
        this.setCurrentFloor(currentFloor);
        this.setDestinationFloor(destinationFloor);
    }

    public List<ElevatorOrder> getOrders() {
        return this.orders;
    }

    public int calculateNumberOfSteps(ElevatorOrder order) {
        int steps = 0;
        List<ElevatorOrder> tempOrders = new ArrayList<>(this.orders);
        tempOrders.add(order);
        ElevatorState tempState = this.state;
        int tempFloor = this.currentFloor;
        Direction direction = this.direction;
        if (tempState == ElevatorState.CLOSING_DOORS) {
            steps += 1;

        }
        ElevatorOrder nextOrder = this.destinationChoosingStrategy.getNextServedOrder(tempOrders, direction, tempFloor);
        while (nextOrder != order) {
            tempOrders.remove(nextOrder);
            if (nextOrder.getOrderFloor() - tempFloor > 0) {
                direction = Direction.UP;
            } else if (nextOrder.getOrderFloor() - tempFloor < 0) {
                direction = Direction.DOWN;
            }
            steps += Math.abs(nextOrder.getOrderFloor() - tempFloor);
            tempFloor = nextOrder.getOrderFloor();
            steps += 2;
            nextOrder = this.destinationChoosingStrategy.getNextServedOrder(tempOrders, direction, tempFloor);
        }
        steps += Math.abs(nextOrder.getOrderFloor() - tempFloor);
        return steps;
    }

}
