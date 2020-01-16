
public class Mammal extends Animal{
	//Create a mammal object
	public Mammal(String name,int age){
		//Invoke its super class' constructor 
		super(name,age);
	}
	public void walk(){
		System.out.println("I can walk to the far away lands!");		
	}
	public void reproduce(){
		System.out.println("I give birth!");		
	}
	public void herbivore(){
		System.out.println("I eat plants only!");		
	}
	

}
