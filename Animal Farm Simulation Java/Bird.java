
public class Bird extends Animal{
	//Create a bird object
	public Bird(String name,int age){
		//Invoke its super class' constructor 
		super(name,age);		
	}
	public void fly(){
		System.out.println("I can fly to the endless skies!");		
	}
	public void reproduce(){
		System.out.println("I lay eggs!");		
	}
	public void omnivore(){
		System.out.println("I can eat everything!");		
	}

}
