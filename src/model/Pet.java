package model;

public class Pet{

	private String age;
	private String petName;
	private String symptom;
	private String race;
	private Specie specie;
	private Priority priority;
	private Pet_State state;
	private Owner owner;
	private Vet consultVet;

	public Pet (String age,String petName,String symptom,Specie specie,Pet_State state,Priority priority,Owner owner){
		this.age=age;
		this.petName=petName;
		this.symptom=symptom;
		this.specie=specie;
		this.priority=priority;
		this.state=state;
		this.owner=owner;
	}

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

	public String getPetName(){
		return petName;
	}

	public Specie getSpecie(){
		return specie;
	}

	public Priority getPriority(){
		return priority;
	}

	public Owner getOwner(){
		return owner;
	}

	public Pet_State getState(){
		return state;
	}

	public Vet getConsultVet(){
		return consultVet;
	}

	public void setPetState(Pet_State state){
		this.state=state;
	}

	public void setConsultVet(Vet consultVet){
		this.consultVet=consultVet;
	}
	
		
}