package model;

public class Vet extends Person{

	/**
	* Description: variable that stores the value of the special id of a vet<br>
	*/

	private String vetId;

	/**
	* Description: Relation with the Vet_State class // This is a variable that stores the current State of a vet<br>
	*/

	private Vet_State state;

	/**
	* Description: variable that stores the amount of consults a vet has made<br>
	*/

	private int amountConsults;

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param idNumber String 
	* @param name String 
	* @param lastName String 
	* @param vetId String
	* @param state Vet_State
	*/

	public Vet (String idNumber, String name, String lastName,String vetId,Vet_State state){
		super(idNumber,name,lastName);
		this.vetId=vetId;
		this.state=state;
	}

	public String getVetId(){
		return vetId;
	}

	public int getAmountConsults(){
		return amountConsults;
	}

	public Vet_State getVetState(){
		return state;
	}

	public void setAmountConsults(int amountConsults){
		this.amountConsults=amountConsults;
	}
	public void setVetState(Vet_State state){
		this.state=state;
	}
		
}
