import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AnimalFarm {
	private ArrayList<Animal> animalList=new ArrayList<>();
	private ArrayList<String> animalNames=new ArrayList<>();
	private final int CAPACITY;
	private static int numberOfAnimals=0;
	//Cretae an animal farm object
	public AnimalFarm(int capacity){
		this.CAPACITY=capacity;
	}
	public int getNumberOfAnimals(){
		return numberOfAnimals;
	}
	//This method adds an animal to the animal farm only if there is enough space and there is no such animal with the same name;if there is it throws an IllegalNameException
	public boolean addAnimal(Animal animal) throws IllegalNameException{
		if(animalList.size()<CAPACITY && !(animalNames.contains(animal.getName()))){
			animalList.add(animal);
			animalNames.add(animal.getName());
			return true;
		}
		else if(animalNames.contains(animal.getName()))
			throw new IllegalNameException("You cannot enter an animal with the same name!");
		if(animalList.size()>=CAPACITY)
			System.out.println("The animal farm is full!");
		return false;	
	}
	//This method removes an animal with the given name from animal farm and decrement the count field of its kind
	public boolean removeAnimal(String name){
		for(int i=0;i<animalNames.size();i++){
			if(name.equalsIgnoreCase(animalNames.get(i))){
				if(animalList.get(i) instanceof Chicken)
					Chicken.decrementCount();
				else if(animalList.get(i) instanceof Donkey)
					Donkey.decrementCount();
				else if(animalList.get(i) instanceof Horse)
					Horse.decrementCount();
				else if(animalList.get(i) instanceof Pig)
					Pig.decrementCount();
				else if(animalList.get(i) instanceof Raven)
					Raven.decrementCount();
				else if(animalList.get(i) instanceof Sheep)
					Sheep.decrementCount();	
				animalList.remove(i);
				animalNames.remove(i);
			}
		}				
		return true;
	}
	//This method invokes printOneAnimalGreeting method for each animal in the farm
	public void printAllAnimalGreetings(){
		for(int i=0;i<animalList.size();i++)
			printOneAnimalGreeting(animalList.get(i));		
	}
	//This method invokes the given animal's sayGreeting method
	public void printOneAnimalGreeting(Animal animal){
		animal.sayGreeting();		
	}
	//This method invokes printOneAnimalName for each animal in the farm
	public void printAllAnimalNames(){
		for(int i=0;i<animalList.size();i++)
			printOneAnimalName(animalList.get(i));				
	}
	//This method prints the given animal's name 
	public void printOneAnimalName(Animal animal){
		System.out.println(animal.getName());		
	}
	//This method invokes all animals' toString methods and prints them on the screen
	public void printAllAnimals(){
		for(int i=0;i<animalList.size();i++)
			System.out.println(animalList.get(i).toString());		
	}
	//This method calculates the next year population forecast by multiplying each animal's number of off springs and pregnancy per year and adding the number of animals in the farm
	public int nextYearPopulationForecast(){
		int populationForecast=0;
		for(int i=0;i<animalList.size();i++)
			populationForecast+=animalList.get(i).getNumberOfOffSprings()*animalList.get(i).getPregnancyPerYear();
		return populationForecast+animalList.size();
	}
	//This method invokes the related movement method of bird and mammal classes
	public void animalMovements(){
		for(int i=0;i<animalList.size();i++){
			if(animalList.get(i) instanceof Bird)
				((Bird)animalList.get(i)).fly();
			if(animalList.get(i) instanceof Mammal)
				((Mammal)animalList.get(i)).walk();
		}
	}
	//This method invokes the related eating habit method of bird and mammal classes
	public void eatingHabits(){
		for(int i=0;i<animalList.size();i++){
			if(animalList.get(i) instanceof Bird)
				((Bird)animalList.get(i)).omnivore();	
			if(animalList.get(i) instanceof Mammal)
				((Mammal)animalList.get(i)).herbivore();
		}
	}
	//This method sorts the animals in the farm according to their names and prints the sorted name list 
	public void sortAlphabetically(){
		ArrayList<String> names=new ArrayList<>();
		for(int i=0;i<animalNames.size();i++)
			names.add(animalNames.get(i));
		Collections.sort(names);
		for(int i=0;i<names.size();i++)
			System.out.println("My name is "+names.get(i));	
	}
	//This method sorts the animals according to their leg number and prints the sorted list
	public void sortBasedOnLegNumber(){
		int[] legNum=new int[animalList.size()];
		for(int i=0;i<animalList.size();i++){
			legNum[i]=animalList.get(i).getLegNumber();									
		}
		Arrays.sort(legNum);
		for(int i=0;i<animalList.size();i++){
			if(animalList.get(i).getLegNumber()==legNum[i])
				System.out.println(animalList.get(i).getName()+" has "+animalList.get(i).getLegNumber()+" legs!");				
		}	  
	}
	//This method sorts the animals based on their age and prints the sorted list
	public void sortBasedOnAge(){
		int[] age=new int[animalList.size()];
		for(int i=0;i<animalList.size();i++){
			age[i]=animalList.get(i).getAge();									
		}
		Arrays.sort(age);
		for(int i=0;i<age.length;i++){
			for(int j=0;j<age.length && j!=i;j++)
				if(age[i]==age[j])
					age[i]=0;	
		}
		for(int i=0;i<animalList.size();i++){
			for(int j=0;j<animalList.size() && age[i]!=0;j++)
				if(animalList.get(j).getAge()==age[i])
					System.out.println(animalList.get(j).getName()+" is "+animalList.get(j).getAge()+" years old!");				
		}
	}
	//This method search an animal with the given name and prints its toString method
	public void searchBasedOnName(String name){
		for(int i=0;i<animalNames.size();i++){
			if(name.equalsIgnoreCase(animalNames.get(i)))
				System.out.println(animalList.get(i));			
		}				
	}
	//This method search an animal based on the given age and prints its toString method
	public void searchBasedOnAge(int age){
		for(int i=0;i<animalList.size();i++){
			if(age==animalList.get(i).getAge())
				System.out.println(animalList.get(i));			
		}			
	}
	//This method prints the information about animal farm in specific format to the file with the given name
	public void printReport(String filename) {
		try (PrintWriter pW = new PrintWriter(new File(filename));){
			ArrayList<Chicken> chicken=new ArrayList<>();
			ArrayList<Donkey> donkey=new ArrayList<>();
			ArrayList<Horse> horse=new ArrayList<>();
			ArrayList<Pig> pig=new ArrayList<>();
			ArrayList<Raven> raven=new ArrayList<>();
			ArrayList<Sheep> sheep=new ArrayList<>();		
			pW.println("We have a total of "+animalList.size()+" animals in the farm.");
			pW.println();
			for(int i=0;i<animalList.size();i++){
				if(animalList.get(i) instanceof Chicken)
					chicken.add((Chicken)(animalList.get(i)));
				else if(animalList.get(i) instanceof Donkey)
					donkey.add((Donkey)(animalList.get(i)));
				else if(animalList.get(i) instanceof Horse)
					horse.add((Horse)(animalList.get(i)));
				else if(animalList.get(i) instanceof Pig)
					pig.add((Pig)(animalList.get(i)));
				else if(animalList.get(i) instanceof Raven)
					raven.add((Raven)(animalList.get(i)));
				else if(animalList.get(i) instanceof Sheep)
					sheep.add((Sheep)(animalList.get(i)));
			}
			if(chicken.size()!=0){
				pW.println("\t*"+chicken.size()+" of them are Chicken. Those are: \n\t");
				pW.println("\t\tName\t\tAge\t\tLeg Number");
				for(int i=0;i<chicken.size();i++)
					pW.println("\t\t"+chicken.get(i).getName()+"\t\t"+chicken.get(i).getAge()+"\t\t"+chicken.get(i).getLegNumber());							
			}
			if(donkey.size()!=0){
				pW.println("\t*"+donkey.size()+" of them are Donkey. Those are: \n\t");
				pW.println("\t\tName\t\tAge\t\tLeg Number");
				for(int j=0;j<donkey.size();j++)
					pW.println("\t\t"+donkey.get(j).getName()+"\t\t"+donkey.get(j).getAge()+"\t\t"+donkey.get(j).getLegNumber());							
			}
			if(horse.size()!=0){
				pW.println("\t*"+horse.size()+" of them are Horse. Those are: \n\t");
				pW.println("\t\tName\t\tAge\t\tLeg Number");
				for(int j=0;j<horse.size();j++)
					pW.println("\t\t"+horse.get(j).getName()+"\t\t"+horse.get(j).getAge()+"\t\t"+horse.get(j).getLegNumber());							
			}
			if(pig.size()!=0){
				pW.println("\t*"+pig.size()+" of them are Pig. Those are: \n\t");
				pW.println("\t\tName\t\tAge\t\tLeg Number");
				for(int j=0;j<pig.size();j++)
					pW.println("\t\t"+pig.get(j).getName()+"\t\t"+pig.get(j).getAge()+"\t\t"+pig.get(j).getLegNumber());							
			}
			if(raven.size()!=0){
				pW.println("\t*"+raven.size()+" of them are Raven. Those are: \n\t");
				pW.println("\t\tName\t\tAge\t\tLeg Number");
				for(int j=0;j<raven.size();j++)
					pW.println("\t\t"+raven.get(j).getName()+"\t\t"+raven.get(j).getAge()+"\t\t"+raven.get(j).getLegNumber());							
			}
			if(sheep.size()!=0){
				pW.println("\t*"+sheep.size()+" of them are Sheep. Those are: \n\t");
				pW.println("\t\tName\t\tAge\t\tLeg Number");
				for(int j=0;j<sheep.size();j++)
					pW.println("\t\t"+sheep.get(j).getName()+"\t\t"+sheep.get(j).getAge()+"\t\t"+sheep.get(j).getLegNumber());							
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}

