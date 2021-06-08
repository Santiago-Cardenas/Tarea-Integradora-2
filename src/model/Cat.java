package model;

public class Cat extends Habitat{

	/**
	* Description: variable that stores the height of the habitat<br>
	*/

	private double height;

	/**
	* Description: variable that stores the amount of weight the habitat can withstand<br>
	*/

	private double weight;

	/**
	* Description: Construction method of the Cat class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param length double
	* @param width double
	* @param state Habitat_State
	* @param height double
	* @param weight double
	*/

	public Cat (String idNumber, double length, double width,Habitat_State state,double height, double weight){
		super(idNumber,length,width,state);
		this.height=height;
		this.weight=weight;
	}

}
