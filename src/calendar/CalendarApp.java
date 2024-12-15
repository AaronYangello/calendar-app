package calendar;

import java.io.BufferedReader; //For buffered input
import java.io.InputStreamReader; //To read console input
import java.io.IOException; //For IOException

public class CalendarApp {

	public static void main(String[] args) throws IOException {
		
		//The menu to be shown after every action
		final String menu = "\n" +
							"Select from the following menu: \r\n" + 
							"\t0. Exit the program.\r\n" + 
							"\t1. Add an event.\r\n" + 
							"\t2. Delete an event.\r\n" + 
							"\t3. Delete all events on a specified day.\r\n" + 
							"\t4. Display content of Calendar.\r\n" + 
							"\t5. Search for an event.";
		
		MyCalendar cal = new MyCalendar(); //The calendar to hold all events
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //Buffered reader to read input
		
		System.out.println(menu); //Display menu
		
		String line = null; //To hold each line of input file
		
		System.out.print("Make your selection now: "); //Prompt for input and input
		
		//Reading each line of input file
		while((line = in.readLine().trim()) != null)
		{			
			System.out.println(line); //Echo input
			
			//Exit
			if(line.equals("0"))
			{
				//Tell program is closing
				System.out.println("Exiting program...good bye");
				break;
			}
			//Add event
			else if(line.equals("1")) 
			{
				String name = "",  //Event name
					   day = "",   //Day on which the event will occur
					   month = "", //Month in which event will occur
					   year = "";  //Year in which the event will occur
				
				System.out.println("You are now adding a new event to your Calendar."); //Tell user we're adding an event
				
				//Event Name
				System.out.print("\tEnter the name of the event: "); //Prompt and input for event name
				line = in.readLine().trim();// read next line
				name = line; //Save off name
				System.out.println(name); //Echo response
				
				while(cal.getEvents().get(name) != null) //Event already exists
				{
					System.out.println("Event \"" + name + "\" already exists. Enter a different event Name!");
	 									
					System.out.println("\tEnter the name of the event: "); //Prompt and input for event name
					line = in.readLine().trim();// read next line
					name = line; //Save off name
					System.out.println(name); //Echo response
				}
				
				//Event day
				System.out.print("\tEnter day of event: "); //Prompt and input for event day
				line = in.readLine().trim();// read next line
				day = line; //Save off day
				System.out.println(day); //Echo response

				//Event month
				System.out.print("\tEnter month of event: "); //Prompt and input for event month
				line = in.readLine().trim();// read next line
				month = line; //Save off month
				System.out.println(month); //Echo response

				//Event month
				System.out.print("\tEnter year of event: "); //Prompt and input for event year
				line = in.readLine().trim();// read next line
				year = line; //Save off year
				System.out.println(year); //Echo response

				//Create new event in calendar
				Event event = new Event(name, month, day, year);
				cal.addEvent(event);
				
				//Tell user of the success
				System.out.println("Event \"" + event.getName() + "\" has been registered for " + event.getName() + " " + event.getMonth() + " " + event.getYear() + ".");
			}
			//Delete an event
			else if(line.equals("2"))
			{
				//Calendar is empty
				if(cal.getEvents().isEmpty())
				{
					System.out.println("There are no events to delete in the Calendar."); //Tell user there are no events in calendar
				}
				else
				{
					String name = "";  //Event name
					
					System.out.println("You are now deleting an event from your Calendar."); //Tell user we're deleting an event
					
					//Event Name
					System.out.print("Enter the name of the event: " ); //Prompt and input for event name
					line = in.readLine().trim();// read next line
					name = line; //Save off name
					System.out.println(name); //Echo response

					if(cal.deleteEvent(name)) //Successfully deleted
					{
						System.out.println("Event \"" + name + "\" has been deleted from the Calendar.");
					}
					else //Event did not exist
					{
						System.out.println("No event with this name in the Calendar!");
					}
				}
			}
			//Delete all events on a day
			else if(line.equals("3"))
			{
				//Calendar is empty
				if(cal.getEvents().isEmpty())
				{
					System.out.println("There are no events to delete in the Calendar."); //Tell user there are no events in calendar
				}
				else
				{
					String day = "",    //Day on which the event will take place
						   month = "", //Month in which the event will take place
						   year = "",  //Year in which the event will take place
						   recurring = ""; //Delete recurring events, as well (Y/N)?
					
					System.out.println("You are now deleting all events for a specified day."); //Tell user we're deleting an event
					
					//Event day
					System.out.print("\tEnter day: "); //Prompt and input for event day
					line = in.readLine().trim();// read next line
					day = line; //Save off day
					System.out.println(day); //Echo response
					
					//Event month
					System.out.print("\tEnter month of event: " ); //Prompt and input for event month
					line = in.readLine().trim();// read next line
					month = line; //Save off month
					System.out.println(month); //Echo response

					//Event year
					System.out.print("\tEnter year of event: "); //Prompt and input for event year
					line = in.readLine().trim();// read next line
					year = line; //Save off year
					System.out.println(year); //Echo response

					//Delete recurring events
					System.out.print("Should any recurring events be deleted also?(Y/N): "); //Prompt and input for recurring
					line = in.readLine().trim();// read next line
					recurring = line; //Save off recurring
					System.out.println(recurring); //Echo response

					//Successfully deleted including recurring events
					if(recurring.toLowerCase().equals("y") && cal.clearDay(month, day, year, recurring)) 
					{
						System.out.println("Events on " + month + " " + day  + ", " + year + " including recurring have been deleted from the Calendar.");
					}
					//Successfully deleted excluding recurring events
					else if(recurring.toLowerCase().equals("n") && cal.clearDay(month, day, year, recurring)) 
					{
						System.out.println("Events on " + month + " " + day  + ", " + year + " excluding recurring have been deleted from the Calendar.");
					}
					//Event did not exist
					else 
					{
						System.out.println("There are no events on " + month + " " + day + ", " + year + ".");
					}
				}
			}
			//Display contents of calendar
			else if(line.equals("4"))
			{
				//Calendar is empty
				if(cal.getEvents().isEmpty())
				{
					//Tell user the calendar is empty
					System.out.println("Your Calendar has no registered events.");
				}
				else
				{
					//Tell the user how many events are on the calendar
					System.out.println("Your calendar has the following " + cal.getEvents().size() + " events: ");
					
					//display contents
					System.out.println(cal.displayCalendar());
				}
				
			}
			//Search for an event
			else if(line.equals("5"))
			{
				//Calendar is empty
				if(cal.getEvents().isEmpty())
				{
					//Tell user the calendar is empty
					System.out.println("There are no events in the Calendar.");
				}
				else
				{
					String name = ""; //The event name
					
					//Tell user we're searching for an event
					System.out.println("You are now searching for an event.");
					
					//Event Name
					System.out.print("\tEnter the name of the event to search for: "); //Prompt and input for event name
					line = in.readLine().trim();// read next line
					name = line; //Save off name
					System.out.println(name); //Echo response

					//Search for event and show information
					Event event = cal.getEvents().get(name);
					if(event == null)
					{
						System.out.println("Event \"" + name + "\" is not in the Calendar");
					}
					else
					{
						System.out.println("Event \"" + name + "\" is on " + event.getDate());
					}
				}
			}
			else
			{
				//Tell user input not recognized
				System.out.println("Input not recognized. Please choose an option from the menu");
				System.out.println(menu);
			}
			
			System.out.print("\nMake your selection now: "); //Prompt for input and input
		}
		
		System.exit(0); //Exit program
		
	} //End main
} //End Main