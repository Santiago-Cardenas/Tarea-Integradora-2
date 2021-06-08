package ui;
import java.util.Scanner;
import model.PetCenter;

public class Main{

	/**
	* Description: Reads values that the user enters<br>
	*/

	public Scanner sc;	

	//relationships

	/**
	* Description: Relation with the PetCenter class // This creates a "bridge" between the packages, ui and model<br>
	*/

	private PetCenter petCenter;

	/**
	* Description: Construction method of the Main class, it allows initiating the scanner on a not static method<br>
	*/

	public Main (){

		sc = new Scanner(System.in);
		petCenter= new PetCenter();
	}

	/**
	* Description: Method that calls the openUP method<br>
	* @param args String array <br>
	*/

	public static void main (String [] args){
		Main m= new Main();
		m.openUp();
	} 

	// Menu methods

	/**
	* Description: Method that prints out a menu with selectable options, these options may or may not call other methods aswell<br>
	*/

	public void openUp(){

		int menu=0;

		System.out.println("	Where do you want to enter?\n"+
						   "1) Emergencies center\n" +
						   "2) Daycare\n" +
						   "0) Exit \n");

		menu=sc.nextInt();
		sc.nextLine();
	
		switch (menu){

			case 1:
				showMenuCenter();
			break;

			case 2:
				showMenuCare();
			break;

			default:
				System.out.println("GoodBye");
			break;
		}
	}

	/**
	* Description: Method that prints out a menu with selectable options, these options may or may not call other methods aswell<br>
	*/

	public void showMenuCare(){
		
		int menu=0;
			do {
				System.out.println("		DayCare Menu\n"+
								   "1) Add a pet to a habitat\n"+
								   "2) Hospitalize a pet\n"+
								   "3) Show information about a pet\n" +
								   "4) Show a map of all the habitats\n" +
								   "5) Show information about a habitat\n"+
								   "6) Show Daycare statistics\n"+
								   "7) Exit the Daycare\n");
			
				menu=sc.nextInt();
				sc.nextLine();
			
				switch (menu){

					case 1:
						addPetToHabitat();
						petCenter.setExit(false);
					break;

					case 2:
						addSickPetToHabitat();
						petCenter.setExit(false);
					break;

					case 3:
						showPetInfo();
						petCenter.setExit(false);
					break;

					case 4:
						System.out.println(petCenter.showHabitatMap());
						petCenter.setExit(false);
					break;

					case 5:
						showHabitatInfo();
						petCenter.setExit(false);
					break;

					case 6:
						System.out.println(petCenter.statistics());
						petCenter.setExit(false);
					break;

					case 7:
						openUp();
						petCenter.setExit(true);
					break;

					default:
						System.out.println("Please select a valid option\n");
						petCenter.setExit(false);
					break;
				}

			} while(petCenter.getExit()==false);
	}


	/**
	* Description: Method that prints out a menu with selectable options, these options may or may not call other methods aswell<br>
	*/

	public void showMenuCenter(){
		
		int menu=0;
			do {
				System.out.println("		Emergencies Center Menu\n"+
								   "1) Add a vet to the list\n"+
								   "2) Add a pet to the list\n"+
								   "3) Initiate a consult\n" +
								   "4) Finish a consult\n" +
								   "5) Number of pets waiting to be attendended\n" +
								   "6) Delete a vet\n"+
								   "7) Select this if a pet is leaving\n"+
								   "8) Exit the Emergencies Center\n");
			
				menu=sc.nextInt();
				sc.nextLine();
			
				switch (menu){

					case 1:
						addVet();
						petCenter.setExit(false);
					break;

					case 2:
						addPet();
						petCenter.setExit(false);
					break;

					case 3:
						startConsult();
						petCenter.setExit(false);
					break;

					case 4:
						endConsult();
						petCenter.setExit(false);
					break;

					case 5:
						System.out.println("There are " + petCenter.getWaitingPets() + " pet(s) left to be attendended\n");
						petCenter.setExit(false);
					break;

					case 6:
						deleteVet();
						petCenter.setExit(false);
					break;

					case 7:
						leavePet();
						petCenter.setExit(false);
					break;

					case 8:
						System.out.println(petCenter.closeShop());
						openUp();
						petCenter.setExit(true);
					break;

					default:
						System.out.println("Please select a valid option\n");
						petCenter.setExit(false);
					break;
				}

			} while(petCenter.getExit()==false);
	}

	// Pet Care methods

	/**
	* Description: This method allows the user to input the information required to create a new healthy pet and add it to a habitat <br>
	* <b> pre:</b> the variable menu needs have a value of 1<br>
	* <b> pos:</b> the requiered information to create a new pet and added to a habitat has been sent to the petCenter via the method <br>
	*/

