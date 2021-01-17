package edu.brandeis.cs12b.pa4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.brandeis.cs12b.pa4.provided.City;
import edu.brandeis.cs12b.pa4.provided.Direction;
import edu.brandeis.cs12b.pa4.provided.HumanSimResponses;
import edu.brandeis.cs12b.pa4.provided.Point;

public class HumanSim extends Simulator {

	private static final String newLine = System.getProperty("line.separator");
	private Scanner console = new Scanner(System.in);

	/**
	 * This has been implemented for you. It is used upon creation of a 
	 * HumanSim object in the SnowSimClient class, as well as in the tests.
	 * Executes the runHumanSimulation loop.
	 */
	public HumanSim() {
		this.runHumanSimulation();
	}
	
	
	public void runHumanSimulation() {
		System.out.println(HumanSimResponses.START_SIMULATION);
		loadCity();
		System.out.println(this);
		Boolean loop = true;
		
		/**
		 * This is the primary loop for your simulation.
		 * It should prompt the user for input. Then, if given a valid command,
		 * you should invoke either the placeVehicle, step, or list method.
		 * If the command is to "exit", break out of the loop by setting 
		 * "loop" to false.
		 * 
		 *  Make sure to print the proper enum string from HumanSimResponses at each point
		 *  when appropriate. Pay strict attention to the PDF instructions.
		 */
		while(loop) {
			//TODO: Implement me!	
				System.out.println(HumanSimResponses.PROMPT_FOR_MOVE);
				String command = console.nextLine();		
				if(command.startsWith("place")) {
						String[] commandArray = command.split(" ");
						boolean placedVehicle = placeVehicle(commandArray);
						if(placedVehicle) {
							System.out.println(HumanSimResponses.CONFIRM_PLACE);			
						}		
				}else if (command.equals("step")) {
					step();
				}else if(command.equals("list")) {
					list();
				}else if (command.equals("exit")) {
					loop = false;
					System.out.println(HumanSimResponses.END_SIMULATION);
				} else {
					System.out.println(HumanSimResponses.INVALID_COMMAND);
				}
		}
	}
	
	
	/**
	 * You should use this method in your runHumanSimulation loop.
	 * You can pass it an array of strings taken from parsing the user input.
	 * If the given vehicle name is not valid, your program should use enums to 
	 * print that the vehicle was invalid, *as well as that the place failed*.
	 * 
	 * Otherwise, create a Vehicle, Point, and Direction from the user input
	 * and pass them to the superclass placeVehicle method.
	 * 
	 * ("args" is short for "arguments".)
	 * @param args
	 * @return
	 */
	public boolean placeVehicle(String[] args) {
		Vehicle vehicle = null;
		Point point = null;
		Direction direction = null;
		//TODO: Implement the rest of me!
			if (args.length==4) {
				if (args[1].equals("Car") || args[1].equals("SnowPlow") || args[1].equals("LeftSnowPlow") || args[1].equals("RightSnowPlow")) {
					if(args[2].startsWith("(") && args[2].endsWith(")") && args[2].contains(",")) {
						point = new Point(args[2]);	
						direction = Direction.valueOf(args[3]);
						if(args[1].equals("Car") ) {
							vehicle = new Car();
						}else if(args[1].equals("SnowPlow")) {
							vehicle = new SnowPlow();
						}else if(args[1].equals("LeftSnowPlow")) {
							vehicle = new LeftSnowPlow();
						}else if(args[1].equals("RightSnowPlow")) {
							vehicle = new RightSnowPlow();	
						}
						return super.placeVehicle(vehicle, point, direction);								
					}else{
							System.out.println(HumanSimResponses.INVALID_PLACE);
					}	
				}else {
					System.out.println(HumanSimResponses.INVALID_VEHICLE);
					System.out.println(HumanSimResponses.INVALID_PLACE);
					}
				}
				else{
					System.out.println(HumanSimResponses.INVALID_PLACE);
				}
			return false;
			}
					
	
								
	
	
	/*
	 * Included for your convenience, to be used in the loop.
	 * Q for review: Why is there not a conflict between step() and step(int numberOfSteps)?
	 */
	
	public void step() {
		this.step(1);
	}

	/**
	 * You should use this method in your runHumanSimulation loop.
	 * This method is completed for you. However, you must still
	 * implement step(numberOfSteps) in the Simulator, which is the superclass
	 * of HumanSim.
	 */
	@Override
	public void step(int numberOfSteps) {

		//TODO: Implement step(numberOfSteps) in the superclass!

		super.step(numberOfSteps);
		System.out.println(this);
	}
	
	/**
	 * You should use this method in your runHumanSimulation loop.
	 * This should list each vehicle currently active in the city.
	 */
	private void list() {
		//TODO: Implement me!  use for each loop
		for (Vehicle v : vehicles){				
				System.out.println(v);;
			}		
	}
	
	
	/**
	 * This has been implemented for you. However, you would do well to study it
	 * for future reference on parsing a text file. This also contains
	 * hints for how you might use enums in your loop.
	 */
	private void loadCity(){
		System.out.println(HumanSimResponses.LOAD_CITY);
		Scanner cityReader;
		while(true){
			try {
				cityReader = new Scanner(new File(console.nextLine()));
				break;
			} catch (FileNotFoundException e) {
				System.out.println(HumanSimResponses.INVALID_FILE);
			}
		}
		
		int maxX = Integer.parseInt(cityReader.nextLine());
		int maxY = Integer.parseInt(cityReader.nextLine());
		int[][] layout = new int[maxY][maxX];
		for (int y = 0 ; y < maxY; y++){
			String line = cityReader.nextLine();
			for (int x = 0 ; x < maxX ; x++){
				layout[y][x] = Character.getNumericValue(line.charAt(x));
			}
		}
		this.city = new City(layout);
		System.out.println(HumanSimResponses.CITY_LOADED);
	}
	
	/**
	 * This has also been implemented for you. You likewise will benefit from
	 * studying this method for hints as to how you might implement your
	 * placeVehicle, step, and list methods.
	 */
	@Override
	public String toString() {
		String cityOutput = super.toString();
		String[] splitOutput = cityOutput.split("\\W+");

		for (Vehicle v : vehicles){
			Point loc = v.location;
			splitOutput[((this.city.maxX * loc.y) + loc.x + 1)] = "*";
		}

		StringBuilder output = new StringBuilder("");
		for (int y = 0; y < this.city.maxY; y++){
			for (int x = 1; x < (this.city.maxX + 1) ; x++){
				output.append(splitOutput[((this.city.maxX * y) + x)]);
			}
			output.append(newLine);
		}
		return output.toString();
	}
}
