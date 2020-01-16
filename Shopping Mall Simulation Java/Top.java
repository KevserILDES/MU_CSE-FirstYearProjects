
public class Top extends Clothing{
	//This constructor invokes the argumented constructor of this class with the value of 20.0
	public Top(){
		this(20.0);
	}
	public Top(double basePrice){
		super.setBasePrice(basePrice);
	}
	//This method is overridden and calculates the price by adding 20% profit
	public double calculatePrice(){
		return getBasePrice()+getBasePrice()*getVat()+(getBasePrice()+getBasePrice()*getVat())*0.2;
	}
	public void howToWash(){
		System.out.println("Wash Top at 40 degrees.");
	}

}
