import java.awt.Color;

public class main {
	
	public static boolean running=true;

	public static void main(String[] args) {
		
			EZ.initialize(1024,768);
			EZ.addImage("A.png",512,384);
			Chicken[] chicken = new Chicken[10];
			Drone[] drone = {new Drone("B.png"), new Drone("SG Krab.png"), new Drone("SG Pat.png"), new Drone("SG Pearl.png"), new Drone("SG Squid.png")};
			Coop coop= new Coop();
			Timer timer = new Timer(System.currentTimeMillis());
			Score score = new Score(coop);
			
			EZSound background= EZ.addSound("SpongeBob Trap Remix Krusty Krab.wav");
			
			background.play();
			
			for(int i = 0; i < drone.length; i++)
			{
				drone[i].introduceChickensToDrone(chicken, chicken.length);
				drone[i].setPosition(0,384);	
			}
			
			for(int i=0;i<chicken.length;i++)
			{
				chicken[i]= new Chicken();
				chicken[i].introduceDronesToChicken(drone, drone.length);
			}
			coop.introduceChickensToCoop(chicken, chicken.length);
			
			
			while(running)
			{
				score.start();
				timer.start();
				
				if(timer.getSeconds() <= 13)
				{
					for(int i = 0; i < drone.length; i++)
					{
						drone[i].move(0, (i+1) * 128);	
					}	
				}
				else if(timer.getSeconds() > 13 && timer.getSeconds() < 39)
				{
					for(int i = 0; i < drone.length; i++)
					{
						drone[i].move(EZ.getWindowWidth() / 2, drone[i].getY());	
					}	
				}
				else if(timer.getSeconds() >= 39 && timer.getSeconds() < 44)
				{
					drone[0].move(616, drone[1].getY());
					drone[4].move(616, drone[3].getY());
				}
				else if(timer.getSeconds() >= 44)
				{
					drone[0].move(875, drone[0].getY());
					drone[1].move(775, drone[1].getY());
					drone[2].move(775, drone[2].getY());
					drone[3].move(775, drone[3].getY());
					drone[4].move(875, drone[4].getY());
				}
					
				for(int i = 0; i < chicken.length; i++)
				{
					chicken[i].go();
				}
				
				if(coop.numberOfChickensInCoop() == chicken.length || timer.getMinutes() == 2)
				{
					EZ.removeAllEZElements();
					EZ.addText(EZ.getWindowWidth()/2, EZ.getWindowHeight()/4, "The Game Has Ended", Color.BLACK, 51);
					EZ.addText(EZ.getWindowWidth()/2, EZ.getWindowHeight()/2, "Your Score Is: " + score.getScore(), Color.BLACK, 51);
					running = false;
					background.stop();
				}
				
				EZ.refreshScreen();
				EZ.removeEZElement(score.getText());
				EZ.removeEZElement(timer.getText());
			}
	}

}
