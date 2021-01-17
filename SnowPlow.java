package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class SnowPlow extends Vehicle {
	
	protected String name = "SnowPlow";

	@Override
	public boolean place(City city, Point location, Direction facing) {
		//TODO: Implement me!
		if(super.place(city, location, facing)) {
			if (super.city.isSnowed(location)) {
				super.city.clearSnow(location);
			}
			return true;
		}
			return false;		
	}
		
	
	@Override
	public boolean move() {
		//TODO: Implement me!
		if (super.move()) {
			this.city.clearSnow(this.location);
			return true;
		}
		return false;
	}
		
	

	@Override
	public void reportMoveError() {
		//TODO: Implement me!
		System.out.println(VehicleError.SNOWPLOW_MOVE_ERROR);
	}

	@Override
	public void reportPlaceError() {
		//TODO: Implement me!
		System.out.println(VehicleError.SNOWPLOW_PLACEMENT_ERROR);
	}

	/**
	 * This has been implemented for you.
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
