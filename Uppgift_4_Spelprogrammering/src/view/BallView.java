package view;

import java.io.File;
import java.io.IOException;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import model.Ball;
import model.BallSimulation;

public class BallView {
	private Camera camera;
	private Texture texture;
	public static int width = 600;
	public static int height = 600;
	
	public BallView(){
		camera = new Camera();
		//camera.setScale(width, height);
	}
	
	public void render(GLAutoDrawable drawable) {
		try{
			loadTextures();
		} catch (GLException | IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		clearScreen(drawable);
		displayBall(drawable, BallSimulation.ball);
	}
	
	private void displayBall(GLAutoDrawable drawable, Ball ball) {
		camera.setScale(width, height);
		float vx = camera.getVisualX(ball.centerX);
		float vy = camera.getVisualY(ball.centerY);
		float vBallSize = (ball.diameter * camera.getScale());
		
		//System.out.println(vx + " " + vy + " " + " " + vBallSize + " " + camera.getScale());
		
		drawBall(drawable, vx - vBallSize / 2.0f, vy - vBallSize / 2.0f, vBallSize, vBallSize);
	}
	
	void loadTextures() throws GLException, IOException{
		if (texture == null)
			texture = TextureIO.newTexture(new File("redbox.png"), false);
	}
	
	public void clearScreen(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
	}

	void drawBall(GLAutoDrawable drawable, float x, float y, float w, float h) {
		System.out.println("x: " + x + " y: " + y + " w: " + w + " h: " + h);
		GL2 gl = drawable.getGL().getGL2();
		//gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(255, 0, 255);
		//gl.glBindTexture(GL.GL_TEXTURE0, texture.getTarget());
		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(x,      y);
		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(x + w, y);
		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(x + w, y + h);
		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(x,      y + h);
	
		gl.glEnd();
		//gl.glDisable(GL.GL_TEXTURE_2D);
	}
	
	// Ska känna till BallSimulation för att kunna rita ut bollen och spelarean.
}
