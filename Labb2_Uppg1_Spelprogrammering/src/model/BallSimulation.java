package model;

public class BallSimulation {
	public static Ball ball;
	
	public BallSimulation(){
		ball = new Ball();
	}
	
	public void update(Float timeElapsed){
		ball.update(timeElapsed);
	}
	
	// Innehåller förflyttnings- och kollisionskoden.
}
