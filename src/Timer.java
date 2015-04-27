import java.awt.Color;


public class Timer {
		
	private long startTime;
	private int seconds;
	private int minutes;
	private EZText text;
	
	//startTime = Time when class is initialized in milliseconds.
	public Timer(long curtime)
	{
		startTime = curtime;
	}
	
	//Starts timer.
	public void start()
	{
		//Checks if a minute has gone by.
		if( getCurrentTimeInSeconds() % 60 == 0)
		{
			minutes =  getCurrentTimeInSeconds()/60;
		}
		else
		{
			seconds =  getCurrentTimeInSeconds();	
		}
		
		//Returns 0 and the minutes gone by. if the seconds is less than 10 return 0 plus seconds. or if there is a minute and seconds is less than a minute and 10 return 0 plus seconds + i.     
		text = EZ.addText(65, 40, "0" + minutes + ":" + (seconds < 10 || (seconds > 60 && seconds < 70) ? "0" : "") + (seconds >= 60 ? (seconds - 60) == 0 ? "00" : seconds - 60 : seconds), Color.BLACK, 51);
	}
	
	//Returns the text
	public EZText getText()
	{
		return text;
	}
	
	//Returns the minutes that have gone by
	public int getMinutes()
	{
		return minutes;
	}

	//Returns the seconds that have gone by
	public int getSeconds()
	{
		return seconds;
	}
	
	//Subtracts the current time from the start time to get how much time in seconds has gone by
	public int getCurrentTimeInSeconds()
	{
		return (int)(System.currentTimeMillis() - startTime)/1000;
	}
}
