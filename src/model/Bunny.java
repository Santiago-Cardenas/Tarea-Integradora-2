package model;

public class Bunny extends Habitat{

	/**
	* Description: variable that stores the type of plant the habitat has<br>
	*/

	private String plantType;

	/**
	* Description: variable that stores the amount of plants the habitat has<br>
	*/

	private int plantAmount;

	/**
	* Description: Construction method of the Bunny class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param length double
	* @param width double
	* @param state Habitat_State
	* @param plantType String
	* @param plantAmount String
	*/

	public Bunny (String idNumber, double length, double width,Habitat_State state,String plantType, int plantAmount){
		super(idNumber,length,width,state);
		this.plantType=plantType;
		this.plantAmount=plantAmount;
	}
		
}