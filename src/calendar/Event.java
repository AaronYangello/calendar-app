package calendar;

public class Event {

	private String name = ""; //Name of the event
	private String month = ""; //Month event will take place e.g. January, February, March...
	private String day; //Day of the month event will take place
	private String year; //Year event will take place
	
	/**
	 * Constructor - Sets new event
	 * @param month
	 * @param day
	 * @param year
	 */
	public Event(String name, String month, String day, String year)
	{
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = (year.equals("0") ? "of every year" : year);
	}
	
	/**
	 * No argument constructor
	 */
	public Event()
	{
		
	}
	
	/**
	 * Sets the name of the event
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns the name of the event
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the date of the event
	 */
	public void setDate(String month, String day, String year)
	{
		this.month = month; //Sets month
		this.day = day; //Sets day
		this.year = (year.equals("0") ? "of every year" : year); //Sets year. If year is "0", the 
	}
	
	/**
	 * Return the date of the calendar entry
	 * @return
	 */
	public String getDate()
	{
		return (month + " " + day + ", " + year);
	}
	
	/**
	 * Set the day of the event with given day
	 * @param day
	 */
	public void setDay(String day)
	{
		this.day = day;
	}
	
	/**
	 * Return day of the event
	 * @return
	 */
	public String getDay()
	{
		return day;
	}
	
	/**
	 * Set the month in which the event will occur 
	 * @param month
	 */
	public void setMonth(String month)
	{
		this.month = month;
	}
	
	/**
	 * Returns the month in which the event will occur
	 * @return
	 */
	public String getMonth()
	{
		return month;
	}
	
	/**
	 * Set the year in which the event will occur
	 * @param year
	 */
	public void setYear(String year)
	{
		this.year = (year.equals("0") ? "of every year" : year);
	}
	
	/**
	 * Returns the year in which the event will occur
	 * @return
	 */
	public String getYear()
	{
		return year;
	}

}