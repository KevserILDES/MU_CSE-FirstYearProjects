import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Kevser İLDEŞ
		 * 150116048
		 */
		//Create date objects
		Date date=new Date();
		Date date1=new Date();
		Date date2=new Date();
		Date date3=new Date();
		Date date4=new Date();
		Date date5=new Date();
		Date date6=new Date();
		Date date7=new Date();
		Date date8=new Date();
		date.setTime(0);
		//Create a car park object with the capacity of 10 and hourly price of 5
		CarPark carPark=new CarPark(10,5);
		//Create 5 vehicle objects with different id
		Vehicle vehicle1=new Vehicle("34UM30",4);
		Vehicle vehicle2=new Vehicle("34UM31",2);
		Vehicle vehicle3=new Vehicle("34UM32",1);
		Vehicle vehicle4=new Vehicle("34UM33",2);
		Vehicle vehicle5=new Vehicle("34UM34",4);
		//Create ticket objects for each vehicle
		Ticket t=carPark.parkVehicle(vehicle1,date);
		date1.setTime(1);
		Ticket t1=carPark.parkVehicle(vehicle2,date1);
		date2.setTime(2);
		Ticket t2=carPark.parkVehicle(vehicle3,date2);
		date3.setTime(3);
		Ticket t3=carPark.parkVehicle(vehicle4,date3);
		date4.setTime(4);
		Ticket t4=carPark.parkVehicle(vehicle5,date4);
		//Invoke the print vehicle list method of car park object
		carPark.printVehicleList();
		//Exit two vehicles from car park
		date5.setTime(6);
		carPark.exitVehicle( t,date5);
		date6.setTime(7);
		carPark.exitVehicle(t1, date6);
		//Invoke the print vehicle list method of car park object again
		carPark.printVehicleList();
		//Exit remaining vehicles from car park
		date7.setTime(8);
		carPark.exitVehicle(t2, date7);
		date8.setTime(9);
		carPark.exitVehicle(t3, date8);
		//Print the total income and number of tickets
		System.out.println("Total Income : "+carPark.getTotalIncome());
		System.out.println("Total number of tickets : "+Ticket.numberOfTickets);
		//Invoke the print tickets object of car park pbject
		carPark.printTickets();

	}

}
