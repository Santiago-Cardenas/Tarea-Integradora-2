package model;

public class Reptile extends Habitat{

	/**
	* Description: Relation with the Aquarium_Type class // This is a variable that stores the type of aquarium<br>
	*/

	private Aquarium_Type type;

	/**
	* Description: variable that stores the material of the habitat<br>
	*/

	private String material;

	/**
	* Description: Construction method of the Reptile class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param length double
	* @param width double
	* @param state Habitat_State
	* @param type Aquarium_Type
	* @param material String
	*/

	public Reptile (String idNumber, double length, double width,Habitat_State state,Aquarium_Type type, String material){
		super(idNumber,length,width,state);
		this.type=type;
		this.material=material;
	}
		
}