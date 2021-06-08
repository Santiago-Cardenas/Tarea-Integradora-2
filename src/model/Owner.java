package model;

public class Owner extends Person{
	
	/**
	* Description: variable that stores the phone of a owner<br>
	*/

	private String phone;

	/**
	* Description: variable that stores the adress of a owner<br>
	*/

	private String adress;

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String
	* @param name String
	* @param lastName String
	* @param phone String
	* @param adress String
	*/

	public Owner (String idNumber, String name, String lastName,String phone,String adress){
		super(idNumber,name,lastName);
		this.phone=phone;
		this.adress=adress;
	}

	public String getPhone(){
		return phone;
	}

	public String getAdress(){
		return adress;
	}		
}
