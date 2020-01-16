
public class Donkey extends Mammal{
	private static int count=0;
	//Create a donkey object
    public Donkey(String name,int age){
		//Invoke its super class' constructor and some of its methods
    	super(name,age);
    	super.setLegNumber(4);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(1);
		count++;
    }
    public void sayGreeting(){
    	System.out.println("Life will go on as it has always gone-that is,badly!");    	
    }
    public static int getCount(){
    	return count;
    }
    public static void decrementCount(){
    	count--;    	
    }
    
    

    

}
