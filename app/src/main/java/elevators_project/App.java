/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package elevators_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import elevators_project.elevatorsystem.ElevatorSystem;
import elevators_project.exceptions.WrongFloorException;
import elevators_project.exceptions.WrongIdException;

public class App {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int floorsNum = -1;
        int elevatorsNum = -1;
        ElevatorSystem elevatorSystem;

        boolean validInput = false;
        System.out.println("How many storeys does the building have?: ");
        while (!validInput) {
            try {
                floorsNum = Integer.parseInt(reader.readLine());
                if (floorsNum < 1) {
                    System.out.println(
                            "The number of storeys should be an integer greater than 0. Please enter the correct number of storeys: ");
                } else {
                    validInput = true;
                }
            } catch (IOException e) {
                System.out.println("Error reading input. Please try again: ");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
        validInput = false;
        System.out.println("How many elevators does the building have (1-16)?");
        while (!validInput) {
            try {
                elevatorsNum = Integer.parseInt(reader.readLine());
                if (elevatorsNum > 16 || elevatorsNum < 1) {
                    System.out.println(
                            "The number of elevators should be an integer between 1 and 16. Pleasen enter the correct number of elevators: ");
                } else {
                    validInput = true;
                }
            } catch (IOException e) {
                System.out.println("Error reading input. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        elevatorSystem = new ElevatorSystem(floorsNum, elevatorsNum);

        String command = "";
        while (!command.equals("q")) {
            System.out.println("Enter the command (order/pickup/update/step/status) or exit by entering q: ");
            try {
                command = reader.readLine();
                switch (command) {
                    case "order":
                        System.out.println(
                                "Enter the id of the elevator where the order is issued: ");
                        int elId = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the floor where the elevator is ordered: ");
                        int orderFloor = Integer.parseInt(reader.readLine());
                        elevatorSystem.order(elId, orderFloor);
                        break;
                    case "pickup":
                        System.out.println("Enter the floor where the elevator is ordered: ");
                        int floor = Integer.parseInt(reader.readLine());
                        System.out.println(
                                "Enter the direction (positive number means up, negative number means down): ");
                        int direction = Integer.parseInt(reader.readLine());
                        // TODO - do something better than positive/negative numbers
                        elevatorSystem.pickup(floor, direction);
                        break;
                    case "update":
                        System.out.println("Enter the ID of the elevator to update: ");
                        int id = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the current floor of the elevator: ");
                        int curr_fl = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the destination floor of the elevator: ");
                        int dest_fl = Integer.parseInt(reader.readLine());
                        elevatorSystem.update(id, curr_fl, dest_fl);
                        break;
                    case "step":
                        elevatorSystem.step();
                        break;
                    case "status":
                        System.out.println("Status: " + elevatorSystem.status());
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input. Please try again.");
            } catch (WrongIdException e) {
                System.out.println("Wrong id specified: " + e.getMessage());
            } catch (WrongFloorException e) {
                System.out.println("Wrong floor specified: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }

        }
    }
}
