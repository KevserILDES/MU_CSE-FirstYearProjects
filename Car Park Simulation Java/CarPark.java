import java.util.Date;

public class CarPark {
	/*Kevser ÝLDEÞ
	 * 150116048
	 */
	private int capacity;
	public ParkPlace[] parkPlaceArray;
	public Ticket[] ticketArray;
	private int totalSize;
	private static double totalIncome;
	private static int p;
	private static int t;
	private double hourlyPrice;
	//This constructor creates a car park object with given parameters
	public CarPark(int capacity,double hourlyPrice){

		this.capacity=capacity;
		this.hourlyPrice=hourlyPrice;
		parkPlaceArray=new ParkPlace[this.capacity];
		ticketArray=new Ticket[this.capacity];
	}
	//This method is to park a vehicle to the car park and create a ticket  
	public Ticket parkVehicle(Vehicle vehicle,Date entryDate){
		//Initialize ticket
		Ticket ticket=null;
		//Calculate the total size that used in car park
		for(int i=0;i<capacity;i++){
			if(parkPlaceArray[i]!=null)
				totalSize+=parkPlaceArray[i].getSize();
		}
		//Check if there is enough space for the vehicle
		if((capacity-totalSize)<vehicle.getSize())
			System.out.println("Car park is full!");
		else{
			//If there is create a new park place and ticket for that vehicle
			parkPlaceArray[p]=new ParkPlace(vehicle);
			p++;
			ticket=new Ticket(vehicle,entryDate);
			System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");
		}
		totalSize=0;
		//Return ticket
		return ticket;	



	}
	//This method for a vehicle to exit from car park
	public Vehicle exitVehicle(Ticket ticket,Date exitDate){
		Vehicle vehicle=null;
		for(int i=0;i<p;i++){
			//Search park place array and find which vehicle it is and print its price
			if(parkPlaceArray[i]!=null && ticket!=null){
				if(parkPlaceArray[i].getVehicle().getPlateNumber().equals(ticket.getVehicle().getPlateNumber())){					System.out.println("The price for vehicle with "+ticket.getVehicle().getPlateNumber()+" plate number is "+ticket.calculatePrice(hourlyPrice, exitDate));
					//Calculate the total income 
					totalIncome+=ticket.calculatePrice(hourlyPrice, exitDate);
					//Save the ticket in ticket array
					ticketArray[t]=ticket;
					t++;
					//Decrease the total size in used 
					totalSize-=parkPlaceArray[i].getSize();
					parkPlaceArray[i]=null;
					int j=i;
					while(parkPlaceArray[j+1]!=parkPlaceArray[j+1]){
						parkPlaceArray[j]=parkPlaceArray[j+1];
						j++;
					}
				}
			}
		}		
		return vehicle;
	}
	//This method returns the total income
	public double getTotalIncome(){
		return totalIncome;

	}
	//This method prints each vehicle that parked in car park 
	public void printVehicleList(){
		for(int i=0;i<capacity;i++){
			if(parkPlaceArray[i]!=null)
				System.out.println(parkPlaceArray[i].getVehicle().getVehicleInfo());
		}

	}
	//This method prints each tickets that vehicles have
	public void printTickets(){
		for(int i=0;i<t;i++){
			System.out.println(ticketArray[i].getTicketInfo());
		}


	}



}
