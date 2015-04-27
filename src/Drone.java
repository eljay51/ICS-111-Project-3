import java.util.Random;

// The drone class will control the artificial intelligence of the drone for the Drone vs Chicken program
// You will begin development with the go() member function.

public class Drone extends Agent {


	Chicken[] chickens;			// This array contains all the chickens
	int numberOfChickens;		// This tells you how many chickens there are
	
	// Constructor for drone
	//image is the path to image 
	Drone(String image) {
		
		// Place the drone at random locations
		Random randomGenerator = new Random();
		x = randomGenerator.nextInt(1024);
		y = randomGenerator.nextInt(768);
		picture = EZ.addImage(image, x, y);
	}
	
	// Assign array of chickens to drone
	void introduceChickensToDrone(Chicken[] chk, int nchickens){
		chickens = chk;
		numberOfChickens = nchickens;
	}
	
	void setImagePosition(int posx, int posy) {
		super.setImagePosition(posx, posy);
	//	picture.rotateBy(1);
	}
	
	// Here is where you begin to put the intelligence for your drones.
	// Call this repeatedly to keep the drone updated.
	void go(){
		setImagePosition(x, y);
	}
	
	void move(int newX, int newY){
		//if newX - current X is less than 1 move up (subtract from x) 
		if((newX - x) < 1)
		{	
			//if currentX does not equal newX keep moving.
			if(!(x == newX))
			{
				setImagePosition(x--, y);
			}
			//if currentX equals newX stop.
			else
			{
				setImagePosition(x, y);
			}
		}
		//if newX - current X is greater than 1 move down (add to x) 
		else
		{
			//if currentX does not equal newX keep moving.
			if(!(x == newX))
			{
				setImagePosition(x++, y);
			}
			//if currentX equals newX stop.
			else
			{
				setImagePosition(x, y);
			}
		}
		
		//if newY - current Y is less than 1 move up (subtract from y) 
		if(((newY - y) < 1))
		{
			//if currentY does not equal newY keep moving.
			if(!(y == newY))
			{
				setImagePosition(x, y--);
			}
			//if currentY equals newY stop.
			else
			{
				setImagePosition(x, y);
			}
		}
		//if newX - current X is greater than 1 move down (add to x) 
		else
		{
			//if currentY does not equal newY keep moving.
			if(!(y == newY))
			{
				setImagePosition(x, y++);
			}
			//if currentY equals newY stop.
			else
			{
				setImagePosition(x, y);
			}
		}
	}
}