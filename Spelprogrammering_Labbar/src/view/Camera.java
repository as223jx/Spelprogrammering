package view;

public class Camera {
	private int width;
	private int height;
	private int visualX;
	private int visualY;
	private static int lvlWidth = 8;
	private static int lvlHeight = 8;
	private static int scale;
	private int borderSize;
	private int blackSideStart;
	
	Camera(){
	}
	
	// S�tter skalan beroende p� bredd och h�jd p� spelplanen.
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
	
	public void toWhiteSideVisualCoordinates(int x, int y){
		visualX = x*scale+borderSize;
		visualY = y*scale+borderSize;
	}
	
	// Om spelaren spelar med svarta pj�ser s� multiplicerar jag skalan med 7 f�r att f� f�rsta svarta pj�sens plats.
	public void toBlackSideVisualCoordinares(int x, int y){
		blackSideStart = scale*7;
		visualX = x*(-scale)+blackSideStart+borderSize;
		visualY = y*(-scale)+blackSideStart+borderSize;
	}
	
	public int getVisualX(){
		return visualX;
	}
	
	public int getVisualY(){
		return visualY;
	}
}
