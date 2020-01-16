
public class Raven extends Bird{
	private static int count=0;
	//Create a raven object
	public Raven(String name,int age){
		//Invoke its super class' constructor and some of its methods
		super(name,age);
		super.setLegNumber(2);
		super.setNumberOfOffsprings(5);
		super.setPregnancyPerYear(1);
		count++;
	}
	public void sayGreeting(){
		System.out.println("A happy country where we poor animals shall rest forever!");				
	}
	public static int getCount(){
		return count;
	}
	public static void decrementCount(){
		count--;
	}
	
	
}
