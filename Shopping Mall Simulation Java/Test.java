
public class Test {
	/* Kevser İLDEŞ
	 * 150116048
	 */
	public static void main(String[] args){
		ShoppingMall sM=new ShoppingMall();
		sM.addDairy();
		sM.addFruit();
		sM.addTop();
		sM.addTrousers();
		sM.addUnderware();
		sM.addVegetable();
		sM.addArbitrary(new Top(100));
		printContent(sM);
		System.out.println();
		printWashingInstructions(sM);
		System.out.println();
		System.out.println("Total bill is "+sM.bill());
	}
	//This method invokes the madeOf method of the shopping mall's vegan instances
	public static void printContent(ShoppingMall sM){
		for(int i=0;i<sM.getItems().size();i++)
			if(sM.getItems().get(i) instanceof Vegan)
				((Vegan)sM.getItems().get(i)).madeOf();
	}
	//This method invokes the howToWash method of the shopping mall's washable instances
	public static void printWashingInstructions(ShoppingMall sM){
		for(int i=0;i<sM.getItems().size();i++)
			if(sM.getItems().get(i) instanceof Washable)
				((Washable)sM.getItems().get(i)).howToWash();
	}

}
