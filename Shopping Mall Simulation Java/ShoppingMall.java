import java.util.ArrayList;

public class ShoppingMall {
	private static ArrayList<Item> items=new ArrayList<>();
	public ArrayList<Item> getItems(){
		return items;
	}
	public void addDairy(){
		items.add(new Dairy());
	}
	public void addFruit(){
		items.add(new Fruit());
	}
	public void addTop(){
		items.add(new Top());
	}
	public void addTrousers(){
		items.add(new Trousers());
	}
	public void addUnderware(){
		items.add(new Underware());
	}
	public void addVegetable(){
		items.add(new Vegetable());
	}
	public void addArbitrary(Item item){
		items.add(item);
	}
	//This method calculates the total bill
	public double bill(){
		double sum=0;
		for(int i=0;i<items.size();i++)
			sum+=items.get(i).calculatePrice();
		return sum;
	}
	

}
