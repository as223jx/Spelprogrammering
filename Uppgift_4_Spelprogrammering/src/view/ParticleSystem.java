package view;

import java.util.Random;

import javax.media.opengl.GLAutoDrawable;

public class ParticleSystem {
	
	private static final float MAX_TIME = 3;
	private SplitterParticle particles[];
	private int NUM_PARTICLES = 100;
	private float totalTime = 0;
	
	ParticleSystem() {
		particles = new SplitterParticle[NUM_PARTICLES];
		float startPosX = 100;
		float startPosY = 100;
		
		spawnNewSystem(startPosX, startPosY);
	}

	private void spawnNewSystem(float startPosX, float startPosY) {
		Random rand = new Random();
		
		for(int i = 0; i < NUM_PARTICLES; i++) {
			float vx = (rand.nextFloat() - 0.5f) * 1000;
			float vy = (rand.nextFloat() - 0.5f) * 1000;
			particles[i] = new SplitterParticle(startPosX, startPosY, vx, vy);
		}
	}
	
	public void updateAndDraw(GLAutoDrawable drawable, BallView view, float timeElapsed) {
		update(timeElapsed);
		draw(drawable, view);
	}

	private void draw(GLAutoDrawable drawable, BallView view) {
		view.setParticleTexture();
		for(int i = 0; i < NUM_PARTICLES; i++) {
			particles[i].draw(drawable, view);
		}
		
	}

	private void update(float timeElapsed) {
		totalTime += timeElapsed;
		for(int i = 0; i < NUM_PARTICLES; i++) {
			particles[i].update(timeElapsed);
		}
		if(totalTime > MAX_TIME) {
			totalTime = 0;
			spawnNewSystem(100, 100);
		}
	}
	
}
