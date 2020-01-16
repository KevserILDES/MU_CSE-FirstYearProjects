
public class Fruit extends Food implements Vegan,Washable{
	//This constructor invokes the argumented constructor of this class with the value of 6.0
	public Fruit(){
		this(6.0);		
	}
	public Fruit(double basePrice){
		super.setBasePrice(basePrice);		
	}
	//This method is overridden and calculates the price by adding 20% profit
	public double calculatePrice(){
		return getBasePrice()+getBasePrice()*getVat()+(getBasePrice()+getBasePrice()*getVat())*0.2;
	}
	public void howToWash(){
		System.out.println("Wash fruit with cold water.");
	}
	public void madeOf(){
		System.out.println("It is made only of fruits");
	}
}
