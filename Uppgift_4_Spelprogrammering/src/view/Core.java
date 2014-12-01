package view;

import java.io.File;
import java.io.IOException;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Core {
	private Texture texture;
	
	void loadTextures() throws GLException, IOException{
		if (texture == null)
			texture = TextureIO.newTexture(new File("redbox.png"), false);
	}
	
	public void setFrameTexture(){
		try {
			texture = TextureIO.newTexture(new File("redbox.png"), false);
		} catch (GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBallTexture(){
		try {
			texture = TextureIO.newTexture(new File("ball2.png"), false);
		} catch (GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawBall(GLAutoDrawable drawable, float x, float y, float w, float h) {
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
}
