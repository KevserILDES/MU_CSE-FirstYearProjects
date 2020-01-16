
public class Trousers extends Clothing{
	//This constructor invokes the argumented constructor of this class with the value of 40.0	
	public Trousers(){
		this(40.0);
	}
	public Trousers(double basePrice){
		super.setBasePrice(basePrice);
	}
	//This method is overridden and calculates the price by adding 20% profit
	public double calculatePrice(){
		return getBasePrice()+getBasePrice()*getVat()+(getBasePrice()+getBasePrice()*getVat())*0.2;
	}
	public void howToWash(){
		System.out.println("Wash Trousers at 30 degrees.");
	}
	

}
