package model;

public abstract class Person{
	private String idNumber;
	private String name;
	private String lastName;

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

	public void setIdNumber(String idNumber){
		this.idNumber=idNumber;
	}

	public void setName(String name){
		this.name=name;
	}

	public void setLastName(String lastName){
		this.lastName=lastName;
	}
}

