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
	static int width = 600;
	static int height = 600;
	
	public MasterController() throws Exception{
		ballSimulation = new BallSimulation();
		ballView = new BallView();
	}
	
	public static void main(String[] args) throws Exception {
		
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        
        Frame frame = new Frame("Ball");
        frame.setSize(MasterController.width, MasterController.height);
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
		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// TODO Auto-generated method stub
		
	}
}
