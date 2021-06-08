package model;

public class Habitat{

	/**
	* Description: variable that stores the idNumber of the habitat<br>
	*/

	private String idNumber;

	/**
	* Description: variable that stores the length of the habitat<br>
	*/
	
	private double length;

	/**
	* Description: variable that stores the width of the habitat<br>
	*/
	
	private double width;

	/**
	* Description: Relation with the Habitat_State class // This is a variable that stores the state of a habitat<br>
	*/
	
	private Habitat_State state;

	/**
	* Description: Relation with the Pet class // This is a variable that stores a pet that is going to be stored on a habitat<br>
	*/
	
	private Pet pet;

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param length double 
	* @param width double 
	* @param state Habitat_State
	*/

	public Habitat (String idNumber, double length, double width,Habitat_State state){
		this.idNumber=idNumber;
		this.length=length;
		this.width=width;
		this.state=state;
	}

	public String getIdNumber(){
		return idNumber;
	}

	public double getLength(){
		return length;
	}

	public double getWidth(){
		return width;
	}

	public Habitat_State getState(){
		return state;
	}

	public Pet getPet(){
		return pet;
	}

	public void setIdNumber(String idNumber){
		this.idNumber=idNumber;
	}

	public void setState(Habitat_State state){
		this.state=state;
	}

	public void setPet(Pet pet){
		this.pet=pet;
	}
		
}
