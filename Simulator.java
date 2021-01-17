package edu.brandeis.cs12b.pa4;

import java.util.ArrayList;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import java.util.*;
public class Simulator {
	
	protected ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	protected City city;
	
	/**
	 * Creates a new simulation for a city
	 * @param city to be simulated
	 */
	public Simulator(City city){
		this.city = city;
	}
	
	/** 
	 * Required for the HumanSim constructor.
	 * You do not need to alter this constructor.
	 */
	protected Simulator(){}

	/**
	 * This should move each vehicle in the city the given number of steps
	 * on the city map in the appropriate direction.
	 * Note that it is also invoked by step(numberOfSteps) in the HumanSim subclass.
	 * If a vehicle makes an invalid move, ensure the correct error is
	 * printed and remove it from the state.
	 */
	public void step(int numberOfSteps){
		//TODO: Implement me!
		for (int i=0; i<numberOfSteps;i++) {
			Iterator<Vehicle> iter = vehicles.iterator();
			while(iter.hasNext()) {
				Vehicle ve = iter.next();
				boolean moveSuccess = ve.move();		
				if (moveSuccess == false) {
					ve.reportMoveError();
					iter.remove();		
				}
			}
		}	
	}

	/**
	 * Places a Vehicle in the city
	 * You will also invoke this method from the HumanSim subclass's placeVehicle method
	 * after parsing user input and creating a Vehicle, Point, and Direction
	 * (if valid). 
	 * 
	 * @param vehicle to place in the city
	 * @param location to place the vehicle in the city
	 * @return true if vehicle is successfully placed, false if not
	 */
	public boolean placeVehicle(Vehicle vehicle, Point location, Direction facing){
		//TODO: Implement me!	
		if(vehicle.place(this.city, location, facing)) {
			this.vehicles.add(vehicle);
			return true;
		}else {
			vehicle.reportPlaceError();
			System.out.println(HumanSimResponses.INVALID_PLACE);
		}
		return false;
	}
	
	/**
	 * Check to see if the Simulation's city is clear
	 * @return true if the city is clear, false if not
	 */
	public boolean isClear(){
		return this.city.isClear();
	}
	
	public String toString(){
		return this.city.toString();
	}
}
