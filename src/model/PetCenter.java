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

	// CAT CONSTANTS

	/**
	* Description: Global Constant that helps to define the size of the Cat Habitat
	*/

	private final int MAXCATCOL = 2;

	/**
	* Description: Global Constant that helps to define the size of the Cat Habitat
	*/

    private final int MINCATCOL= 0;

    /**
	* Description: Global Constant that helps to define the size of the Cat Habitat
	*/

    private final int MAXCATROW = 2;

    /**
	* Description: Global Constant that helps to define the size of the Cat Habitat
	*/

    private final int MINCATROW= 0;

    // DOG CONSTANTS

    /**
	* Description: Global Constant that helps to define the size of the Dog Habitat
	*/

    private final int MAXDOGCOL = 2;

    /**
	* Description: Global Constant that helps to define the size of the Dog Habitat
	*/

    private final int MINDOGCOL= 0;

    /**
	* Description: Global Constant that helps to define the size of the Dog Habitat
	*/

    private final int MAXDOGROW = 5;

    /**
	* Description: Global Constant that helps to define the size of the Dog Habitat
	*/

    private final int MINDOGROW= 3;

    // BUNNY CONSTANTS

    /**
	* Description: Global Constant that helps to define the size of the Bunny Habitat
	*/

    private final int MAXBUNNYCOL = 4;

    /**
	* Description: Global Constant that helps to define the size of the Bunny Habitat
	*/

    private final int MINBUNNYCOL= 3;

    /**
	* Description: Global Constant that helps to define the size of the Bunny Habitat
	*/

    private final int MAXBUNNYROW =3;

    /**
	* Description: Global Constant that helps to define the size of the Bunny Habitat
	*/

    private final int MINBUNNYROW= 2;

    // REPTILE CONSTANTS

    /**
	* Description: Global Constant that helps to define the size of the Reptile Habitat
	*/

    private final int MAXREPTILECOL = 4;

    /**
	* Description: Global Constant that helps to define the size of the Reptile Habitat
	*/

    private final int MINREPTILECOL= 3;

    /**
	* Description: Global Constant that helps to define the size of the Reptile Habitat
	*/

    private final int MAXREPTILEROW =1;

    /**
	* Description: Global Constant that helps to define the size of the Reptile Habitat
	*/

    private final int MINREPTILEROW= 0;

    // BIRDS CONSTANTS

    /**
	* Description: Global Constant that helps to define the size of the Bird Habitat
	*/

    private final int MAXBIRDCOL = 4;

    /**
	* Description: Global Constant that helps to define the size of the Bird Habitat
	*/

    private final int MINBIRDCOL= 3;

    /**
	* Description: Global Constant that helps to define the size of the Bird Habitat
	*/

    private final int MAXBIRDROW =5;

    /**
	* Description: Global Constant that helps to define the size of the Bird Habitat
	*/

    private final int MINBIRDROW= 4;


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

	private boolean exit=true;
	
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

	/**
	* Description: Helps to know if a pet is from the Center or not<br>
	*/
	private boolean fromCenter=false;

	/**
	* Description: Helps to know the position of a pet thats going to be transfered from the center to the Day Care<br>
	*/
	private int petForCare=0;




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
	* Description: Relation with the Habitat class<br>
	*/

	private Habitat [][] habitat;
	
	/**
	* Description:Construction method of the PetCenter class, it allows initiating the arrays vet Array,petArray with a size of MAXVET and MAXPET respectively it also initialize the matrix habitat with a value of [6][5] and fills every espace on it calling the createHabitats method<br>
	*/

	public PetCenter (){
		vetArray=new Vet [MAXVET];
		petArray=new Pet [MAXPET];
		habitat=new Habitat [6][5];
		createHabitats();
	}

	//Habitat methods

	// Create habitats

	/**
	* Description: Method that is fills every espace on the habitat matrix with an habitat<br>
	* <b> pre:</b> The habitat matrix must be initialized<br>
	* <b> pos:</b> The habitat matrix now has a habitat in every position<br>
	*/

	public void createHabitats(){
		
		int catCount=1;
		int dogCount=1;
		int bunnyCount=1;
		int reptileCount=1;
		int birdCount=1;

		for(int i=MINCATROW; i<=MAXCATROW; i++ ){

			for(int j=MINCATCOL; j<=MAXCATCOL; j++ ){

				habitat[i][j]= new Cat("C"+catCount,10,10,Habitat_State.EMPTY,10,60);
				catCount++;
			}
		}

		for(int i=MINDOGROW; i<=MAXDOGROW; i++ ){

			for(int j=MINDOGCOL; j<=MAXDOGCOL; j++ ){

				habitat[i][j]= new Dog("D"+dogCount,10,10,Habitat_State.EMPTY,5);
				dogCount++;
			}
		}

		for(int i=MINBUNNYROW; i<=MAXBUNNYROW; i++ ){

			for(int j=MINBUNNYCOL; j<=MAXBUNNYCOL; j++ ){

				habitat[i][j]= new Bunny("BU"+bunnyCount,10,10,Habitat_State.EMPTY,"Herbs",20);
				bunnyCount++;
			}
		}

		for(int i=MINREPTILEROW; i<=MAXREPTILEROW; i++ ){

			for(int j=MINREPTILECOL; j<=MAXREPTILECOL; j++ ){

				habitat[i][j]= new Reptile("R"+ reptileCount,10,10,Habitat_State.EMPTY,Aquarium_Type.AMPHIBIANS,"Glass");
				reptileCount++;
			}
		}

		for(int i=MINBIRDROW; i<=MAXBIRDROW; i++ ){

			for(int j=MINBIRDCOL; j<=MAXBIRDCOL; j++ ){

				habitat[i][j]= new Bird("BI" + birdCount,10,10,Habitat_State.EMPTY,5,1,Cage.HANGING);
				birdCount++;
			}
		}
	}

	// Add methods

	/**
	* Description: Method that is called on the Main, This method calls the addPetToHabitat method and says if the pet was or not stored on the habitat<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position<br>
	* @param specie int
	* @param idNumber String
	* @param name String
	* @param lastName String
	* @param phone String
	* @param adress String
	* @param age String
	* @param petName String 
	* @param days int
	* <b> pos:</b> A pet has been stored on a habitat if theres room for it<br>
	* @return msg String, contains a confirmation message
	*/

	public String addPetMain(int specie,String idNumber,String name,String lastName,String phone,String adress,String age,String petName,int days){		
		String msg="";
		String iD="";	
		Owner owner= new Owner (idNumber,name,lastName,phone,adress);

		switch(specie){
				case 1:
					Pet cat = new Pet(age,petName,Specie.CAT,days,owner);
					iD+=addPetToHabitat(specie,cat);
					if(iD.equals("Theres no room left\n")){
						msg+=iD;
					}
					else{
						msg+=(petName + " has been added to the habitat with the id: " + iD);
					}
				break;
				case 2:
					Pet dog = new Pet(age,petName,Specie.DOG,days,owner);
					iD+=addPetToHabitat(specie,dog);
					if(iD.equals("Theres no room left\n")){
						msg+=iD;
					}
					else{
						msg+=(petName + " has been added to the habitat with the id: " + iD);
					}
				break;
				case 3:
					Pet bunny = new Pet(age,petName,Specie.BUNNY,days,owner);
					iD+=addPetToHabitat(specie,bunny);
					if(iD.equals("Theres no room left\n")){
						msg+=iD;
					}
					else{
						msg+=(petName + " has been added to the habitat with the id: " + iD);
					}
				break;
				case 4:
					Pet reptile = new Pet(age,petName,Specie.REPTILE,days,owner);
					iD+=addPetToHabitat(specie,reptile);
					if(iD.equals("Theres no room left\n")){
						msg+=iD;
					}
					else{
						msg+=(petName + " has been added to the habitat with the id: " + iD);
					}
				break;
				case 5:
					Pet bird = new Pet(age,petName,Specie.BIRD,days,owner);
					iD+=addPetToHabitat(specie,bird);
					if(iD.equals("Theres no room left\n")){
						msg+=iD;
					}
					else{
						msg+=(petName + " has been added to the habitat with the id: " + iD);
					}	
				break;

				default:
					msg+=("Enter valid information");
				break;
			}

		return msg;
	}

	/**
	* Description: Method that sets a pet to a habitat if theres room for it on the habitats<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position<br>
	* @param specie int
	* @param pet Pet
	* <b> pos:</b> A pet has been stored on a habitat if theres room for it<br>
	* @return iD String, contains a confirmation message or an id of a habitat 
	*/

	public String addPetToHabitat(int specie,Pet pet){

		boolean empty=false;
		String iD="";
		switch(specie){

			case 1:
				for(int i=MINCATROW; i<=MAXCATROW && !empty; i++ ){

					for(int j=MINCATCOL; j<=MAXCATCOL && !empty; j++ ){

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==false){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_HEALTHY);
							iD=habitat[i][j].getIdNumber();
							empty=true;
						}

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==true){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_SICK);
							iD=habitat[i][j].getIdNumber();
							fromCenter=false;
							empty=true;
						}
					}
				}
			break;
			case 2:
				for(int i=MINDOGROW; i<=MAXDOGROW && !empty; i++ ){

					for(int j=MINDOGCOL; j<=MAXDOGCOL && !empty; j++ ){

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==false){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_HEALTHY);
							iD=habitat[i][j].getIdNumber();
							empty=true;
						}

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==true){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_SICK);
							iD=habitat[i][j].getIdNumber();
							fromCenter=false;
							empty=true;
						}
					}
				}
			break;

			case 3:
				for(int i=MINBUNNYROW; i<=MAXBUNNYROW && !empty; i++ ){

					for(int j=MINBUNNYCOL; j<=MAXBUNNYCOL && !empty; j++ ){

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==false){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_HEALTHY);
							iD=habitat[i][j].getIdNumber();
							empty=true;
						}

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==true){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_SICK);
							iD=habitat[i][j].getIdNumber();
							fromCenter=false;
							empty=true;
						}
					}
				}
			break;

			case 4:
				for(int i=MINREPTILEROW; i<=MAXREPTILEROW && !empty; i++ ){

					for(int j=MINREPTILECOL; j<=MAXREPTILECOL && !empty; j++ ){

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==false){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_HEALTHY);
							iD=habitat[i][j].getIdNumber();
							empty=true;
						}

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==true){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_SICK);
							iD=habitat[i][j].getIdNumber();
							fromCenter=false;
							empty=true;
						}
					}
				}
			break;

			case 5:

				for(int i=MINBIRDROW; i<=MAXBIRDROW && !empty; i++ ){

					for(int j=MINBIRDCOL; j<=MAXBIRDCOL && !empty; j++ ){

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==false){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_HEALTHY);
							iD=habitat[i][j].getIdNumber();
							empty=true;
						}

						if(habitat[i][j].getState().equals(Habitat_State.EMPTY) && fromCenter==true){
							habitat[i][j].setPet(pet);
							habitat[i][j].setState(Habitat_State.OCCUPIED_SICK);
							iD=habitat[i][j].getIdNumber();
							fromCenter=false;
							empty=true;
						}
					}
				}

			break;

		}

		if(iD.equals("")){
			iD="Theres no room left\n";
		}

		return iD;
	}

	//transfer methods

	/**
	* Description: Method that calls the addPetMain method<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position and the petArray must have been initialized<br>
	* @param days int 
	* @param petForCare int
	* <b> pos:</b> A pet has been stored on a habitat if theres room for it<br>
	* @return msg String, contains a confirmation message  
	*/

	public String addPetToHabitatFromCenter(int days,int petForCare){
		String msg="";

			Pet pet= petArray[petForCare];
			pet.setDays(days);
			fromCenter=true;

			if(pet.getPetSpecie().equals(Specie.CAT)){
				msg+= addPetMain(1,pet.getOwner().getIdNumber(),pet.getOwner().getName(),pet.getOwner().getLastName(),pet.getOwner().getPhone(),pet.getOwner().getAdress(),pet.getAge(),pet.getPetName(),pet.getDays());				
			}
			if(pet.getPetSpecie().equals(Specie.DOG)){
				msg+= addPetMain(2,pet.getOwner().getIdNumber(),pet.getOwner().getName(),pet.getOwner().getLastName(),pet.getOwner().getPhone(),pet.getOwner().getAdress(),pet.getAge(),pet.getPetName(),pet.getDays());
			}
			if(pet.getPetSpecie().equals(Specie.BUNNY)){
				msg+= addPetMain(3,pet.getOwner().getIdNumber(),pet.getOwner().getName(),pet.getOwner().getLastName(),pet.getOwner().getPhone(),pet.getOwner().getAdress(),pet.getAge(),pet.getPetName(),pet.getDays());
			}
			if(pet.getPetSpecie().equals(Specie.REPTILE)){
				msg+= addPetMain(4,pet.getOwner().getIdNumber(),pet.getOwner().getName(),pet.getOwner().getLastName(),pet.getOwner().getPhone(),pet.getOwner().getAdress(),pet.getAge(),pet.getPetName(),pet.getDays());
			}
			if(pet.getPetSpecie().equals(Specie.BIRD)){
				msg+= addPetMain(5,pet.getOwner().getIdNumber(),pet.getOwner().getName(),pet.getOwner().getLastName(),pet.getOwner().getPhone(),pet.getOwner().getAdress(),pet.getAge(),pet.getPetName(),pet.getDays());
			}

		return msg;
	}

	//info methods

	/**
	* Description: Method that shows info on a pet<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position<br>
	* @param petName String
	* @return msg String, contains a info about a pet
	*/

	public String showInfo(String petName){
		String msg="";

		for(int i=MINCATROW; i<=MAXCATROW; i++ ){

			for(int j=MINCATCOL; j<=MAXCATCOL; j++ ){

				if(habitat[i][j].getPet()!=null && habitat[i][j].getPet().getPetName().equalsIgnoreCase(petName)){
					
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
					msg+="			Pet information\n"+
						 "Zone: Cat Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Healthy\n\n";
					}
					else{
						msg+="			Pet information\n"+
						 "Zone: Cat Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Sick\n\n";
					}
				}
			}
		}

		for(int i=MINDOGROW; i<=MAXDOGROW; i++ ){

			for(int j=MINDOGCOL; j<=MAXDOGCOL; j++ ){

				if(habitat[i][j].getPet()!=null && habitat[i][j].getPet().getPetName().equalsIgnoreCase(petName)){

					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
					msg+="			Pet information\n"+
						 "Zone: Dog Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Healthy\n\n";
					}
					else{
						msg+="			Pet information\n"+
						 "Zone: Dog Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Sick\n\n";
					}
				}
			}
		}

		for(int i=MINBUNNYROW; i<=MAXBUNNYROW; i++ ){

			for(int j=MINBUNNYCOL; j<=MAXBUNNYCOL; j++ ){

				if(habitat[i][j].getPet()!=null && habitat[i][j].getPet().getPetName().equalsIgnoreCase(petName)){
					
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
					msg+="			Pet information\n"+
						 "Zone: Bunny Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Healthy\n\n";
					}
					else{
						msg+="			Pet information\n"+
						 "Zone: Bunny Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Sick\n\n";
					}
				}
			}
		}

		for(int i=MINREPTILEROW; i<=MAXREPTILEROW; i++ ){

			for(int j=MINREPTILECOL; j<=MAXREPTILECOL; j++ ){

				if(habitat[i][j].getPet()!=null && habitat[i][j].getPet().getPetName().equalsIgnoreCase(petName)){
					
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
					msg+="			Pet information\n"+
						 "Zone: Reptile Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Healthy\n\n";
					}
					else{
						msg+="			Pet information\n"+
						 "Zone: Reptile Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Sick\n\n";
					}
				}
			}
		}

		for(int i=MINBIRDROW; i<=MAXBIRDROW; i++ ){

			for(int j=MINBIRDCOL; j<=MAXBIRDCOL; j++ ){

				if(habitat[i][j].getPet()!=null && habitat[i][j].getPet().getPetName().equalsIgnoreCase(petName)){
					
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
					msg+="			Pet information\n"+
						 "Zone: Bird Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Healthy\n\n";
					}
					else{
						msg+="			Pet information\n"+
						 "Zone: Bird Habitats\n" +
						 "Habitat ID: " + habitat[i][j].getIdNumber() + "\n" +
						 "Pet State: Sick\n\n";
					}
				}
			}
		}

		if(msg.equals("")){
			msg+="Theres no pet with this name on any habitat\n";
		}
		return msg;
	}

	/**
	* Description: Method that shows the id of every habitat plus a S,H or E depending on its state<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position<br>
	* @return msg String, contains all the ids of every habitat plus a S,H or E depending on its state
	*/

	public String showHabitatMap(){
		String msg="	Habitats Map\n";

		for(int i=0; i<=5; i++ ){

			for(int j=0; j<=4; j++ ){

				if(habitat[i][j].getState().equals(Habitat_State.EMPTY)){

					if(j==4){
					msg+= " " + habitat[i][j].getIdNumber() +"E";
					}
					else{
						msg+= " " + habitat[i][j].getIdNumber() + "E -";
					}
				}

				if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){

					if(j==4){
					msg+= " " + habitat[i][j].getIdNumber() +"H";
					}
					else{
						msg+= " " + habitat[i][j].getIdNumber() + "H -";
					}
				}

				if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_SICK)){

					if(j==4){
					msg+= " " + habitat[i][j].getIdNumber() +"S";
					}
					else{
						msg+= " " + habitat[i][j].getIdNumber() + "S -";
					}
				}

			}

			msg+="\n";
		}

		return msg;
	}

	/**
	* Description: Method that shows info on a habitat<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position<br>
	* @param idNumber String
	* @return msg String, contains a info about a habitat
	*/

	public String showHabitatInfo(String idNumber){

		String msg="";

		for(int i=0; i<=5; i++){

			for(int j=0; j<=4; j++){

				if(habitat[i][j].getIdNumber().equalsIgnoreCase(idNumber) && habitat[i][j].getPet()!=null){

					if(habitat[i][j].getPet().getPetSpecie().equals(Specie.CAT)){
						msg+="		Habitat information\n"+
							 "Zone: Cat Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Height: 10m\n" +
							 "Weight: 60kg\n\n" +
							 "		Pet of this habitat information\n"+
						 	 "Name: " + habitat[i][j].getPet().getPetName() + "\n" +
						 	 "Age: " + habitat[i][j].getPet().getAge() + "\n" +
						 	 "Specie: " + habitat[i][j].getPet().getPetSpecie() + "\n" +
						 	 "Days of stay: " + habitat[i][j].getPet().getDays() + "\n\n" +
						 	 "		Owner of Pet information\n"+
						 	 "Name: " + habitat[i][j].getPet().getOwner().getName() + "\n" +
						 	 "Last name: " + habitat[i][j].getPet().getOwner().getLastName() + "\n" +
						 	 "Adress: " + habitat[i][j].getPet().getOwner().getAdress() + "\n" +
						 	 "Phone: " + habitat[i][j].getPet().getOwner().getPhone() + "\n" +
						 	 "ID number: " + habitat[i][j].getPet().getOwner().getIdNumber() + "\n";
					}

					if(habitat[i][j].getPet().getPetSpecie().equals(Specie.DOG)){
						msg+="		Habitat information\n"+
							 "Zone: Dog Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Toys amount: 5\n\n" +
							 "		Pet of this habitat information\n"+
						 	 "Name: " + habitat[i][j].getPet().getPetName() + "\n" +
						 	 "Age: " + habitat[i][j].getPet().getAge() + "\n" +
						 	 "Specie: " + habitat[i][j].getPet().getPetSpecie() + "\n" +
						 	 "Days of stay: " + habitat[i][j].getPet().getDays() + "\n\n" +
						 	 "		Owner of Pet information\n"+
						 	 "Name: " + habitat[i][j].getPet().getOwner().getName() + "\n" +
						 	 "Last name: " + habitat[i][j].getPet().getOwner().getLastName() + "\n" +
						 	 "Adress: " + habitat[i][j].getPet().getOwner().getAdress() + "\n" +
						 	 "Phone: " + habitat[i][j].getPet().getOwner().getPhone() + "\n" +
						 	 "ID number: " + habitat[i][j].getPet().getOwner().getIdNumber() + "\n";
					}

					if(habitat[i][j].getPet().getPetSpecie().equals(Specie.BUNNY)){
						msg+="		Habitat information\n"+
							 "Zone: Bunny Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Plant type: Herbs\n" +
							 "Plant quantity: 20\n\n" +
							 "		Pet of this habitat information\n"+
						 	 "Name: " + habitat[i][j].getPet().getPetName() + "\n" +
						 	 "Age: " + habitat[i][j].getPet().getAge() + "\n" +
						 	 "Specie: " + habitat[i][j].getPet().getPetSpecie() + "\n" +
						 	 "Days of stay: " + habitat[i][j].getPet().getDays() + "\n\n" +
						 	 "		Owner of Pet information\n"+
						 	 "Name: " + habitat[i][j].getPet().getOwner().getName() + "\n" +
						 	 "Last name: " + habitat[i][j].getPet().getOwner().getLastName() + "\n" +
						 	 "Adress: " + habitat[i][j].getPet().getOwner().getAdress() + "\n" +
						 	 "Phone: " + habitat[i][j].getPet().getOwner().getPhone() + "\n" +
						 	 "ID number: " + habitat[i][j].getPet().getOwner().getIdNumber() + "\n";
					}

					if(habitat[i][j].getPet().getPetSpecie().equals(Specie.REPTILE)){
						msg+="		Habitat information\n"+
							 "Zone: Reptile Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Aquarium type: Amphibians\n" +
							 "Aquarium material: Glass\n\n" +
							 "		Pet of this habitat information\n"+
						 	 "Name: " + habitat[i][j].getPet().getPetName() + "\n" +
						 	 "Age: " + habitat[i][j].getPet().getAge() + "\n" +
						 	 "Specie: " + habitat[i][j].getPet().getPetSpecie() + "\n" +
						 	 "Days of stay: " + habitat[i][j].getPet().getDays() + "\n\n" +
						 	 "		Owner of Pet information\n"+
						 	 "Name: " + habitat[i][j].getPet().getOwner().getName() + "\n" +
						 	 "Last name: " + habitat[i][j].getPet().getOwner().getLastName() + "\n" +
						 	 "Adress: " + habitat[i][j].getPet().getOwner().getAdress() + "\n" +
						 	 "Phone: " + habitat[i][j].getPet().getOwner().getPhone() + "\n" +
						 	 "ID number: " + habitat[i][j].getPet().getOwner().getIdNumber() + "\n";
					}

					if(habitat[i][j].getPet().getPetSpecie().equals(Specie.BIRD)){
						msg+="		Habitat information\n"+
							 "Zone: Bird Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Height: 5m\n" +
							 "Amount of birds capable of storing: 1\n" +
							 "Cage type: Hanging\n\n" +
							 "		Pet of this habitat information\n"+
						 	 "Name: " + habitat[i][j].getPet().getPetName() + "\n" +
						 	 "Age: " + habitat[i][j].getPet().getAge() + "\n" +
						 	 "Specie: " + habitat[i][j].getPet().getPetSpecie() + "\n" +
						 	 "Days of stay: " + habitat[i][j].getPet().getDays() + "\n\n" +
						 	 "		Owner of Pet information\n"+
						 	 "Name: " + habitat[i][j].getPet().getOwner().getName() + "\n" +
						 	 "Last name: " + habitat[i][j].getPet().getOwner().getLastName() + "\n" +
						 	 "Adress: " + habitat[i][j].getPet().getOwner().getAdress() + "\n" +
						 	 "Phone: " + habitat[i][j].getPet().getOwner().getPhone() + "\n" +
						 	 "ID number: " + habitat[i][j].getPet().getOwner().getIdNumber() + "\n";
					}
				}

			}
		}

		for(int i=MINCATROW; i<=MAXCATROW; i++ ){

			for(int j=MINCATCOL; j<=MAXCATCOL; j++ ){

				if(habitat[i][j].getIdNumber().equalsIgnoreCase(idNumber) && habitat[i][j].getPet()==null){
					msg+="			Habitat information\n"+
							 "Zone: Cat Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Height: 10m\n" +
							 "Weight: 60kg\n" +
							 "==========THE HABITAT IS EMPTY==========\n";
				}
			}
		}

		for(int i=MINDOGROW; i<=MAXDOGROW; i++ ){

			for(int j=MINDOGCOL; j<=MAXDOGCOL; j++ ){

				if(habitat[i][j].getIdNumber().equalsIgnoreCase(idNumber) && habitat[i][j].getPet()==null){
					msg+="		Habitat information\n"+
							 "Zone: Dog Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Toys amount: 5\n" +
							 "==========THE HABITAT IS EMPTY==========\n";
				}
			}
		}

		for(int i=MINBUNNYROW; i<=MAXBUNNYROW; i++ ){

			for(int j=MINBUNNYCOL; j<=MAXBUNNYCOL; j++ ){

				if(habitat[i][j].getIdNumber().equalsIgnoreCase(idNumber) && habitat[i][j].getPet()==null){
					msg+="		Habitat information\n"+
							 "Zone: Bunny Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Plant type: Herbs\n" +
							 "Plant quantity: 20\n" +
							 "==========THE HABITAT IS EMPTY==========\n";
				}
			}
		}

		for(int i=MINREPTILEROW; i<=MAXREPTILEROW; i++ ){

			for(int j=MINREPTILECOL; j<=MAXREPTILECOL; j++ ){

				if(habitat[i][j].getIdNumber().equalsIgnoreCase(idNumber) && habitat[i][j].getPet()==null){
					msg+="		Habitat information\n"+
							 "Zone: Reptile Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Aquarium type: Amphibians\n" +
							 "Aquarium material: Glass\n" +
							 "==========THE HABITAT IS EMPTY==========\n";
				}
			}
		}

		for(int i=MINBIRDROW; i<=MAXBIRDROW; i++ ){

			for(int j=MINBIRDCOL; j<=MAXBIRDCOL; j++ ){

				if(habitat[i][j].getIdNumber().equalsIgnoreCase(idNumber) && habitat[i][j].getPet()==null){
					msg+="		Habitat information\n"+
							 "Zone: Bird Habitats\n" +
							 "ID: " + habitat[i][j].getIdNumber() + "\n" +
							 "Length: 10m\n" +
							 "Width: 10m\n" +
							 "State: " + habitat[i][j].getState() + "\n" +
							 "Height: 5m\n" +
							 "Amount of birds capable of storing: 1\n" +
							 "Cage type: Hanging\n" +
							 "==========THE HABITAT IS EMPTY==========\n";
				}
			}
		}

		if(msg.equals("")){
			msg+="Theres no habitat with this ID\n";
		}
		return msg;
	}


	// statistics methods

	/**
	* Description: Method that shows some statistics of the habitats<br>
	* <b> pre:</b> The habitat matrix must have a habitat on every position<br>
	* @return msg String, contains statistics of the habitats
	*/

	public String statistics(){

		String msg="";
		double count=0;
		double catCount=0;
		double dogCount=0;
		double bunnyCount=0;
		double reptileCount=0;
		double birdCount=0;
		double healthy=0;
		double sick=0;
		double sumState=0;

		for(int i=MINCATROW; i<=MAXCATROW; i++ ){

			for(int j=MINCATCOL; j<=MAXCATCOL; j++ ){

				if(habitat[i][j].getPet()!=null){
					catCount++;
					count++;
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
						healthy++;
					}
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_SICK)){
						sick++;
					}
				}
			}
		}

		for(int i=MINDOGROW; i<=MAXDOGROW; i++ ){

			for(int j=MINDOGCOL; j<=MAXDOGCOL; j++ ){

				if(habitat[i][j].getPet()!=null){
					dogCount++;
					count++;
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
						healthy++;
					}
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_SICK)){
						sick++;
					}
				}
			}
		}

		for(int i=MINBUNNYROW; i<=MAXBUNNYROW; i++ ){

			for(int j=MINBUNNYCOL; j<=MAXBUNNYCOL; j++ ){

				if(habitat[i][j].getPet()!=null){
					bunnyCount++;
					count++;
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
						healthy++;
					}
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_SICK)){
						sick++;
					}
				}					
			}
		}

		for(int i=MINREPTILEROW; i<=MAXREPTILEROW; i++ ){

			for(int j=MINREPTILECOL; j<=MAXREPTILECOL; j++ ){

				if(habitat[i][j].getPet()!=null){
					reptileCount++;
					count++;
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
						healthy++;
					}
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_SICK)){
						sick++;
					}
				}
						
			}
		}

		for(int i=MINBIRDROW; i<=MAXBIRDROW; i++ ){

			for(int j=MINBIRDCOL; j<=MAXBIRDCOL; j++ ){

				if(habitat[i][j].getPet()!=null){
					birdCount++;
					count++;
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_HEALTHY)){
						healthy++;
					}
					if(habitat[i][j].getState().equals(Habitat_State.OCCUPIED_SICK)){
						sick++;
					}
				}

			}
		}

		count=(count*100)/30;
		sumState=healthy+sick;

		if(sumState>0){
			healthy=(healthy*100)/sumState;
			sick=(sick*100)/sumState;
		}

		catCount=(catCount*100)/9;
		dogCount=(dogCount*100)/9;
		bunnyCount=(bunnyCount*100)/4;
		reptileCount=(reptileCount*100)/4;
		birdCount=(birdCount*100)/4;

		msg+="		Habitats Statistics\n\n"+
			 "Cat habitat Ocuppation: " + catCount +"%\n"+
			 "Dog habitat Ocuppation: " + dogCount +"%\n"+
			 "Bunny habitat Ocuppation: " + bunnyCount +"%\n"+
			 "Reptile habitat Ocuppation: " + reptileCount +"%\n"+
			 "Bird habitat Ocuppation: " + birdCount +"%\n"+
			 "General Ocuppation: " + count +"%\n"+
			 "Healthy Pets: " + healthy +"%\n"+
			 "Sick Pets: " + sick +"%\n";

		return msg;
	}

	//Center methods

	// Add methods

	/**
	* Description: Method that creates and adds a vet object into an array named vetArray<br>
	* <b> pre:</b> The vetArray must have atleast one empty space<br>
	* <b> pos:</b> A position on the vetArray has been filled with a Vet object<br>
	* @param idNumber String 
	* @param name String 
	* @param lastName String 
	* @param vetId String
	* @return msg String, contains a confirmation message
	*/

	public String addVet(String idNumber, String name, String lastName,String vetId){
		String msg="";
		boolean empty= false;
		for (int pos =0; pos<vetArray.length && !empty; pos++){

			if(vetArray[pos]!=null && vetArray[pos].getVetId().equalsIgnoreCase(vetId)){
				msg+="A vet with this same special ID has already been registered\n";
				empty=true;
			}	
			if(vetArray[pos]==null){
				Vet newVet = new Vet (idNumber,name,lastName,vetId,Vet_State.FREE);
				vetArray[pos]=newVet;
				msg+=( vetArray[pos].getName() + " has been registered\n");
				vetArray[pos].setAmountConsults(0);
				vetCount++;
				empty=true;
			}	
		}
		return msg;
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
	* @return msg String, contains a confirmation message
	*/

	public String addPet(String age,String petName,String symptom,Specie specie,Pet_State state,Priority priority,Owner owner){
		String msg="";
		boolean empty= false;
		for (int pos =0; pos<petArray.length && !empty; pos++){

			if(petArray[pos]!=null && petArray[pos].getPetName().equalsIgnoreCase(petName) && petArray[pos].getOwner().getName().equalsIgnoreCase(owner.getName())){
				msg+=("The combination " + petName + " , " + owner.getName() + " already exists\n");
				empty=true;
			}

			if( petArray[pos]==null ){
				Pet newPet = new Pet (age,petName,symptom,specie,state,priority,owner);
				petArray[pos]=newPet;
				msg+=(petName + " has been registered\n");
				petCount++;
				globalPets++;
				waitingPets++;
				empty=true;
			}
		}
		return msg;
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
	* @return msg String, contains a confirmation message
	*/	

	public String addPet(String age,String petName,String symptom,String race,Specie specie,Pet_State state,Priority priority,Owner owner){
		String msg="";
		boolean empty= false;
		for (int pos=0; pos<petArray.length && !empty; pos++){

			if(petArray[pos]!=null && petArray[pos].getPetName().equalsIgnoreCase(petName) && petArray[pos].getOwner().getName().equalsIgnoreCase(owner.getName())){
				msg+=("The combination " + petName + " , " + owner.getName() + " already exists\n");
				empty=true;
			}

			if(petArray[pos]==null){
				Pet newPet = new Pet (age,petName,symptom,race,specie,state,priority,owner);
				petArray[pos]=newPet;
				msg+=(petName + " has been registered\n");
				petCount++;
				globalPets++;
				waitingPets++;
				empty=true;
			}	
		}
		return msg;
	}

	// Delete methods

	/**
	* Description: Method that deletes a vet object from the array named vetArray<br>
	* <b> pre:</b> The vetArray must have atleast one space occupied<br>
	* <b> pos:</b> An object from the vetArray has been deleted<br>
	* @param vetId String
	* @return msg String, contains a confirmation message
	*/

	public String deleteVet (String vetId){
		String msg="";
		boolean find=false;
		for(int i=0; i < vetArray.length && !find; i++){
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && petCount==0){
				msg+=( vetArray[i].getName() + " has been deleted\n");
				vetArray[i]=null;
				vetCount--;
				find=true;
			}
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && petCount>0 && vetArray[i].getVetState().equals(Vet_State.FREE)){
				msg+=( "Cannot delete the vet because theres still pets registered\n");
				find=true;
			}
			if(vetArray[i]!=null && vetArray[i].getVetId().equalsIgnoreCase(vetId) && vetArray[i].getVetState().equals(Vet_State.ON_CONSULT)){
				msg+=( vetArray[i].getName() + " is currently on a consult\n");
				find=true;
			}

		}

		if(find==false){
			msg+=("Theres no vet with this special vet ID\n");
		}
		return msg;
	}

	/**
	* Description: Method that changes the status of a pet object from the array named petArray<br>
	* <b> pre:</b> The petArray must have atleast one space occupied<br>
	* <b> pos:</b> An object from the petArray has changed its status<br>
	* @param ownerName String
	* @param petName String
	* @return msg String, contains a confirmation message
	*/

	public String leavePet (String ownerName,String petName){

		boolean find=false;
		String msg="";
		for(int i=0; i < petArray.length && !find; i++){
			if(petArray[i]!=null && petArray[i].getOwner().getName().equalsIgnoreCase(ownerName) && petArray[i].getPetName().equalsIgnoreCase(petName) && petArray[i].getState()==Pet_State.WAITING){
				petArray[i].setPetState(Pet_State.NO_ATTENTION_EXIT);
				msg+=( petName + " has left the center\n");
				exitPets++;
				petCount--;
				find=true;
			}
			if(petArray[i]!=null && petArray[i].getOwner().getName().equalsIgnoreCase(ownerName) && petArray[i].getPetName().equalsIgnoreCase(petName) && petArray[i].getState()==Pet_State.ON_CONSULT){
				msg+=( petName + " is currently on a consult and cannot leave the center\n");
				find=true;
			}
		}

		if(find==false){
			msg+=("Theres no pet registered like this // OR // this pet is not waiting or on consult\n");
		}
		return msg;
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
	* @return msg String, contains a confirmation message
	*/

	public String addPetMain(int specie, int priority,String idNumber,String name,String lastName,String phone,String adress,String age,String petName,String symptom,String race){
		String msg="";
		Owner owner= new Owner (idNumber,name,lastName,phone,adress);

			switch(specie){

				case 1:
					switch(priority){
						case 1:
							msg+=addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_1,owner);
						break;
						case 2:
							msg+=addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_2,owner);
						break;
						case 3:
							msg+=addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_3,owner);
						break;
						case 4:
							msg+=addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_4,owner);
						break;
						case 5:
							msg+=addPet(age,petName,symptom,race,Specie.CAT,Pet_State.WAITING,Priority.PRIORITY_5,owner);
						break;
						default:
            				msg+=("Enter valid information");
            			break;
					}
				break;

				case 2:
					switch(priority){
						case 1:
							msg+=addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_1,owner);
						break;
						case 2:
							msg+=addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_2,owner);
						break;
						case 3:
							msg+=addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_3,owner);
						break;
						case 4:
							msg+=addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_4,owner);
						break;
						case 5:
							msg+=addPet(age,petName,symptom,race,Specie.DOG,Pet_State.WAITING,Priority.PRIORITY_5,owner);
						break;
						default:
            				msg+=("Enter valid information");
            			break;
					}
				break;

				default:
					msg+=("Enter valid information");
				break;
			}

		return msg;
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
	* @return msg String, contains a confirmation message
	*/

	public String addPetMain(int specie, int priority,String idNumber,String name,String lastName,String phone,String adress,String age,String petName,String symptom){		
		String msg="";	
		Owner owner= new Owner (idNumber,name,lastName,phone,adress);

				switch(specie){	
					case 3:
						switch(priority){
							case 1:
								msg+=addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_1,owner);
							break;
							case 2:
								msg+=addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_2,owner);
							break;
							case 3:
								msg+=addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_3,owner);
							break;
							case 4:
								msg+=addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_4,owner);
							break;
							case 5:
								msg+=addPet(age,petName,symptom,Specie.BUNNY,Pet_State.WAITING,Priority.PRIORITY_5,owner);
							break;
							default:
            					msg+=("Enter valid information");
            				break;
						}
					break;

					case 4:
						switch(priority){
							case 1:
								msg+=addPet(age,petName,symptom,Specie.REPTILE,Pet_State.WAITING,Priority.PRIORITY_1,owner);
							break;
							case 2:
								msg+=addPet(age,petName,symptom,Specie.REPTILE,Pet_State.WAITING,Priority.PRIORITY_2,owner);
							break;
							case 3:
								msg+=addPet(age,petName,symptom,Specie.REPTILE,Pet_State.WAITING,Priority.PRIORITY_3,owner);
							break;
							case 4:
								msg+=addPet(age,petName,symptom,Specie.REPTILE,Pet_State.WAITING,Priority.PRIORITY_4,owner);
							break;
							case 5:
								msg+=addPet(age,petName,symptom,Specie.REPTILE,Pet_State.WAITING,Priority.PRIORITY_5,owner);
							break;
							default:
            					msg+=("Enter valid information");
            				break;
						}
					break;

					case 5:
						switch(priority){
							case 1:
								msg+=addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_1,owner);
							break;
							case 2:
								msg+=addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_2,owner);
							break;
							case 3:
								msg+=addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_3,owner);
							break;
							case 4:
								msg+=addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_4,owner);
							break;
							case 5:
								msg+=addPet(age,petName,symptom,Specie.BIRD,Pet_State.WAITING,Priority.PRIORITY_5,owner);
							break;
							default:
            					msg+=("Enter valid information");
            				break;
						}
					break;
					default:
    					msg+=("Enter valid information");
    				break;
				}
		return msg;
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
	* @return msg String, contains a confirmation message
	*/

	public String startConsult(String idNumber){
		String msg="";
		int pet=searchPet();
		int vet=searchVet(idNumber);
		int consultAmount=0;
		boolean full=false;

		if (vetCount==0 || petCount==0){

			msg+=("There has to be at least one vet and pet registered to initiate a consult\n");
		}
			else{

				switch(vet){

					case -1:
						msg+=("Theres no vets available // OR // This id does not match any of the ones registered\n");
					break;

					default:
						switch(pet){
							case -1:
								msg+=("Theres no pets left for attending\n");
							break;

							default:
								msg+=("The personal Id number of the veterinary that will attend " + petArray[pet].getPetName() + " is: " + vetArray[vet].getIdNumber() + "\n");								
								
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
		
		return msg;
	}

	// End Consult methods

	/**
	* Description: Method that ends a consult between a vet and a pet<br>
	* <b> pre:</b> The status of both a certain vet and pet have to be ON_CONSULT and the pet object needs to have a vetConsult and the vet object a amountConsults<br>
	* <b> pos:</b> The status of both a certain vet and pet has changed<br>
	* @param vetId String
	* @param petName String
	* @param exit int
	* @return msg String, contains a confirmation message
	*/

	public String endConsult(String vetId,String petName,int exit){
		String msg="";
		boolean verify=false;

		for(int pos=0;pos<petArray.length && !verify ;pos++){

			for(int i=0;i<vetArray.length && !verify ;i++){

				if(petArray[pos]!=null && vetArray[i]!=null && petArray[pos].getPetName().equalsIgnoreCase(petName) && vetArray[i].getIdNumber().equalsIgnoreCase(vetId) &&  petArray[pos].getConsultVet()!=null && petArray[pos].getConsultVet().getIdNumber().equalsIgnoreCase(vetArray[i].getIdNumber()) && vetArray[i].getVetState().equals(Vet_State.ON_CONSULT) && petArray[pos].getState().equals(Pet_State.ON_CONSULT)){
					
					switch (exit){
						case 1:
							msg+=("		The consult has ended\n" +
											   "Id of the veterinary that did the consult: " + vetArray[i].getIdNumber() + "\n" +
											   "Name of the pet that recieved the consult: " + petArray[pos].getPetName() + "\n" +
											   "Exit status: Needs attention on hospital\n");

							vetArray[i].setVetState(Vet_State.FREE);
							petArray[pos].setPetState(Pet_State.HOSPITAL_TRANSFER);
							petForCare=pos;
							verify=true;
						break;

						case 2:
							msg+=("		The consult has ended\n" +
											   "Id of the veterinary that did the consult: " + vetArray[i].getIdNumber() + "\n" +
											   "Name of the pet that recieved the consult: " + petArray[pos].getPetName() + "\n" +
											   "Exit status: Authorized\n\n\n");

							vetArray[i].setVetState(Vet_State.FREE);
							petArray[pos].setPetState(Pet_State.AUTHORIZED_EXIT);
							verify=true;
						break;

						default:
							msg+=("Please enter a valid exit status\n");
							verify=true;
						break;
					}
				}
			}
		}

		if(verify==false){
			msg+=("Theres no consult with this parameters\n");
		}
		return msg;
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
		if(globalPets!=0){
			percentage=((exitPets * 100)/globalPets);
		}
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
	* @return msg String, contains a confirmation message
	*/

	public String closeShop(){
		String msg="";
		if(globalPets==0){
			msg+=("\n");
		}
			else if(searchForWaitingPets()==true){
				msg+=("Theres still pets left to be attended\n");
				exit=false;
			}
				else if(checkArrays()==true){
					msg+=("Theres still pets being attended\n");
					exit=false;
				}
					else{
						msg+=("		Vet Info\n" +
										   "The vet with the highest amount of consults is: " + vetName() + "\n");

						msg+=("		Pet Info\n"+
								   "The amount of pets attended by priority:\n" +
								   "Priority 1: " + pri1 + "\n" + 
								   "Priority 2: " + pri2 + "\n" + 
								   "Priority 3: " + pri3 + "\n" + 
								   "Priority 4: " + pri4 + "\n" + 
								   "Priority 5: " + pri5 + "\n\n" + 
								   "The percentage of pets that left without being attended is : " + percentagePet() + "%\n\n");
						clearArrays();
						exit=true;
					}
		return msg;
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

	public int getPetForCare(){
		return petForCare;
	}

	public boolean getExit(){
		return exit;
	}

	public void setExit(boolean exit){
		this.exit=exit;
	}
}