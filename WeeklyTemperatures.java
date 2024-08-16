import java.util.Scanner;
import java.util.ArrayList;

public class WeeklyTemperatures {
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		double minCelTemp = -273.15;
		
		// Declaring and Initializing Array List Day of Week
		ArrayList<String> daysOfWeek = new ArrayList<String>(); 
		daysOfWeek.add("monday");
		daysOfWeek.add("tuesday");
		daysOfWeek.add("wednesday");
		daysOfWeek.add("thursday");
		daysOfWeek.add("friday");
		daysOfWeek.add("saturday");
		daysOfWeek.add("sunday");
		
		// Declaring Array list to store daily temperatures
		ArrayList<Double> dailyTemp = new ArrayList<Double>();
		
		// Getting Temperature for each day from user
		for (int i = 0; i < daysOfWeek.size(); ++i) {
			System.out.println("Enter temperature of " +daysOfWeek.get(i)  +" in Celsius: ");
			
			// Checking for invalid entry
			while(!scnr.hasNextDouble()) {
				System.out.println("Invalid Input. Re-enter temperture for "+daysOfWeek.get(i)  +" in Celsius: ");
				scnr.next();
			}
			
			double temp = scnr.nextDouble();
			// Checking temperatures is not less than -273.15C
			if (temp < minCelTemp) {
				System.out.println("Temperature not possible. Re-enter");
				i-- ;
			}
			else {
				dailyTemp.add(temp);
			}
		}
		
		// Temperature display based on user input
		String menu = "c";
		while(!menu.equalsIgnoreCase("exit")) {
			
			System.out.println("\nEnter a day of the week for temperature or 'week' to see all temperature and summary: ");
			String input = scnr.next().toLowerCase();
			
			if(input.equals("week")) {
				double sumTemp = 0;
				System.out.println("\nTemperature of each day:");
				for (int i = 0; i < daysOfWeek.size(); ++i) {
					System.out.println(daysOfWeek.get(i) +":" +dailyTemp.get(i) +"°C");
					sumTemp = sumTemp + dailyTemp.get(i);
				}
				System.out.println("\nAverage temperature of week:" +(sumTemp/daysOfWeek.size()) +"°C");				
			}

			else if(daysOfWeek.contains(input)) {
				int position = daysOfWeek.indexOf(input);
				System.out.println("Temperature of " +daysOfWeek.get(position) +" is:" +dailyTemp.get(position) );
			}

			else {
				System.out.println("Invalid entry");
			}
			
			System.out.println("\nPress any character to continue or type 'exit' to exit:");
			menu = scnr.next().toLowerCase();
			}		
		scnr.close();
	}
}