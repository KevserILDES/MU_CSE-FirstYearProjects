
public class Chicken extends Bird{
	private static int count;
	//Create a chicken object
	public Chicken(String name,int age){
		//Invoke its super class' constructor and some of its methods
		super(name,age);
		super.setLegNumber(2);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(200);
		count++;
	}
	public void sayGreeting(){
		System.out.println("I have nothing to say other than I am against Pigs!");	
	}
	public static int getCount(){
		return count;
	}
	public static void decrementCount(){
		count--;		
	}
	

	

}