	public void addPetToHabitat(){

		System.out.println("		Owners Info\n"+
						   "What is the first name of the owner?\n");
		String name= sc.nextLine();

		System.out.println("What is the last name of the owner?\n");
		String lastName= sc.nextLine();

		System.out.println("Please enter the personal ID of the owner\n");
		String idNumber= sc.nextLine();

		System.out.println("Please enter the owners cellphone number\n");
		String phone= sc.nextLine();

		System.out.println("Please enter the owners adress\n\n");
		String adress= sc.nextLine();

		System.out.println("		Pet Info\n"+
						   "What is the name of the pet?\n");
		String petName= sc.nextLine();

		System.out.println("How old is the pet?\n");
		String age= sc.nextLine();

		System.out.println("What type of specie is the pet?\n"+
						   "1) Cat\n"+
						   "2) Dog\n"+
						   "3) Bunny\n"+
						   "4) Reptile\n"+
						   "5) Bird\n");
		int specie= sc.nextInt();

		System.out.println("How many days is the pet going to stay in the Daycare?\n");
		int days= sc.nextInt();

		System.out.println(petCenter.addPetMain(specie,idNumber,name,lastName,phone,adress,age,petName,days));	
	}

	/**
	* Description: This method allows the user to input the information required to create a new sick pet and add it to a habitat <br>
	* <b> pre:</b> the variable menu needs have a value of 2<br>
	* <b> pos:</b> the requiered information to create a new pet and added to a habitat has been sent to the petCenter via the method <br>
	*/

	public void addSickPetToHabitat(){

		System.out.println("		Owners Info\n"+
						   "What is the first name of the owner?\n");
		String name= sc.nextLine();

		System.out.println("What is the last name of the owner?\n");
		String lastName= sc.nextLine();

		System.out.println("Please enter the personal ID of the owner\n");
		String idNumber= sc.nextLine();

		System.out.println("Please enter the owners cellphone number\n");
		String phone= sc.nextLine();

		System.out.println("Please enter the owners adress\n\n");
		String adress= sc.nextLine();

		System.out.println("		Pet Info\n"+
						   "What is the name of the pet?\n");
		String petName= sc.nextLine();

		System.out.println("How old is the pet?\n");
		String age= sc.nextLine();

		System.out.println("What type of specie is the pet?\n"+
						   "1) Cat\n"+
						   "2) Dog\n"+
						   "3) Bunny\n"+
						   "4) Reptile\n"+
						   "5) Bird\n");
		int specie= sc.nextInt();

		System.out.println("How many days is the pet going to stay in the Daycare?\n");
		int days= sc.nextInt();
		petCenter.setFromCenter(true);
		System.out.println(petCenter.addPetMain(specie,idNumber,name,lastName,phone,adress,age,petName,days));
		petCenter.setFromCenter(false);
	}

	/**
	* Description: This method allows the user to see some info about a pet <br>
	* <b> pre:</b> the variable menu needs have a value of 3<br>
	*/

	public void showPetInfo(){

		System.out.println("		Pet Info\n"+
							   "What is the name of the pet(s) you want to know its information about?\n");
			String petName= sc.nextLine();
			System.out.println(petCenter.showInfo(petName));
	}

	/**
	* Description: This method allows the user to see some info about a habitat <br>
	* <b> pre:</b> the variable menu needs have a value of 5<br>
	*/

	public void showHabitatInfo(){
		
		System.out.println("		Habitat Info\n"+
							   "What is the ID of the habitat you want to know its information about?\n" +
							   "Note:\n"+
							   "==============================\n"+
							   "CAT ID------> C + habitat # ==\n" +
							   "DOG ID------> D + habitat # ==\n" +
							   "BUNNY ID---> BU + habitat # ==\n" +
							   "REPTILE ID--> R + habitat # ==\n" +
							   "BIRD ID----> BI + habitat # ==\n"+
							   "==============================\n");
			String iD= sc.nextLine();

		System.out.println(petCenter.showHabitatInfo(iD));
	}

	// Pet Center methods

	/**
	* Description: This method allows the user to input the information required to create a new vet <br>
	* <b> pre:</b> the variable menu needs have a value of 1<br>
	* <b> pos:</b> the requiered information to create a new vet has been sent to the petCenter via the method <br>
	*/

	public void addVet(){

			if(petCenter.getVetCount()==7){
				System.out.println("Cannot register more vets");
			}

			else{
				
				System.out.println("		Vet Info\n"+
								   "What is the first name of the vet?\n");
				String name= sc.nextLine();

				System.out.println("What is the last name of the vet?\n");
				String lastName= sc.nextLine();

				System.out.println("Please enter the personal ID of this vet\n");
				String idNumber= sc.nextLine();

				System.out.println("Please enter the special vet ID of this vet\n");
				String vetId= sc.nextLine();

				System.out.println(petCenter.addVet(idNumber,name,lastName,vetId));
			}
	}

	/**
	* Description: This method allows the user to input the information required to create a new pet <br>
	* <b> pre:</b> the variable menu needs have a value of 2<br>
	* <b> pos:</b> the requiered information to create a new pet has been sent to the petCenter via the method <br>
	*/

