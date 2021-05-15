package model;

public class PetCenter{

	/**
	* Description: Global Constant that defines the size of the vetArrat
	*/

	public final int MAXVET=7;

	/**
	* Description: Global Constant that defines the size of the petArrat
	*/

	public final int MAXPET=120;

	/**
	* Description: Helps tracking how many vets are registered currently <br>
	*/

	public int vetCount=0;

	/**
	* Description: Helps tracking how many pets are registered currently <br>
	*/

	public int petCount=0;

	/**
	* Description: Helps verify if the shop can close or not<br>
	*/

	public boolean exit=true;
	
	/**
	* Description: Helps tracking how many pets have a WAITING status <br>
	*/

	private int waitingPets=0;

	/**
	* Description: Helps tracking how many pets have a NO_ATTENTION_EXIT status<br>
	*/

	private int exitPets=0;

	/**
	* Description: Helps tracking how many pets have been registered in total<br>
	*/

	private int globalPets=0;

	/**
	* Description: Helps tracking how many pets have a PRIORITY_1 priority<br>
	*/

	private int pri1=0;

	/**
	* Description: Helps tracking how many pets have a PRIORITY_2 priority<br>
	*/

	private int pri2=0;

	/**
	* Description: Helps tracking how many pets have a PRIORITY_3 priority<br>
	*/

	private int pri3=0;

	/**
	* Description: Helps tracking how many pets have a PRIORITY_4 priority<br>
	*/

	private int pri4=0;

	/**
	* Description: Helps tracking how many pets have a PRIORITY_5 priority<br>
	*/
	private int pri5=0;

	//relationships

	/**
	* Description: Relation with the Vet class // This is a Vet array in which i can store vet objects<br>
	*/

	private Vet [] vetArray;

	/**
	* Description: Relation with the Pet class // This is a Pet array in which i can store pet objects<br>
	*/

	private Pet [] petArray;
	
	/**
	* Description:Construction method of the PetCenter class, it allows initiating the arrays vet Array,petArray with a size of MAXVET and MAXPET respectively<br>
	*/

	public PetCenter (){
		vetArray=new Vet [MAXVET];
		petArray=new Pet [MAXPET];
	}

	// Add methods

	/**
	* Description: Method that creates and adds a vet object into an array named vetArray<br>
	* <b> pre:</b> The vetArray must have atleast one empty space<br>
	* <b> pos:</b> A position on the vetArray has been filled with a Vet object<br>
	* @param idNumber String 
	* @param name String 
	* @param lastName String 
	* @param vetId String
	*/

	public void addVet(String idNumber, String name, String lastName,String vetId){
		boolean empty= false;
		for (int pos =0; pos<vetArray.length && !empty; pos++){

			if(vetArray[pos]!=null && vetArray[pos].getVetId().equalsIgnoreCase(vetId)){
				System.out.println("A vet with this same special ID has already been registered\n");
				empty=true;
			}	
			if(vetArray[pos]==null){
				Vet newVet = new Vet (idNumber,name,lastName,vetId,Vet_State.FREE);
				vetArray[pos]=newVet;
				System.out.println( vetArray[pos].getName() + " has been registered\n");
				vetArray[pos].setAmountConsults(0);
				vetCount++;
				empty=true;
			}	
		}
	}

	/**
	* Description: Method that creates and adds a pet object into an array named petArray<br>
	* <b> pre:</b> The petArray must have atleast one empty space<br>
	* <b> pos:</b> A position on the petArray has been filled with a Pet object<br>
	* @param age String
	* @param petName String 
	* @param symptom String 
	* @param specie Specie 
	* @param state Pet_State 
	* @param priority Priority
	* @param owner Owner 
	*/

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

	/**
	* Description: Method that creates and adds a pet object into an array named petArray<br>
	* <b> pre:</b> The petArray must have atleast one empty space<br>
	* <b> pos:</b> A position on the petArray has been filled with a Pet object<br>
	* @param age String
	* @param petName String 
	* @param symptom String
	* @param race String
	* @param specie Specie 
	* @param state Pet_State 
	* @param priority Priority
	* @param owner Owner 
	*/	

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

