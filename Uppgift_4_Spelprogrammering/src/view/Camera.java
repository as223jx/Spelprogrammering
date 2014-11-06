package view;

public class Camera {
	private int width;
	private int height;
	private int borderSize;
	private int scale;
	private int visualX;
	private int visualY;
	private int logicX;
	private int logicY;
	private static int lvlWidth = 1;
	private static int lvlHeight = 1;
	
	public Camera(){
		
	}
	
	public void setScale(int width, int height){
		this.width = width;
		this.height = height;
		
		borderSize = height/10;
		if(this.width<this.height)
		{
			borderSize = width/10;
		}

		int scaleX = (this.width-borderSize*2) / lvlWidth;
		int scaleY = (this.height-borderSize*2) / lvlHeight;
		
		scale = scaleX;
		if (scaleY < scaleX) {
			scale = scaleY;
		}
	}
	
	public void toVisualCoordinates(int x, int y){
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
