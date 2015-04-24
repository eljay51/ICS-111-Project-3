import java.awt.Color;

public class main {
	
	public static boolean running=true;

	public static void main(String[] args) {
		
		EZ.initialize(1024,768);
		EZ.addImage("field.jpg",512,384);
		
		Chicken[] chicken = new Chicken[10];
		Drone[] drone = new Drone[5];
		Coop coop= new Coop();
		Timer timer= new Timer(System.currentTimeMillis());
		coop.introduceChickensToCoop(chicken, 10);
		
		
				
		for(int i=0;i<chicken.length;i++){
			chicken[i]= new Chicken();
			chicken[i].introduceDronesToChicken(drone,drone.length);
		}
		for(int i=0;i<drone.length;i++){
			drone[i]= new Drone();
			drone[i].setPosition(0,384);
			drone[i].introduceChickensToDrone(chicken,chicken.length);
//			drone[1].move(200,200);
		}
		

		
		
		while(running){
			
			timer.start();
//			drone[1].move(200,200);


			for(int i=0;i<drone.length;i++){
				drone[i].go();
				drone[1].move(200,200);

			}
			 for (int i=0;i<chicken.length;i++){
				 chicken[i].go();

			 }
				
			 if(coop.numberOfChickensInCoop()== chicken.length || timer.getMinutes()==2){
				 
				 EZ.addText(512,384,"GAME OVER",Color.BLACK,51);
				 running=false;
			 }
			

		
		EZText score= EZ.addText(884,500,""+ coop.numberOfChickensInCoop(),Color.BLACK,51);
		
		EZ.refreshScreen();
		EZ.removeEZElement(timer.getText());
		
		}
	}

}
