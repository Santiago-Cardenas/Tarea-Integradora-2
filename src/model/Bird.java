package model;

public class Bird extends Habitat{

	/**
	* Description: variable that stores the height of the habitat<br>
	*/

	private double height;
	
	/**
	* Description: variable that stores the amount of birds that a habitat can store<br>
	*/

	private int quantity;
	
	/**
	* Description: Relation with the Cage class // This is a variable that stores the type of cage<br>
	*/

	private Cage cage;

	/**
	* Description: Construction method of the Bird class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param length double
	* @param width double
	* @param state Habitat_State
	* @param height double
	* @param quantity int
	* @param cage Cage
	*/

	public Bird (String idNumber, double length, double width,Habitat_State state,double height, int quantity, Cage cage){
		super(idNumber,length,width,state);
		this.cage=cage;
		this.height=height;
		this.quantity=quantity;
	}
		
}
