import java.awt.Color;


public class Timer {
	
    private long currentTime;
    private int seconds;
    private int minutes;
    private EZText text;
    public Timer(long curtime)
    {
            currentTime = curtime;
    }
   
    public void start()
    {		
 
            if( getCurrentTimeInSeconds() % 60 == 0)
            {
                    minutes =  getCurrentTimeInSeconds()/60;

            }
            else
            {
                    seconds =  getCurrentTimeInSeconds();

            }
            text = EZ.addText(65, 40, "0" + minutes + ":" + (seconds < 10 || (seconds > 60 && seconds < 70) ? "0" : "") + (seconds > 60 ? seconds - 60 : seconds), Color.BLACK, 51); 
    	}
  
   
    public EZText getText()
    {
            return text;
    }
   
    public int getMinutes()
    {
            return minutes;
    }
   
    public int getSeconds()
    {
            return seconds;
    }
   
    public int getCurrentTimeInSeconds()
    {
            return (int)(System.currentTimeMillis() - currentTime)/1000;
    }
}
