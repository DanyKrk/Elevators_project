package elevators_project.destinationchoosingstrategy;

import java.util.List;
import elevators_project.elevatororder.ElevatorOrder;
import elevators_project.util.Direction;

public class MyDestinationChoosingStrategy implements DestinationChoosingStrategy {

    public ElevatorOrder getNextServedOrder(List<ElevatorOrder> orders, Direction direction, int floor) {
        ElevatorOrder nextServedOrder = null;
        int minDist = Integer.MAX_VALUE;
        switch (direction) {
            case DOWN:
                for (ElevatorOrder order : orders) {
                    if (order.getOrderFloor() > floor) {
                        continue;
                    }
                    int dist = floor - order.getOrderFloor();
                    if (dist <= minDist) {
                        minDist = dist;
                        nextServedOrder = order;
                    }
                }
                break;
            case UP:
                for (ElevatorOrder order : orders) {
                    if (order.getOrderFloor() < floor) {
                        continue;
                    }
                    int dist = order.getOrderFloor() - floor;
                    if (dist <= minDist) {
                        minDist = dist;
                        nextServedOrder = order;
                    }
                }
                break;
        }
        if (nextServedOrder == null) {
            for (ElevatorOrder order : orders) {
                int dist = Math.abs(floor - order.getOrderFloor());
                if (dist <= minDist) {
                    minDist = dist;
                    nextServedOrder = order;
                }
            }
        }
        return nextServedOrder;
    }

}
