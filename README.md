# Elevators_project

This is an app for managing the elevators in the building. Just run it ("public static void main" method in App.java), and the program will tell you what to do in the command prompt.

The app assigns the orders to the elevators by choosing the elevator that at the moment of issuing the request would need the least amount of simulation steps to serve the order. This assignment heuristics can be changed by using 
in ElevatorSystem class different class implementing the ElevatorChoosingStrategy interface.

The elevator first serve the orders that are on their current way. This  heuristics can be changed by using in ElevatorSystem class different class implementing the DestinationChoosingStrategy interface.

