package model;

public abstract class Person{

	/**
	* Description: variable that stores the personal id of a person<br>
	*/

	private String idNumber;

	/**
	* Description: variable that stores the first name of a person<br>
	*/

	private String name;

	/**
	* Description: variable that stores the last name of a person<br>
	*/

	private String lastName;

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String
	* @param name String
	* @param lastName String
	*/

	public Person (String idNumber, String name, String lastName){
		this.idNumber=idNumber;
		this.name=name;
		this.lastName=lastName;
	}
		
	public String getIdNumber(){
		return idNumber;
	}

	public String getName(){
		return name;
	}

	public String getLastName(){
		return lastName;
	}
}

