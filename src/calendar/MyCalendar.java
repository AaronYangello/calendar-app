package calendar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MyCalendar {

	private HashMap<String, Event> events = new HashMap<String, Event>(); //A list of events taking place on this day mapped by name
	
	public MyCalendar() {
		
	}
	
	/**
	 * Returns the contents of the calendar
	 * @return
	 */
	public String displayCalendar()
	{		
		StringBuilder contents = new StringBuilder();
		
		if(events.size() <= 0)
		{
			contents = null;
		}
		else
		{
			Set<Entry<String, Event>> set = events.entrySet();
			Iterator<Entry<String, Event>> it = set.iterator();
			
			while(it.hasNext())
			{
				Event e = it.next().getValue();
				
				contents.append("Event \"" + e.getName() + "\" is on " + e.getDate() + "\r\n");
			}
		}
		
		return contents.toString();
	}

	/**
	 * Add an event for this day and returns the status of the action (true - item was added | false - item already exists)
	 * @param event
	 */
	public boolean addEvent(Event event)
	{
		boolean status = events.put(event.getName(), event) == null ? false : true;
		
		return status;
	}
	
	/**
	 * Return all of the events on this date 
	 * @return
	 */
	public HashMap<String, Event> getEvents()
	{
		return events;
	}
	
	/**
	 * Delete a specific date for this day and returns the status of the action (true - item was deleted | false - item did not exist)
	 * @param eventName
	 */
	public boolean deleteEvent(String eventName) {
		
		boolean status = events.remove(eventName) == null ? false : true;
		
		return status;
	}
	
	/**
	 * Clear all events on a specific day and returns the status of the action (true - items were deleted | false - items did not exist on specified day)
	 * @param month
	 * @param day
	 * @param year
	 */
	public boolean clearDay(String month, String day, String year, String deleteRecurring)
	{
		year = (year.equals("0") ? "of every year" : year);
		
		boolean status = false;
		
		Set<Entry<String, Event>> set = events.entrySet();
		Iterator<Entry<String, Event>> it = set.iterator();
		
		while(it.hasNext())
		{
			Entry<String, Event> e = (Entry<String, Event>)it.next();
			
			if(deleteRecurring.toLowerCase().equals("y"))
			{
				if( (e.getValue().getDate().equals(month + " " + day + ", " + year)) || 
					(e.getValue().getDate().equals(month + " " + day + ", " + "of every year")) )
				{
					//status = events.remove(e.getKey()) == null ? false : true;
					it.remove();
					status = true;
				}
			}
			else
			{
				if(!year.equals("of every year") && (e.getValue().getDate().equals(month + " " + day + ", " + year)) )
				{
					//status = events.remove(e.getKey()) == null ? false : true;
					it.remove();
					status = true;
				}
			}
			
		}
		
		return status;
	}
	
	/**
	 * Delete all events for this day
	 */
	public void deleteAllEvents()
	{
		events.clear();
	}

}