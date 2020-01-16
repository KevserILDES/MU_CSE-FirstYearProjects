
public class Pig extends Mammal{
	private static int count=0;
	//Create a pig object
	public Pig(String name,int age){
		//Invoke its super class' constructor and some of its methods
		super(name,age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(12);
		super.setPregnancyPerYear(2);
		count++;
	}
	public void sayGreeting(){
		System.out.println("All animals are equal, but some animals are more equal than others!");
	}
	public static int getCount(){
		return count;
	}
	public static void decrementCount(){
		count--;
	}
	

}