	public void addPet(){
		String race="";

			if(petCenter.getPetCount()>=120){
				System.out.println("Cannot register more pets");
			}
			else{
				System.out.println("		Owners Info\n"+
								   "What is the first name of the owner?\n");
				String name= sc.nextLine();

				System.out.println("What is the last name of the owner?\n");
				String lastName= sc.nextLine();

				System.out.println("Please enter the personal ID of the owner\n");
				String idNumber= sc.nextLine();

				System.out.println("Please enter the owners cellphone number\n");
				String phone= sc.nextLine();

				System.out.println("Please enter the owners adress\n\n");
				String adress= sc.nextLine();

				System.out.println("		Pet Info\n"+
								   "What is the name of the pet?\n");
				String petName= sc.nextLine();

				System.out.println("How old is the pet?\n");
				String age= sc.nextLine();

				System.out.println("What type of specie is the pet?\n"+
								   "1) Cat\n"+
								   "2) Dog\n"+
								   "3) Bunny\n"+
								   "4) Reptile\n"+
								   "5) Bird\n");
				int specie= sc.nextInt();
				sc.nextLine();

				if(specie==1 || specie==2){
					System.out.println("What is the race of the pet?\n");
					race= sc.nextLine();
				}

				System.out.println("What priority is the pet going to possess?\n"+
								   "1) Priority 1\n"+
								   "2) Priority 2\n"+
								   "3) Priority 3\n"+
								   "4) Priority 4\n"+
								   "5) Priority 5\n");
				int priority= sc.nextInt();
				sc.nextLine();

				System.out.println("What kind of sympotoms is the pet having?\n");
				String symptom= sc.nextLine();
				if (specie==1 || specie==2){
				System.out.println(petCenter.addPetMain(specie,priority,idNumber,name,lastName,phone,adress,age,petName,symptom,race));
				}
				else{
				System.out.println(petCenter.addPetMain(specie,priority,idNumber,name,lastName,phone,adress,age,petName,symptom));
				}
			}		
	}

	/**
	* Description: This method allows the user to input the information required to start a consult between a vet and a pet<br>
	* <b> pre:</b> the variable menu needs have a value of 3<br>
	* <b> pos:</b> the requiered information to start the consult has been sent to the petCenter via the method <br>
	*/

	public void startConsult(){
		System.out.println("Please enter the personal ID of the vet that is going to initiate the consult\n");
		String idNumber= sc.nextLine();
		System.out.println(petCenter.startConsult(idNumber));
	}

	/**
	* Description: This method allows the user to input the information required to end a consult between a vet and a pet and posibly send the pet to a habitat<br>
	* <b> pre:</b> the variable menu needs have a value of 4<br>
	* <b> pos:</b> the requiered information to end the consult has been sent to the petCenter via the method and depending on the exit the pet got, it will either go to a habitat or no<br>
	*/

	public void endConsult(){

		int days=0;
		String msg="";

			System.out.println("		Vet Info\n"+
							   "What is the personal ID of the vet doing the consult?\n");
			String vetId= sc.nextLine();

			System.out.println("		Pet Info\n"+
							   "What is the name of the pet which consult has ended?\n");
			String petName= sc.nextLine();
			System.out.println("Does the pet need a hospital transfer?\n" + 
							   "1) Yes\n" +
							   "2) No\n");
			int exit= sc.nextInt();

			if(exit==2){
				System.out.println(petCenter.endConsult(vetId,petName,exit));
			}
			else{
				msg+=(petCenter.endConsult(vetId,petName,exit));

					if(msg.equals("Please enter a valid exit status\n")){
						System.out.println(msg);
					}
					else if(msg.equals("Theres no consult with this parameters\n")){
						System.out.println(msg);
					}
					else{
						System.out.println("How many days is the pet going to stay at the Daycare?\n");
						days= sc.nextInt();
						System.out.println(petCenter.addPetToHabitatFromCenter(days,petCenter.getPetForCare()));
					}
			}
	}

	/**
	* Description: This method allows the user to input the information required to delete a vet<br>
	* <b> pre:</b> the variable menu needs have a value of 6<br>
	* <b> pos:</b> the requiered information to delete a vet has been sent to the petCenter via the method <br>
	*/

	public void deleteVet(){
			System.out.println("Please enter the special vet ID of this vet\n");
			String vetId= sc.nextLine();
			System.out.println(petCenter.deleteVet(vetId));
	}

	/**
	* Description: This method allows the user to input the information required to change the status of a pet<br>
	* <b> pre:</b> the variable menu needs have a value of 7<br>
	* <b> pos:</b> the requiered information to make a pet leave has been sent to the petCenter via the method <br>
	*/

	public void leavePet(){

			System.out.println("		Owners Info\n"+
							   "Please enter the name of the owner\n");
			String ownerName= sc.nextLine();

			System.out.println("		Pet Info\n"+
							   "What is the name of the pet?\n");
			String petName= sc.nextLine();

			System.out.println(petCenter.leavePet(ownerName,petName));

	}

}