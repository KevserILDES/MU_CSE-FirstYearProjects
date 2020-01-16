import java.util.Date;

public class Ticket {
	/*Kevser ÝLDEÞ
	 * 150116048
	 */
	private Vehicle vehicle;
	private Date entryDate;
	private Date exitDate;
	private double totalPrice;
	public static int numberOfTickets;
	//This constructor creates a new ticket object with given parameters and increment the number of tickets for each tickets
	public Ticket(Vehicle vehicle,Date entryDate){
		this.entryDate=entryDate;
		this.vehicle=vehicle;
		numberOfTickets++;
	}
	//This method returns total price for vehicle
	public double calculatePrice(double hourlyPrice,Date exitDate){
		this.exitDate=exitDate;		
		totalPrice=vehicle.getSize()*hourlyPrice*(Math.ceil(2.8*Math.pow(10, -7)*(exitDate.getTime()-entryDate.getTime())));
		return totalPrice;
	}
	//This method returns a string that includes information about ticket
	public String getTicketInfo(){
		if(exitDate==null)
			return ("Ticket Info\nPlateNumber : "+vehicle.getPlateNumber()+"\nEntry : "+(entryDate.toString()));
		else
			return ("Ticket Info\nPlateNumber : "+vehicle.getPlateNumber()+"\nEntry : "+entryDate.toString()+"\nHour : "+Math.ceil((2.8*Math.pow(10, -7)*(exitDate.getTime()-entryDate.getTime())))+"\nExit : "+(entryDate.toString())+"\nFee : "+totalPrice+" Tls");



	}
	//This method returns a vehicle object that ticket has
	public Vehicle getVehicle(){
		return vehicle;
	}
	//This method returns the total price
	public double getPrice(){
		return totalPrice;	
	}



}