	/**
	* Description: Method that deletes a vet object from the array named vetArray<br>
	* <b> pre:</b> The vetArray must have atleast one space occupied<br>
	* <b> pos:</b> An object from the vetArray has been deleted<br>
	* @param vetId String
	*/

	public void deleteVet (String vetId){

		boolean find=false;
		for(int i=0; i < vetArray.length && !find; i++){
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && petCount==0){
				System.out.println( vetArray[i].getName() + " has been deleted\n");
				vetArray[i]=null;
				vetCount--;
				find=true;
			}
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && petCount>0 && vetArray[i].getVetState().equals(Vet_State.FREE)){
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

	/**
	* Description: Method that deletes a pet object from the array named petArray<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* <b> pos:</b> An object from the petArray has changed its status<br>
	* @param ownerName String
	* @param petName String
	*/

	public void deletePet (String ownerName,String petName){

		boolean find=false;
		for(int i=0; i < petArray.length && !find; i++){
			if(petArray[i]!=null && petArray[i].getOwner().getName().equalsIgnoreCase(ownerName) && petArray[i].getPetName().equalsIgnoreCase(petName) && petArray[i].getState()==Pet_State.WAITING){
				petArray[i].setPetState(Pet_State.NO_ATTENTION_EXIT);
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

	/**
	* Description: Method that is called on the Main, This method calls the addPet method<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* @param specie int
	* @param priority int
	* @param idNumber String
	* @param name String
	* @param lastName String
	* @param phone String
	* @param adress String
	* @param age String
	* @param petName String 
	* @param symptom String
	* @param race String
	*/

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
						default:
            				System.out.println("Enter valid information");
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
						default:
            				System.out.println("Enter valid information");
            			break;
					}
				break;

				default:
					System.out.println("Enter valid information");
				break;
			}
	}

	/**
	* Description: Method that is called on the Main, This method calls the addPet method<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* @param specie int
	* @param priority int
	* @param idNumber String
	* @param name String
	* @param lastName String
	* @param phone String
	* @param adress String
	* @param age String
	* @param petName String 
	* @param symptom String
	*/

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
							default:
            					System.out.println("Enter valid information");
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
							default:
            					System.out.println("Enter valid information");
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
							default:
            					System.out.println("Enter valid information");
            				break;
						}
					break;
					default:
    					System.out.println("Enter valid information");
    				break;
				}
	}

	// Start Consult methods

	/**
	* Description: Method that looks for the next pet object that is WAITING and has the highest priority on the petArray<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* @return petPos int, contains a position of the petAarray 
	*/

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

	/**
	* Description: Method that looks for the next vet object that is FREE on the vetArray based on the input of the user<br>
	* <b> pre:</b> The vetArray must have atleast one space occupied<br>
	* @param idNumber String
	* @return vetPos int, contains a position of the vetAarray 
	*/

	public int searchVet(String idNumber){
		int vetPos=-1;
		boolean free=false;
		for(int pos=0; pos<vetArray.length && !free; pos++){
			if(vetArray[pos]!=null && vetArray[pos].getIdNumber().equalsIgnoreCase(idNumber) && vetArray[pos].getVetState().equals(Vet_State.FREE)){
				vetPos=pos;
				free=true;
			}
		}
		return vetPos;
	}

	/**
	* Description: Method that starts a consult between a vet and a pet<br>
	* <b> pre:</b> There has to be atleast one object on the vetArray and petArray<br>
	* <b> pos:</b> The status of both a certain vet and pet has changed and the pet now contains a vetConsult and the vet a amountConsults<br>
	* @param idNumber String
	*/

	public void startConsult(String idNumber){
		int pet=searchPet();
		int vet=searchVet(idNumber);
		int consultAmount=0;
		boolean full=false;

		if (vetCount==0 || petCount==0){

			System.out.println("There has to be at least one vet and pet registered to initiate a consult\n");
		}
			else{

				switch(vet){

					case -1:
						System.out.println("Theres no vets available // OR // This id does not match any of the ones registered\n");
					break;

					default:
						switch(pet){
							case -1:
								System.out.println("Theres no pets left for attending\n");
							break;

							default:
								System.out.println("The personal Id number of the veterinary that will attend " + petArray[pet].getPetName() + " is: " + vetArray[vet].getIdNumber() + "\n");								
								
								vetArray[vet].setVetState(Vet_State.ON_CONSULT);
								petArray[pet].setPetState(Pet_State.ON_CONSULT);

								consultAmount=vetArray[vet].getAmountConsults();
								consultAmount++;
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

	/**
	* Description: Method that ends a consult between a vet and a pet<br>
	* <b> pre:</b> The status of both a certain vet and pet have to be ON_CONSULT and the pet object needs to have a vetConsult and the vet object a amountConsults<br>
	* <b> pos:</b> The status of both a certain vet and pet has changed<br>
	* @param vetId String
	* @param petName String
	* @param exit int
	*/

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

						default:
							System.out.println("Please enter a valid exit status");
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

	/**
	* Description: Method that searches for objects on the petArray that have a WAITING status<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* @return left boolean, Indicates whether or not there are pets with the WAITING status
	*/

	public boolean searchForWaitingPets(){
		boolean left=false;
		for(int i=0; i<petArray.length && !left; i++){
			if(petArray[i]!=null && petArray[i].getState().equals(Pet_State.WAITING)){
				left=true;
			}
		}
		return left;
	}

	/**
	* Description: Method that searches for objects on the petArray that have a ON_CONSULT status<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* @return clear boolean, Indicates whether or not there are pets with the ON_CONSULT status
	*/

	public boolean checkArrays(){
		boolean clear=false;
		for(int i=0; i<petArray.length && !clear; i++){
			if(petArray[i]!=null && petArray[i].getState().equals(Pet_State.ON_CONSULT)){
				clear=true;
			}
		}

		return clear;
	}

	/**
	* Description: Method that calculates the % of pets that have the NO_ATTENTION_EXIT status<br>
	* <b> pre:</b> The globalPets variable has to be higher than cero<br>
	* @return percentage double, Indicates the % of pets that have the NO_ATTENTION_EXIT status
	*/

	public double percentagePet(){
		double percentage=0;
		percentage=((exitPets * 100)/globalPets);
		return percentage;
	}

	/**
	* Description: Method that searches for vets the name of the vet with the highest amount of consults made<br>
	* <b> pre:</b> Atleast one object on the vetArray must have a relation with the amountConsult variable of the Vet class<br>
	* @return vetName String, Indicates the full name of the vet with the highest amount of consults made
	*/

	public String vetName(){
		int highest=-1;
		String vetName="";
		for(int i=0; i<vetArray.length; i++){
			if(vetArray[i]!=null && vetArray[i].getAmountConsults()>highest){
				vetName=vetArray[i].getName();
				vetName+= " ";
				vetName+=vetArray[i].getLastName();
				highest=vetArray[i].getAmountConsults();
			}
		}
		return vetName;
	}

	/**
	* Description: Method that adds a value of one to a certain variable pri1,pri2 ... pri5 based on the priority of the pet object<br>
	* <b> pre:</b> There has to be atleast one pet object on the petArray<br>
	* @param pos int
	*/

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

	/**
	* Description: Method that deletes every object on the petArray<br>
	* <b> pos:</b> The array petArray is now empty<br>
	*/

	public void clearArrays(){
		for(int i=0; i<petArray.length; i++){
			petArray[i]=null;
		}
	}

	/**
	* Description: Method that prints some information about the program and cleans the array petArray<br>
	* <b> pos:</b> The array petArray is now empty<br>
	*/

	public void closeShop(){

		if(globalPets==0){
			System.out.println("The shop has closed\n");
		}
			else if(searchForWaitingPets()==true){
				System.out.println("Theres still pets left to be attended\n");
				exit=false;
			}
				else if(checkArrays()==true){
					System.out.println("Theres still pets being attended\n");
					exit=false;
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
								   "The percentage of pets that left without being attended is : " + percentagePet() + "%\n\n");
						System.out.println("The shop has closed\n");
						clearArrays();
						exit=true;
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

	public boolean getExit(){
		return exit;
	}
}