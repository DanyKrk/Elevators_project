package elevators_project.elevatorsystem;

import elevators_project.elevator.Elevator;

import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private int storeysNum;

    public ElevatorSystem(int storeysNum, int elevatorsNum) {
        this.storeysNum = storeysNum;
        // for (int i = 0; i < elevatorsNum; i++) {
        // elevators.add(new Elevator(storeysNum));
        // }
    }

    public void pickup(int floor, int direction) {
    }

    public void update(int id, int curr_fl, int dest_fl) {
    }

    public void step() {
    }

    public String status() {
        return null;
    }
}
