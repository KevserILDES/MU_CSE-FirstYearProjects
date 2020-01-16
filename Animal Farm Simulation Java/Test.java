import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IllegalNameException, FileNotFoundException{
		// TODO Auto-generated method stub
		/*Kevser ÝLDEÞ
		 * 150116048
		 */
		Scanner input=new Scanner(System.in);
		System.out.print("Welcome to the AnimaL Farm simulation program!\nPlease enter the capacity of the animal farm: ");
		int capacity=input.nextInt();
		AnimalFarm animalFarm=new AnimalFarm(capacity);
		//Enter the infinite loop
		while(true){
			//Prints the menu
			System.out.print("0 - Exit the program\n1 - Add animal\n2 - Remove animal\n3 - Search animal\n4 - Sort animal\n5 - Calculate next year's population estimate\n6 - Print all animal's movements\n7 - Print all animal's eating habits\n8 - Print report\nPlease enter your choice: ");
			int choice=input.nextInt();		
			switch(choice){
			//If user enters 0 exit the program
			case 0:	System.exit(1);break;
			//If user enters 1 prints another menu for animal kinds and according to choice invokes animalFarm's addAnimal method
			case 1:	System.out.print("1 - Chicken\n2 - Donkey\n3 - Horse\n4 - Pig\n5 - Raven\n6 - Sheep\nSelect an animal type:");
			int type=input.nextInt();
			System.out.print("Enter the name:");
			String name=input.next();
			System.out.print("Enter the age:");
			int age=input.nextInt(); 
			switch(type){
			case 1: animalFarm.addAnimal(new Chicken(name,age)); break;
			case 2: animalFarm.addAnimal(new Donkey(name,age)); break;
			case 3: animalFarm.addAnimal(new Horse(name,age)); break;
			case 4: animalFarm.addAnimal(new Pig(name,age)); break;
			case 5: animalFarm.addAnimal(new Raven(name,age)); break;
			case 6: animalFarm.addAnimal(new Sheep(name,age)); break;
			}
			break;
			//If user enters 2 take the name of the animal and invokes animalFarm's removeAnimal method
			case 2:	System.out.print("Enter the name:");
			String rName=input.next();
			animalFarm.removeAnimal(rName);
			break;
			//If user enters 3 ask the user based on which property he/she wants to search and based on choice invokes related method
			case 3: System.out.print("1 - Search based on name\n2 - Search based on age");
			int search=input.nextInt(); 
			switch(search){
			case 1: System.out.print("Enter the name of the animal: ");
			String sName=input.next();
			animalFarm.searchBasedOnName(sName);
			break;
			case 2: System.out.print("Enter the age of the animal: ");
			int sAge=input.nextInt();
			animalFarm.searchBasedOnAge(sAge);
			break;
			}
			break;
			//If user enters 4 ask the user based on which property he/she wants to sort and based on choice invokes related method
			case 4:	System.out.print("1 - Sort based on name\n2 - Sort based on leg number\n 3 - Sort based on age\n4 - Sort based onaddition date");
			int sNumber=input.nextInt();
			switch(sNumber){
			case 1: animalFarm.sortAlphabetically(); break;
			case 2: animalFarm.sortBasedOnLegNumber(); break;
			case 3: animalFarm.sortBasedOnAge(); break;
			case 4: animalFarm.printAllAnimals(); break;
			}
			break;
			//If user enters 5 invokes the nextYearPopulationForecast method of animalFarm and prints the result
			case 5:	System.out.println(animalFarm.nextYearPopulationForecast()); break;
			//If user enters 6 invokes the animalMovements method of the animalFarm
			case 6:	animalFarm.animalMovements(); break;
			//If user enters 7 invokes the eatingHabits method of the animalFarm
			case 7:	animalFarm.eatingHabits(); break;
			//If user enters 8 take the name of the file and invokes printReport method of the animalFarm
			case 8:	System.out.print("Enter the filename: ");
			String file=input.next(); 
			animalFarm.printReport(file);break;	
			}
		}
	}	
}
