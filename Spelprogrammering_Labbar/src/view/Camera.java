package view;

public class Camera {
	private int visualX;
	private int visualY;
	private static int scale = 64;
	private static int borderSize = 64;
	
	Camera(){
	}
	public void toVCoordinates(int x, int y){
		visualX = x*scale+borderSize;
		visualY = y*scale+borderSize;
	}
	
	public int getVisualX(){
		return visualX;
	}
	
	public int getVisualY(){
		return visualY;
	}
}
