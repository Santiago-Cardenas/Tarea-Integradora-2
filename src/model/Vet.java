package model;

public class Vet extends Person{
	
	private String vetId;
	private Vet_State state;
	private int amountConsults;

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
