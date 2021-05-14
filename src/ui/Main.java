package ui;
import java.util.Scanner;
import model.PetCenter;

public class Main{

	public Scanner sc;
	private int menu=0;
	private String race;

	//relationships
	private PetCenter petCenter;

	public Main (){

		sc = new Scanner(System.in);	
	}
	
	public static void main (String [] args){
		Main m= new Main();
		m.openUp();
	} 

	// Menu methods

	public void openUp(){

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
					break;
				}

			} while(menu!=0);
	}

	public void showmenu(){
			
			do {
				System.out.println("		Menu\n"+
								   "1) Add a vet to the list\n"+
								   "2) Add a pet to the list\n"+
								   "3) Initiate a consult\n" +
								   "4) Finish a consult\n" +
								   "5) Number of pets waiting to be attendended\n" +
								   "6) Delete a vet\n"+
								   "7) Delete a pet\n"+
								   "8) Close shop\n");
			
				menu=sc.nextInt();
				sc.nextLine();
			
				switch (menu){

					case 1:
						addVet();
					break;

					case 2:
						addPet();
					break;

					case 3:
						petCenter.startConsult();
					break;

					case 4:
						endConsult();
					break;

					case 5:
						System.out.println("There are " + petCenter.getWaitingPets() + " pet(s) left to be attendended\n");
					break;

					case 6:
						deleteVet();
					break;

					case 7:
						deletePet();
					break;

					case 8:
						petCenter.closeShop();
						if(petCenter.getExit()==true){
							menu=0;
						}
					break;

					default:
						System.out.println("Please select a valid option\n");
					break;
				}

			} while(menu!=0);
	}

	// Pet Center methods

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

				petCenter.addVet(idNumber,name,lastName,vetId);
			}
	}

	public void addPet(){

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
				petCenter.addPetMain(specie,priority,idNumber,name,lastName,phone,adress,age,petName,symptom,race);
				}
				else{
				petCenter.addPetMain(specie,priority,idNumber,name,lastName,phone,adress,age,petName,symptom);
				}
			}		
	}

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
			petCenter.endConsult(vetId,petName,exit);
	}

	public void deleteVet(){
			System.out.println("Please enter the special vet ID of this vet\n");
			String vetId= sc.nextLine();
			petCenter.deleteVet(vetId);
	}

	public void deletePet(){

			System.out.println("		Owners Info\n"+
							   "Please enter the name of the owner\n");
			String ownerName= sc.nextLine();

			System.out.println("		Pet Info\n"+
							   "What is the name of the pet?\n");
			String petName= sc.nextLine();

			petCenter.deletePet(ownerName,petName);
	}

}