
public class Dairy extends Food{
	public Dairy(){
		this(8.0);		
	}
	public Dairy(double basePrice){
		super.setBasePrice(basePrice);				
	}
	//This method is overridden and return the price
	public double calculatePrice(){
		return getBasePrice()+getBasePrice()*getVat()+(getBasePrice()+getBasePrice()*getVat())*0.3;
	}

}
