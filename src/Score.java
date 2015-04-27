import java.awt.Color;


public class Score
{
	private Coop coop;
	private EZText text;
	
	public Score(Coop coop)
	{
		this.coop = coop;
	}
	
	//Starts Scoring
	public void start()
	{
		text = EZ.addText(884,500,"Score: "+ coop.numberOfChickensInCoop(),Color.BLACK,51);
	}
	
	//Returns the number of chickens in the coop a.k.a. score
	public int getScore()
	{
		return coop.numberOfChickensInCoop();
	}
	
	//Returns the EZ Text
	public EZText getText()
	{
		return text;
	}
}