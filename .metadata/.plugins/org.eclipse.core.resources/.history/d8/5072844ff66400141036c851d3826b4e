package view;

public class View {
	private Camera camera;
	
	public View(int width, int height){
		camera = new Camera();
		camera.setScale(width, height);
	}
	
	public void viewWhiteSideVisualCoordinates(int x, int y, int width, int height){
		camera.toWhiteSideVisualCoordinates(x, y);
		System.out.println(camera.getVisualX());
		System.out.println(camera.getVisualY());
	}
	
	public void viewBlackSideVisualCoordinates(int x, int y){
		camera.toBlackSideVisualCoordinares(x, y);
		System.out.println(camera.getVisualX());
		System.out.println(camera.getVisualY());
	}
}
