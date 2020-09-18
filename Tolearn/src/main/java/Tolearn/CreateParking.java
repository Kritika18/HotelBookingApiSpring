package Tolearn;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import parking_lot.model.SaveCarData;
import parking_lot.payment.Car;
import parking_lot.payment.Payment;


public class CreateParking  {
	
	
	
		int slots;

		ArrayList<Integer> emptyspace = new ArrayList<>();
		static ArrayList<Integer> occupied = new ArrayList<>();

		public static void CreatingMethod(String slots) {
			System.out.print("Enter no of slots you want for parking");
			Scanner myObj = new Scanner(System.in); // Create a Scanner object

			slots = myObj.nextInt();
			
			System.out.println("in create " + slots);
			for(int i=1 ; i<=slots; i++)
			{
			 emptyspace.add(i);
			}

		}

		public Integer set(Integer plate) {

			System.out.println(occupied.size());
			System.out.println(slots + "in set");
			int size = occupied.size();
			int place = 0;
			if (size < slots) { 
				
				
				 //lets make hashmap <plate, slot> parked at 
				// parkedat.put(plate,slot)
				
				Collections.sort(emptyspace);

				place= emptyspace.get(0);
				occupied.add(place);
				
				emptyspace.remove(0);
				System.out.println(emptyspace);
				System.out.println("plate"+plate + "at" +place+ "place");
				System.out.println("parked at "  + occupied);
				
				
				//if (emptyspace.isEmpty()) {
					//available.add(plate);

				} 
			else
			{
				System.out.println("parking full");
			}

			return place;

		}
		
		
		public void spotis(Integer plate)
		{
			
			System.out.print(occupied); 
		}

		public static void showspots() {
			System.out.println("Parking is like this - " + occupied);

		}

		public void remove(Integer spot) {

			// int emptyit = getSpot(plate);
			 // 3

			
//			available.remove(empty); 
			
			//parkedat.remove(plate)
			 
			emptyspace.add(spot);
			occupied.remove(spot);
			Collections.sort(emptyspace);
			System.out.println(spot + " place is empty ");
//			available.remove(empty); 
			
			// remove plateno at this spot(empty)
			System.out.println("in remove method " + occupied);

			System.out.println("in remove method- new size of list " + occupied.size());

		}

		public static void main(String args[]) {
			// CreateParking create = new CreateParking();
			// create.CreatingMethod();

			Parking data = new Parking();
			data.CreatingMethod(slot);
			
			// Ticket ticket = new Ticket(); // left for future update
			ArrayList<SaveCarData> listObj = new ArrayList<>();
			// to get objects list

			int choice = 1, i = 0;
			while (choice != 0) {
				System.out.print(choice);
				System.out.print("Enter 0 to terminate");
				Scanner myObj = new Scanner(System.in);

				choice = myObj.nextInt();
				System.out.println("Enter options");
				System.out.println("1. Park car ");
				System.out.println("2.Leave car");
				System.out.println("3.Show Parking space");

				Integer options = myObj.nextInt();
				switch (options) {
				case 1:
					System.out.println("Lets Park car");
					System.out.println("Car no.");
					Integer plate = myObj.nextInt();
					System.out.println("Car color");
					String color = myObj.nextLine();
					
					int spot = data.set(plate); 
					// returns -1 if plate is not present
					//data.setSpot((Integer) spot);
					System.out.println(plate);
					System.out.println(color);
					System.out.println(spot);
					System.out.println("Case 1 setting at this - " + spot + " spot ");
					SaveCarData s = new SaveCarData();
					s.Setdata(plate, color, spot);
					
					if (spot > 0) {
						

						listObj.add(s);
						System.out.print("Save car method" + listObj);
						System.out.print("Save car method" + listObj.get(0));
						System.out.println("Ticket generated " );
						
						
						// if i make list of objects as list of spots 
						// then in leave method. I need to call data.getspot(ofplateno)  then i will have to remove that spot 
						 // from list  eg -one car already parked at 1 , park plate 123 - call setspot(plate ) - 2 
						 //add 2 in listofobj - [1,2] , leave(plate) -
						 // data.getspot(plate) -2 , -remove(2) - search if 2 is there in listofobj - there - remove 2 from listofobj [1].
					}

					break;
				case 2:
					System.out.println("Enter car no ");
					Integer plateno = myObj.nextInt();
					System.out.println("Enter hours ");
					Integer hours = myObj.nextInt();
					//System.out.println("Save car method in leave " + data.getSpot());
					//Integer empty = data.spotis(plateno);
					
					
					for (i = 0; i < listObj.size(); i++) {    // list is having 6 values (map) so iterating through values
						
							System.out.println(listObj);

							if (listObj.get(i).getPlateNo() == plateno ) {
								System.out.println("i is" +i);
								System.out.println(listObj.get(i));
								System.out.println("spot of " + plateno + " is " + listObj.get(i).getSpot());
								data.remove(listObj.get(i).getSpot());
								listObj.remove(i);
								
								i = 100;
							}

						}

					
					if (i != 101) {
						System.out.println("i is" + i);

						System.out.println("Car not in parking");

					} else {

						Payment pay = new Car();
						//pay.rate(hours);
					}
					break;

				case 3:
					data.showspots();
					System.out.println(listObj);

					break;

				case 4:


					break;
				default:
					System.out.println("Invalid option");
				}

			}

		
	}
}

