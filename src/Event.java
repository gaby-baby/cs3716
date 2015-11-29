import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Event implements Serializable {
	String location;
	String description;
	Calendar  date;
	public Event(String aLocation, String aDescription, GregorianCalendar aDate){
		location = aLocation;
		description = aDescription;
		date = aDate;	
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	//Formatted String returning HH:MM
	public String getTime(){
		int hours = date.get(Calendar.HOUR_OF_DAY);
		int minutes = date.get(Calendar.MINUTE);
		return hours+":"+minutes;
	}
	//Formatted String returning dayofweek
	public String getDayOfWeek(){
		int day_of_week = date.get(Calendar.DAY_OF_WEEK); 
		if(day_of_week==1)
			return "sunday";
		else if(day_of_week==2)
			return "monday";
		else if(day_of_week==3)
			return "tuesday";
		else if(day_of_week==4)
			return "wednesday";
		else if(day_of_week==5)
			return "thursday";
		else if(day_of_week==6)
			return "friday";
		else
			return "saturday";
	}
	//Formatted String returning abbreviated month
	public String getMonth(){
		int currMonth = date.get(Calendar.MONTH);
		if(currMonth==0)
			return "Jan";
		if(currMonth==1)
			return "Feb";
		if(currMonth==2)
			return "Mar";
		if(currMonth==3)
			return "Apr";
		if(currMonth==4)
			return "May";
		if(currMonth==5)
			return "Jun";
		if(currMonth==6)
			return "Jul";
		if(currMonth==7)
			return "Aug";
		if(currMonth==8)
			return "Sep";
		if(currMonth==9)
			return "Oct";
		if(currMonth==10)
			return "Nov";
		else
			return "Dec";
		
	}
	

}
