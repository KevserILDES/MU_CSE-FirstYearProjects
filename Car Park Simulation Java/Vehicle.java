public class Vehicle {
	/*Kevser ÝLDEÞ
	 * 150116048
	 */
	private String plateNumber;
	private int size;
	//This constructor creates a new vehicle object with given plate number and size
	public Vehicle(String plateNumber,int size){
		this.plateNumber=plateNumber;
		if(size==1 || size==2 || size==4)
			this.size=size;

	}
	//This method returns the plate number
	public String getPlateNumber(){
		return plateNumber;
	}
	//This method returns the size
	public int getSize(){
		return size;
	}
	//This method returns a string that includes information about vehicle
	public String getVehicleInfo(){
		return ("Vehicle Info\n"+"Plate Number : "+plateNumber+"\nSize : "+size);
	}


}
