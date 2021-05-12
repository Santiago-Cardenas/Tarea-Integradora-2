package model;

public class PetCenter{

	public final int MAXVET=7;
	public final int MAXPET=120;

	public int vetCount=0;
	public int petCount=0;
	
	private int waitingPets=0;
	private int exitPets=0;
	private int globalPets=0;

	private int pri1=0;
	private int pri2=0;
	private int pri3=0;
	private int pri4=0;
	private int pri5=0;

	//relationships
	private Vet [] vetArray;
	private Pet [] petArray;
	
	public PetCenter (){
		vetArray=new Vet [MAXVET];
		petArray=new Pet [MAXPET];
	}

	// Add methods

	public void addVet(String idNumber, String name, String lastName,String vetId,Vet_State state){
		boolean empty= false;
		for (int pos =0; pos<vetArray.length && !empty; pos++){

			if(vetArray[pos]!=null && vetArray[pos].getVetId().equalsIgnoreCase(vetId)){
				System.out.println("A vet with this same special ID has already been registered\n");
				empty=true;
			}	
			if(vetArray[pos]==null){
				Vet newVet = new Vet (idNumber,name,lastName,vetId,state);
				vetArray[pos]=newVet;
				System.out.println( vetArray[pos].getName() + " has been registered\n");
				vetArray[pos].setAmountConsults(0);
				vetCount++;
				empty=true;
			}	
		}
	}

	public void addPet(String age,String petName,String symptom,Specie specie,Pet_State state,Priority priority,Owner owner){
		boolean empty= false;
		for (int pos =0; pos<petArray.length && !empty; pos++){

			if(petArray[pos]!=null && petArray[pos].getPetName().equalsIgnoreCase(petName) && petArray[pos].getOwner().getName().equalsIgnoreCase(owner.getName())){
				System.out.println("The combination " + petName + " , " + owner.getName() + " already exists\n");
				empty=true;
			}

			if( petArray[pos]==null ){
				Pet newPet = new Pet (age,petName,symptom,specie,state,priority,owner);
				petArray[pos]=newPet;
				System.out.println( petName + " has been registered\n");
				petCount++;
				globalPets++;
				waitingPets++;
				empty=true;
			}
		}
	}	

	public void addPet(String age,String petName,String symptom,String race,Specie specie,Pet_State state,Priority priority,Owner owner){
		boolean empty= false;
		for (int pos=0; pos<petArray.length && !empty; pos++){

			if(petArray[pos]!=null && petArray[pos].getPetName().equalsIgnoreCase(petName) && petArray[pos].getOwner().getName().equalsIgnoreCase(owner.getName())){
				System.out.println("The combination " + petName + " , " + owner.getName() + " already exists\n");
				empty=true;
			}

			if(petArray[pos]==null){
				Pet newPet = new Pet (age,petName,symptom,race,specie,state,priority,owner);
				petArray[pos]=newPet;
				System.out.println( petName + " has been registered\n");
				petCount++;
				globalPets++;
				waitingPets++;
				empty=true;
			}	
		}
	}

	// Delete methods

