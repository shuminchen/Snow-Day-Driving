package edu.brandeis.cs12b.pa4;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;
import edu.brandeis.cs12b.pa4.provided.VehicleError;

public class LeftSnowPlow extends SnowPlow {

	protected String name = "LeftSnowPlow";
	
	@Override
	public boolean place(City city, Point location, Direction facing) {
		//TODO: Implement me!
		if(super.place(city, location, facing)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean move() {
		//TODO: Implement me!
		if (super.move()) {
			return true;
		}
		turnLeft();
		if(super.move()) {
			return true;	
		}
		return false;
	}
	
	@Override
	public void reportMoveError() {
		//TODO: Implement me!
		System.out.println(VehicleError.LEFTSNOWPLOW_MOVE_ERROR);
	}
	
	@Override
	public void reportPlaceError() {
		//TODO: Implement me!
		System.out.println(VehicleError.LEFTSNOWPLOW_PLACEMENT_ERROR);
	}
	
	/**
	 * This has been implemented for you.
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
