package view;

import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

import java.io.File;
import java.io.IOException;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;

import model.Ball;
import model.BallSimulation;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class BallView {
	private Camera camera;
	private Texture texture;
	public static int width = 700;
	public static int height = 700;
	private ParticleSystem particles;
	
	public BallView(){
		camera = new Camera();
		//camera.setScale(width, height);
		particles = new ParticleSystem();
	}
	
	public void render(GLAutoDrawable drawable, float timeElapsed) {
		camera.setScale(width, height);
		clearScreen(drawable);
		displayBall(drawable, BallSimulation.ball);
		drawFrame(drawable);
		particles.updateAndDraw(drawable, this, timeElapsed);
	}
	
	private void drawFrame(GLAutoDrawable drawable){
		try {
			texture = TextureIO.newTexture(new File("redbox.png"), false);
		} catch (GLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		float vx = 0;
		float vy = 0;
		float w = camera.getScale();
		float h = camera.getScale();
		for(int i = 0; i < (Camera.lvlHeight +2); i ++){

			for(int y = 0; y < (Camera.lvlWidth +2); y ++){
				if(i == 0){
					vx = camera.getVisualX(y) - w;
					vy = camera.getVisualY(i) - h;
					drawBall(drawable, vx, vy, w, h);
				}
				else if(i == Camera.lvlHeight + 1){
					vx = camera.getVisualX(y) - w;
					vy = camera.getVisualY(i) - h;
					drawBall(drawable, vx, vy, w, h);
				}
				else{
					vx = camera.getVisualX(Camera.lvlWidth);
					vy = camera.getVisualY(i) - h;
					drawBall(drawable, vx, vy, w, h);
					vx = camera.getVisualX(0) - w;
					drawBall(drawable, vx, vy, w, h);
				}
			}
		}
	}
	
	public void setParticleTexture(){
		try {
			texture = TextureIO.newTexture(new File("spark.png"), false);
		} catch (GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void displayBall(GLAutoDrawable drawable, Ball ball) {

		float vx = camera.getVisualX(ball.centerX);
		float vy = camera.getVisualY(ball.centerY);
		float vBallSize = (ball.diameter * camera.getScale());
		try {
			texture = TextureIO.newTexture(new File("ball2.png"), false);
		} catch (GLException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
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
	
	public void reshape(GLAutoDrawable drawable, float x, float y, float w, float h){
		GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();
        
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity(); // reset
        glu.gluOrtho2D (0.0, w, h, 0);  // define drawing area
        
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
	}
	
	void drawBall(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(1, 1, 1);
		gl.glBindTexture(GL.GL_TEXTURE0, texture.getTarget());
		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(x,      y);
		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(x + w, y);
		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(x + w, y + h);
		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(x,      y + h);
	
		gl.glEnd();
		gl.glDisable(GL.GL_TEXTURE_2D);
	}
	
	// Ska känna till BallSimulation för att kunna rita ut bollen och spelarean.
}
