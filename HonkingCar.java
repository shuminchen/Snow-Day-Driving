package edu.brandeis.cs12b.pa4;

import java.util.Iterator;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.ExtraCreditResponses;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

/*MonsterTruck is the same as Car. The only difference is that 
 * If the MonsterTruck ever moves into a tile with another Vehicle,
 * that Vehicle is crushed and removed from the active Vehicles list.
 */
public class HonkingCar extends Car {
	
	protected String name = "HonkingCar";

	@Override
	public boolean place(City city, Point location, Direction facing) {
		//TODO: Implement me!
		if (city.isSnowed(location)) {
			return false;
		}else {
			honking();
			return super.place(city, location, facing);
		}	
	}
	
		@Override
	public boolean move() {
		Point temp = this.location;
		if (super.city.isSnowed(temp.translate(facing))) {
			return false;	
		}else {
			honking();			
			return super.move();
		}		
	}
		
	
	
	@Override
	public void reportMoveError() {
		//TODO: Implement me!
		System.out.println(VehicleError.HONKINGCAR_MOVE_ERROR);
	}

	@Override
	public void reportPlaceError() {
		//TODO: Implement me!
		System.out.println(VehicleError.HONKINGCAR_PLACEMENT_ERROR);
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public void honking() {
		if(super.hasVehicle()) {
			System.out.println(ExtraCreditResponses.CAR_HONK);
		}
	}
}
