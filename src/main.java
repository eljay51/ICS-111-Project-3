import java.awt.Color;

public class main {

	public static void main(String[] args) {
		
		EZ.initialize(1024,768);
		EZ.addImage("field.jpg",512,384);
		Chicken[] chicken = new Chicken[10];
		Drone drone = new Drone();
		Coop coop= new Coop();
		
		drone.setPosition(0,384);
		
		
		for(int i=0;i<chicken.length;i++){
			chicken[i]= new Chicken();
		}
		
		while(true){
			for (int i=0;i<chicken.length;i++){
				chicken[i].go();
			}
		drone.go();
		
		EZText score= EZ.addText(884,500,""+ coop.numberOfChickensInCoop(),Color.BLACK,51);
		
		EZ.refreshScreen();
		}
	}

}
