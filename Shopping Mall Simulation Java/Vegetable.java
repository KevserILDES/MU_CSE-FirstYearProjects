
public class Vegetable extends Food implements Vegan,Washable{
	//This constructor invokes the other constructor of this class with the value 10.0
	public Vegetable(){
		this(10.0);
	}
	public Vegetable(double basePrice){
		super.setBasePrice(basePrice);
	}
	//This method is overridden and calculates the price by adding 25% profit
	public double calculatePrice(){
		return getBasePrice()+getBasePrice()*getVat()+(getBasePrice()+getBasePrice()*getVat())*0.25;
	}
	//This method is overridden and return the washing instruction
	public void howToWash(){
		System.out.println("Wash Vegetable with warm water.");
	}
	//This method is overridden and return what it is made of
	public void madeOf(){
		System.out.println("It is made only of vegetables.");
	}
	

}
