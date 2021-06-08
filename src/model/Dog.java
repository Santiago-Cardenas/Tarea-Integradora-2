package model;

public class Dog extends Habitat{

	/**
	* Description: variable that stores the amount of toys the habitat has<br>
	*/

	private int toys;

	/**
	* Description: Construction method of the Dog class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param length double
	* @param width double
	* @param state Habitat_State
	* @param toys int
	*/

	public Dog (String idNumber, double length, double width,Habitat_State state, int toys){
		super(idNumber,length,width,state);
		this.toys=toys;
	}
		
}