package model;

import view.Camera;

public class Ball {
	public float centerX = 4f;
	public float centerY = 4f;
	private float speedX = 5.0f;
	private float speedY = 10.0f;
	public float diameter = 1.0f;
	
	public Ball(){
	}
	
	public boolean update(float timeElapsedSeconds) {
		
		centerX = centerX + speedX * timeElapsedSeconds;
		
		if (centerX + diameter/2 > Camera.lvlWidth) {
			speedX = speedX * -1.0f;
		}
		if (centerX - diameter/2 < 0) {
			speedX = speedX * -1.0f;
		}
		
		centerY = centerY + speedY * timeElapsedSeconds;
		
		
		if (centerY - diameter/2 < 0) {
			speedY = speedY * -1.0f;
		}
		
		if (centerY + diameter/2 > Camera.lvlHeight) {
			speedY = speedY * -1.0f;
		}
		
		return false;
	}
}