	public void deleteVet (String vetId){

		boolean find=false;
		for(int i=0; i < vetArray.length && !find; i++){
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && petCount==0){
				System.out.println( vetArray[i].getName() + " has been deleted\n");
				vetArray[i]=null;
				vetCount--;
				find=true;
			}
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && petCount>0){
				System.out.println( "Cannot delete the vet because theres still pets registered\n");
				find=true;
			}
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && vetArray[i].getVetState().equals(Vet_State.ON_CONSULT)){
				System.out.println( vetArray[i].getName() + " is currently on a consult\n");
				find=true;
			}

		}

		if(find==false){
			System.out.println("Theres no vet with this special vet ID\n");
		}
	}

	public void deletePet (String ownerName,String petName){

		boolean find=false;
		for(int i=0; i < petArray.length && !find; i++){
			if(petArray[i]!=null && petArray[i].getOwner().getName().equalsIgnoreCase(ownerName) && petArray[i].getPetName().equalsIgnoreCase(petName) && petArray[i].getState()==Pet_State.WAITING){
				petArray[i]=null;
				System.out.println( petName + " has been deleted\n");
				exitPets++;
				petCount--;
				find=true;
			}
			if(petArray[i]!=null && petArray[i].getOwner().getName().equalsIgnoreCase(ownerName) && petArray[i].getPetName().equalsIgnoreCase(petName) && petArray[i].getState()==Pet_State.ON_CONSULT){
				System.out.println( petName + " is currently on a consult and cannot be deleted\n");
				find=true;
			}
		}

		if(find==false){
			System.out.println("Theres no pet registered like this\n");
		}
	}

	// Create objects on Main methods

	public void addVetMain(String idNumber,String name,String lastName,String vetId){
		
		addVet(idNumber,name,lastName,vetId,Vet_State.FREE);
	}

	public void addPetMain(int specie, int priority,String idNumber,String name,String lastName,String phone,String adress,String age,String petName,String symptom,String race){
		Owner owner= new Owner (idNumber,name,lastName,phone,adress);

			switch(specie){

				case 1:
					switch(priority){
						case 1:
							addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_1,owner);
						break;
						case 2:
							addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_2,owner);
						break;
						case 3:
							addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_3,owner);
						break;
						case 4:
							addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_4,owner);
						break;
						case 5:
							addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_5,owner);
						break;
					}
				break;

				case 2:
					switch(priority){
						case 1:
							addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_1,owner);
						break;
						case 2:
							addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_2,owner);
						break;
						case 3:
							addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_3,owner);
						break;
						case 4:
							addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_4,owner);
						break;
						case 5:
							addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_5,owner);
						break;
					}
				break;
			}
	}

	public void addPetMain(int specie, int priority,String idNumber,String name,String lastName,String phone,String adress,String age,String petName,String symptom){		
			Owner owner= new Owner (idNumber,name,lastName,phone,adress);

				switch(specie){	
					case 3:
						switch(priority){
							case 1:
								addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_1,owner);
							break;
							case 2:
								addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_2,owner);
							break;
							case 3:
								addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_3,owner);
							break;
							case 4:
								addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_4,owner);
							break;
							case 5:
								addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_5,owner);
							break;
						}
					break;

					case 4:
						switch(priority){
							case 1:
								addPet(age,petName,symptom,Specie.REPITLE,Pet_State.WAITING,Priority.PRIORITY_1,owner);
							break;
							case 2:
								addPet(age,petName,symptom,Specie.REPITLE,Pet_State.WAITING,Priority.PRIORITY_2,owner);
							break;
							case 3:
								addPet(age,petName,symptom,Specie.REPITLE,Pet_State.WAITING,Priority.PRIORITY_3,owner);
							break;
							case 4:
								addPet(age,petName,symptom,Specie.REPITLE,Pet_State.WAITING,Priority.PRIORITY_4,owner);
							break;
							case 5:
								addPet(age,petName,symptom,Specie.REPITLE,Pet_State.WAITING,Priority.PRIORITY_5,owner);
							break;
						}
					break;

					case 5:
						switch(priority){
							case 1:
								addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_1,owner);
							break;
							case 2:
								addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_2,owner);
							break;
							case 3:
								addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_3,owner);
							break;
							case 4:
								addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_4,owner);
							break;
							case 5:
								addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_5,owner);
							break;
						}
					break;
				}
	}

	// Start Consult methods

	public int searchPet(){
		boolean highest=false;
		int petPos=-1;
		for(int pos=0; pos < petArray.length && !highest; pos++){
			if(petArray[pos]!=null && petArray[pos].getState().equals(Pet_State.WAITING) && petArray[pos].getPriority().equals(Priority.PRIORITY_1)){
				petPos=pos;
				highest=true;
			}
		}

		for(int pos=0; pos < petArray.length && !highest; pos++){
			if(petArray[pos]!=null && petArray[pos].getState().equals(Pet_State.WAITING) && petArray[pos].getPriority().equals(Priority.PRIORITY_2)){
				petPos=pos;
				highest=true;
			}
		}
		for(int pos=0; pos < petArray.length && !highest; pos++){
			if(petArray[pos]!=null && petArray[pos].getState().equals(Pet_State.WAITING) && petArray[pos].getPriority().equals(Priority.PRIORITY_3)){
				petPos=pos;
				highest=true;
			}
		}

		for(int pos=0; pos < petArray.length && !highest; pos++){
			if(petArray[pos]!=null && petArray[pos].getState().equals(Pet_State.WAITING) && petArray[pos].getPriority().equals(Priority.PRIORITY_4)){
				petPos=pos;
				highest=true;
			}
		}

		for(int pos=0; pos < petArray.length && !highest; pos++){
			if(petArray[pos]!=null && petArray[pos].getState().equals(Pet_State.WAITING) && petArray[pos].getPriority().equals(Priority.PRIORITY_5)){
				petPos=pos;
				highest=true;
			}
		}

		return petPos;
	}

	public int searchVet(){
		int vetPos=-1;
		boolean free=false;
		for(int pos=0; pos<vetArray.length && !free; pos++){
			if(vetArray[pos]!=null && vetArray[pos].getVetState().equals(Vet_State.FREE)){
				vetPos=pos;
				free=true;
			}
		}
		return vetPos;
	}

	public void startConsult(){
		int pet=searchPet();
		int vet=searchVet();
		int consultAmount=0;
		boolean full=false;

		if (vetCount==0 || petCount==0){

			System.out.println("There has to be at least one vet and pet registered to initiate a consult\n");
		}
			else{

				switch(vet){

					case -1:
						System.out.println("Theres no vets available\n");
					break;

					default:
						switch(pet){
							case -1:
								System.out.println("Theres no pets left for attending\n");
							break;

							default:
								consultAmount=vetArray[vet].getAmountConsults();

								System.out.println("The personal Id number of the veterinary that will attend " + petArray[pet].getPetName() + " is: " + vetArray[vet].getIdNumber() + "\n");								
								consultAmount++;
								vetArray[vet].setVetState(Vet_State.ON_CONSULT);
								petArray[pet].setPetState(Pet_State.ON_CONSULT);
								vetArray[vet].setAmountConsults(consultAmount);
								petArray[pet].setConsultVet(vetArray[vet]);
								amountPetsPriority(pet);
								waitingPets--;
							break;
						}
					break;

				}
		}
	}

	// End Consult methods

	public void endConsult(String vetId,String petName,int exit){

		boolean verify=false;

		for(int pos=0;pos<petArray.length && !verify ;pos++){

			for(int i=0;i<vetArray.length && !verify ;i++){

				if(petArray[pos]!=null && vetArray[i]!=null && petArray[pos].getPetName().equalsIgnoreCase(petName) && vetArray[i].getIdNumber().equalsIgnoreCase(vetId) &&  petArray[pos].getConsultVet()!=null && petArray[pos].getConsultVet().getIdNumber().equalsIgnoreCase(vetArray[i].getIdNumber()) && vetArray[i].getVetState().equals(Vet_State.ON_CONSULT) && petArray[pos].getState().equals(Pet_State.ON_CONSULT)){
					
					switch (exit){
						case 1:
							System.out.println("		The consult has ended\n" +
											   "Id of the veterinary that did the consult: " + vetArray[i].getIdNumber() + "\n" +
											   "Name of the pet that recieved the consult: " + petArray[pos].getPetName() + "\n" +
											   "Exit status: Needs attention on hospital\n");

							vetArray[i].setVetState(Vet_State.FREE);
							petArray[pos].setPetState(Pet_State.HOSPITAL_TRANSFER);
							verify=true;
						break;

						case 2:
							System.out.println("		The consult has ended\n" +
											   "Id of the veterinary that did the consult: " + vetArray[i].getIdNumber() + "\n" +
											   "Name of the pet that recieved the consult: " + petArray[pos].getPetName() + "\n" +
											   "Exit status: Authorized\n");

							vetArray[i].setVetState(Vet_State.FREE);
							petArray[pos].setPetState(Pet_State.AUTHORIZED_EXIT);
							verify=true;
						break;
					}
				}
			}
		}

		if(verify==false){
			System.out.println("Theres no consult with this parameters\n");
		}
	}

	// Closing shop methods

	public boolean searchForWaitingPets(){
		boolean left=false;
		for(int i=0; i<petArray.length && !left; i++){
			if(petArray[i]!=null && petArray[i].getState().equals(Pet_State.WAITING)){
				left=true;
			}
		}
		return left;
	}
	public boolean checkArrays(){
		boolean clear=false;
		for(int i=0; i<petArray.length && !clear; i++){
			if(petArray[i]!=null && petArray[i].getState().equals(Pet_State.ON_CONSULT)){
				clear=true;
			}
		}

		return clear;
	}


	public double percentagePet(){
		double percentage=0;
		percentage=((exitPets * 100)/globalPets);
		return percentage;
	}
	public String vetName(){
		int highest=-1;
		String vetName="";
		for(int i=0; i<vetArray.length; i++){
			if(vetArray[i]!=null && vetArray[i].getAmountConsults()>highest){
				vetName=vetArray[i].getName();
				vetName+= " ";
				vetName+=vetArray[i].getLastName();
			}
		}
		return vetName;
	}


	public void amountPetsPriority(int pos){

		if(petArray[pos].getPriority().equals(Priority.PRIORITY_1)){
			pri1++;
		}

		if(petArray[pos].getPriority().equals(Priority.PRIORITY_2)){
			pri2++;
		}

		if(petArray[pos].getPriority().equals(Priority.PRIORITY_3)){
			pri3++;
		}

		if(petArray[pos].getPriority().equals(Priority.PRIORITY_4)){
			pri4++;
		}

		if(petArray[pos].getPriority().equals(Priority.PRIORITY_5)){
			pri5++;
		}
	}
	public void clearArrays(){
		for(int i=0; i<petArray.length; i++){
			petArray[i]=null;
		}
	}
	public void closeShop(){

		if(globalPets==0){
			System.out.println("The shop has closed\n");
		}
			else if(searchForWaitingPets()==true){
				System.out.println("Theres still pets left to be attended\n");
			}
				else if(checkArrays()==true){
					System.out.println("Theres still pets being attended\n");
				}
					else{
						System.out.println("		Vet Info\n" +
										   "The vet with the highest amount of consults is: " + vetName() + "\n");

						System.out.println("		Pet Info\n"+
								   "The amount of pets attended by priority:\n" +
								   "Priority 1: " + pri1 + "\n" + 
								   "Priority 2: " + pri2 + "\n" + 
								   "Priority 3: " + pri3 + "\n" + 
								   "Priority 4: " + pri4 + "\n" + 
								   "Priority 5: " + pri5 + "\n\n" + 
								   "The amount of pets that left without being attended is : " + percentagePet() + "%\n\n");
						System.out.println("The shop has closed\n");
						clearArrays();
					}
	}

	// gets and sets

	public int getVetCount(){
		return vetCount;
	}

	public int getPetCount(){
		return petCount;
	}

	public int getWaitingPets(){
		return waitingPets;
	}
}
