package view;

public class Camera {
	private int width;
	private int height;
	private int borderSize;
	private int scale;
	private float visualX;
	private float visualY;
	public static int lvlWidth = 8;
	public static int lvlHeight = 8;
	
	public Camera(){
		
	}
	
	public void setScale(int width, int height){

		this.width = width;
		this.height = height;
		System.out.println("Width: " + width + " Height: " + height);
		borderSize = height/10;
		if(this.width<this.height)
		{
			borderSize = width/10;
		}

		int scaleX = (this.width-borderSize*2) / lvlWidth;
		int scaleY = (this.height-borderSize*2) / lvlHeight;
		System.out.println("ScaleX: " + scaleX + " ScaleY: " + scaleY);
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}
	}
	
	public int getScale(){
		return scale;
	}
	
//	public void toVisualCoordinates(int x, int y){
//		visualX = x*scale+borderSize;
//		visualY = y*scale+borderSize;
//	}
	
	public float getVisualX(float x){
		visualX = x*scale+borderSize;
		System.out.println("VisualX: " + visualX);
		return visualX;
	}
	
	public float getVisualY(float y){
		visualY = y*scale+borderSize;
		System.out.println("VisualY: " + visualY);
		return visualY;
	}
}
