package view;

import javax.media.opengl.GLAutoDrawable;

public class SplitterParticle {
	float x = 100;
	float y = 100;
	float vx = 0;
	float vy = 0;
	float ax = 0;
	float ay = 1000;
	float size = 0;
	
	public SplitterParticle(float x, float y, float vx, float vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		
	}
	
	public void draw(GLAutoDrawable drawable, BallView view) {
		//view.setParticleTexture();
		view.drawBall(drawable, x, y, size, size);
	}

	public void update(float timeElapsed) {

		vx = vx + timeElapsed * ax;
		vy = vy + timeElapsed * ay;
		
		x = x + timeElapsed * vx;
		y = y + timeElapsed * vy;
		System.out.println(x + " " + y);
		
		
		size += timeElapsed * 10;
	}
}
