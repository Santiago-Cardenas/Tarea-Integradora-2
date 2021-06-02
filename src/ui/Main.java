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
	* Description: Method that prints out a menu with selectable options, these options may or may not  call other methods aswell<br>
	*/

	public void openUp(){

		private int menu=0;

		do {
				System.out.println("		Menu\n"+
								   "1) Open up\n" +
								   "0) Exit \n");

				menu=sc.nextInt();
				sc.nextLine();
			
				switch (menu){

					case 1:
						petCenter= new PetCenter();
						showmenu();
					break;

					default:
						System.out.println("\n");
						petCenter= new PetCenter();
						petCenter.setExit(true);
					break;
				}

			} while(petCenter.getExit()==false);
	}

	/**
	* Description: Method that prints out a menu with selectable options, these options may or may not  call other methods aswell<br>
	*/

	public void showmenu(){
		
		private int menu=0;
			do {
				System.out.println("		Menu\n"+
								   "1) Add a vet to the list\n"+
								   "2) Add a pet to the list\n"+
								   "3) Initiate a consult\n" +
								   "4) Finish a consult\n" +
								   "5) Number of pets waiting to be attendended\n" +
								   "6) Delete a vet\n"+
								   "7) Select this if a pet is leaving\n"+
								   "8) Close shop\n");
			
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
					break;

					default:
						System.out.println("Please select a valid option\n");
						petCenter.setExit(false);
					break;
				}

			} while(petCenter.getExit()==false);
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
								   "1) Dog\n"+
								   "2) Cat\n"+
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
	* Description: This method allows the user to input the information required to end a consult between a vet and a pet<br>
	* <b> pre:</b> the variable menu needs have a value of 4<br>
	* <b> pos:</b> the requiered information to end the consult has been sent to the petCenter via the method <br>
	*/

	public void endConsult(){
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
			System.out.println(petCenter.endConsult(vetId,petName,exit));
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
	* <b> pos:</b> the requiered information to delete a pet has been sent to the petCenter via the method <br>
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