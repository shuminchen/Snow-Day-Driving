package edu.brandeis.cs12b.pa4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;

public abstract class Vehicle {

	protected Point location;
	protected City city;
	protected Direction facing;
	
	/**
	 * This places your vehicle into a city. If invalid, ensure that 
	 * somewhere in your code the proper VehicleError is printed.
	 * 
	 * @param city the city to be placed into
	 * @param location the location in the city to be placed
	 * @param facing this direction
	 * @return true if this happens successfully, false if not
	 */
	public boolean place(City city, Point location, Direction facing) {
		//TODO: Implement Baseline place method
		this.city = city;
		if ( location.x>0 && location.x<city.maxX && location.y>0 && location.y<city.maxY) {
			if (facing == Direction.EAST || facing == Direction.NORTH || facing == Direction.SOUTH || facing == Direction.WEST) {
				if (!this.city.isOffRoad(location)){	
					this.location = location;
					this.facing = facing;
					return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * This method should move your vehicle one cell in the direction it was facing.
	 * If your vehicle can't move because there's a wall in the way, it should stay in
	 * same place and call the reportError(), then return false so it can be taken
	 * off the list of active vehicles
	 * @return true if the move was successfully made, false if not
	 */
	public boolean move(){
		//TODO: Implement baseline move method

		Point translate = this.location.translate(this.facing);
		if (this.city.isOffRoad(translate)) {
		//	reportMoveError();
			return false;		
		}
		this.location = translate;
		return true;	
		
		
	}
	
		

	

	/**
	 * This method reports if a vehicle can't move. This should be different for each vehicle.
	 * Use the VehicleError Enum to get the text to print.
	 */
	public abstract void reportMoveError();
	
	/**
	 * Likewise for placing a vehicle.
	 */
	public abstract void reportPlaceError();
	
	/**
	 * This method turns the vehicle in question to the right. Not all vehicles
	 * have this capability, however. So make sure only certain of your vehicles
	 * can turn right.
	 */
	protected void turnRight() {
		//TODO: Implement me!
		if (this.facing == Direction.NORTH) {
			this.facing = Direction.EAST;
		}else if (this.facing == Direction.SOUTH) {
			this.facing = Direction.WEST;
		}else if (this.facing == Direction.EAST) {
			this.facing = Direction.SOUTH;
		}else if (this.facing == Direction.WEST) {
			this.facing = Direction.NORTH;
		}
		
	}
	
	/**
	 * This method turns the vehicle in question to the left. Not all vehicles
	 * have this capability, however. So make sure only certain of your vehicles
	 * can turn left.
	 */
	protected void turnLeft(){
		//TODO: Implement me!
		if (this.facing == Direction.NORTH) {
			this.facing = Direction.WEST;
		}else if (this.facing == Direction.SOUTH) {
			this.facing = Direction.EAST;
		}else if (this.facing == Direction.EAST) {
			this.facing = Direction.NORTH;
		}else if (this.facing == Direction.WEST) {
			this.facing = Direction.SOUTH;
		}
	}

	/**
	 * Methods for getting the name of the vehicle and converting to a string have been implemented
	 * for you. However, you should study how this mechanism works to get a sense of how you might
	 * implement inheritance among the various vehicles.
	 */
	public abstract String getName();

	public String toString(){
		return this.getName() + " " + this.location.toString();
	}
	
	public boolean hasVehicle(){	
	//	for (int i=0;i<vehicles.size(); i++){				
		//	String[] otherVehicle = this.vehicles.get(i).toString().split(" ");
		//	if (otherVehicle[1] == this.location.toString()) {
		//		return true;
		//	}
			
	//	}		

		
		
		return false;
	}
	
	
	
}
