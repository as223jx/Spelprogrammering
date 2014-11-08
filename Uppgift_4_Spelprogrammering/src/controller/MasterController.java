package controller;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import com.jogamp.opengl.util.FPSAnimator;

import model.BallSimulation;
import view.BallView;

public class MasterController implements GLEventListener {
	private static BallSimulation ballSimulation;
	private static BallView ballView;
	private long previousTime;
	
	public MasterController() throws Exception{
		ballSimulation = new BallSimulation();
		ballView = new BallView();
	}
	
	public static void main(String[] args) throws Exception {
		
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        
        Frame frame = new Frame("Ball");
        frame.setSize(BallView.width, BallView.height);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new MasterController());

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
	}


    @Override
    public void display(GLAutoDrawable drawable) {
    	long currentTime = System.currentTimeMillis();
        
    	update((float)((currentTime - previousTime) / 1000.0f), drawable);
        
        
        previousTime = currentTime;
    }
    
	public void update(float timeElapsed, GLAutoDrawable drawable) {
		//Change model state
		ballSimulation.update(timeElapsed);
		
		//Generate output
		ballView.render(drawable);
	}

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    	reshape(drawable, 0, 0 , BallView.width, BallView.height);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    	//view.reshape(drawable, x, y, w, h);
    	previousTime = System.currentTimeMillis();
    }
    
}
