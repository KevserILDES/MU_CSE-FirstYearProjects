public class ParkPlace {
	/*Kevser ÝLDEÞ
	 * 150116048
	 */
	private int size;
	private Vehicle vehicle;
	//This constructor creates a new park place object according to given vehicle
	public ParkPlace(Vehicle vehicle){
		this.vehicle=vehicle;
		this.size=vehicle.getSize();

	}
	//This method returns the size
	public int getSize(){
		return size;
	}
	//This method returns the vehicle that parks in that place
	public Vehicle getVehicle(){
		return vehicle;
	}



}
