import java.util.Random;

// The drone class will control the artificial intelligence of the drone for the Drone vs Chicken program
// You will begin development with the go() member function.

public class Drone extends Agent {

	Chicken[] chickens;			// This array contains all the chickens
	int numberOfChickens;		// This tells you how many chickens there are
	
	// Constructor for drone
	Drone() {
		
		// Place the drone at random locations
		Random randomGenerator = new Random();
		x = randomGenerator.nextInt(1024);
		y = randomGenerator.nextInt(768);
		picture = EZ.addImage("drone.png", x, y);
	}
	
	// Assign array of chickens to drone
	void introduceChickensToDrone(Chicken[] chk, int nchickens){
		chickens = chk;
		numberOfChickens = nchickens;
	}
	
	void setImagePosition(int posx, int posy) {
		super.setImagePosition(posx, posy);
		picture.rotateBy(1);
	}
	
	// Here is where you begin to put the intelligence for your drones.
	// Call this repeatedly to keep the drone updated.
	int prevx=0;
	int prevy=0;
	
	void go(){
		
		if (x > 1024) moveLeft(1);
		if (x < 0) moveRight(1);
		if (y > 768) moveUp(1);
		if (y < 0) moveDown(1);
//		move(posx,posy);
		
	}
	
	void move(int posx,int posy){
		boolean destination=false;
		posx=x;
		posy=y;
		
		if (destination=true){
		picture.translateTo(posx,posy);
		destination=false;
		}
//		translateTo(posx,posy);
//		if(EZInteraction.isKeyDown('s')){
//			setImagePosition(x,y++);
//		}
//		if(EZInteraction.isKeyDown('w')){
//			setImagePosition(x,y--);
//		}
//		if(EZInteraction.isKeyDown('a')){
//			setImagePosition(x--,y);
//		}
//		if(EZInteraction.isKeyDown('d')){
//			setImagePosition(x++,y);
//		}
	}
}
