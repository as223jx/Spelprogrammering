package view;

public class Camera {
	private int width;
	private int height;
	public static int borderSize;
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
		borderSize = width / 6;
//		borderSize = height/10;
//		if(this.width<this.height)
//		{
//			borderSize = width/10;
//		}

		int scaleX = (this.width-borderSize*2) / lvlWidth;
		int scaleY = (this.height-borderSize*2) / lvlHeight;
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}
	}
	
	public int getScale(){
		return scale;
	}
	
	public float getVisualX(float x){
		visualX = x*scale+borderSize;
		return visualX;
	}
	
	public float getVisualY(float y){
		visualY = y*scale+borderSize;
		return visualY;
	}
}
