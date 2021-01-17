package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class Car extends Vehicle {
	
	protected String name = "Car";

	@Override
	public boolean place(City city, Point location, Direction facing) {
		//TODO: Implement me!
		if (city.isSnowed(location)) {
			return false;
		}else {
			return super.place(city, location, facing);
		}	
	}
	
		@Override
	public boolean move() {
		Point temp = this.location;
		if (super.city.isSnowed(temp.translate(facing))) {
			return false;	
		}else {	
			return super.move();
		}		
	}
		
		
		
	
	
	@Override
	public void reportMoveError() {
		//TODO: Implement me!
		System.out.println(VehicleError.CAR_MOVE_ERROR);
	}

	@Override
	public void reportPlaceError() {
		//TODO: Implement me!
		System.out.println(VehicleError.CAR_PLACEMENT_ERROR);
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
