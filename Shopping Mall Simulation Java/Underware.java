
public class Underware extends Clothing{
	//This constructor invokes the argumented constructor of this class with the value of 30.0
	public Underware(){
		this(30.0);
	}
	public Underware(double basePrice){
		super.setBasePrice(basePrice);
	}
	//This method is overridden and calculates the price by adding 45% profit
	public double calculatePrice(){
		return getBasePrice()+getBasePrice()*getVat()+(getBasePrice()+getBasePrice()*getVat())*0.45;
	}
	public void howToWash(){
		System.out.println("Wash Underware at 60 degrees.");
	}

}
