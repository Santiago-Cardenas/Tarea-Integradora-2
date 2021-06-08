package model;

public class Pet{

	/**
	* Description: variable that stores the amount of time a pet is going to stay in the daycare<br>
	*/
 
	private int days;

	/**
	* Description: variable that stores the age of a pet<br>
	*/
 
	private String age;

	/**
	* Description: variable that stores the name of a pet<br>
	*/
 
	private String petName;

	/**
	* Description: variable that stores the symptoms of a pet<br>
	*/
 
	private String symptom;

	/**
	* Description: variable that stores the race of a pet<br>
	*/
 
	private String race;

	/**
	* Description: Relation with the Specie class // This is a variable that stores the Specie of a pet<br>
	*/
 
	private Specie specie;

	/**
	* Description: Relation with the Priority class // This is a variable that stores the Priority of a pet<br>
	*/
 
	private Priority priority;

	/**
	* Description: Relation with the Pet_State class // This is a variable that stores the state of a pet<br>
	*/
 
	private Pet_State state;

	/**
	* Description: Relation with the Owner class // This is a variable that stores the Owner of a pet<br>
	*/
 
	private Owner owner;

	/**
	* Description: Relation with the Vet class // This is a variable that stores the Vet that attends a certain pet<br>
	*/
 
	private Vet consultVet;

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param age String
	* @param petName String 
	* @param symptom String 
	* @param specie Specie 
	* @param state Pet_State 
	* @param priority Priority
	* @param owner Owner 
	*/

	public Pet (String age,String petName,String symptom,Specie specie,Pet_State state,Priority priority,Owner owner){
		this.age=age;
		this.petName=petName;
		this.symptom=symptom;
		this.specie=specie;
		this.priority=priority;
		this.state=state;
		this.owner=owner;
	}

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param age String
	* @param petName String 
	* @param symptom String
	* @param race String
	* @param specie Specie 
	* @param state Pet_State 
	* @param priority Priority
	* @param owner Owner 
	*/	

	public Pet (String age,String petName,String symptom,String race,Specie specie,Pet_State state,Priority priority,Owner owner){
		this.age=age;
		this.petName=petName;
		this.symptom=symptom;
		this.race=race;
		this.specie=specie;
		this.priority=priority;
		this.state=state;
		this.owner=owner;
	}

	/**
	* Description: Construction method of the Pet class<br>
	* <b> pos:</b> The atributes will be initialize with a value<br>
	* @param age String
	* @param petName String 
	* @param specie Specie
	* @param days int
	* @param owner Owner 
	*/	

	public Pet (String age,String petName,Specie specie,int days,Owner owner){
		this.age=age;
		this.petName=petName;
		this.specie=specie;
		this.days=days;
		this.owner=owner;
	}

	public String getPetName(){
		return petName;
	}

	public Specie getPetSpecie(){
		return specie;
	} 

	public String getAge(){
		return age;
	}

	public Priority getPriority(){
		return priority;
	}

	public Owner getOwner(){
		return owner;
	}

	public int getDays(){
		return days;
	}

	public Pet_State getState(){
		return state;
	}

	public Vet getConsultVet(){
		return consultVet;
	}

	public void setDays(int days){
		this.days=days;
	}
	public void setPetState(Pet_State state){
		this.state=state;
	}

	public void setConsultVet(Vet consultVet){
		this.consultVet=consultVet;
	}
	
		
}