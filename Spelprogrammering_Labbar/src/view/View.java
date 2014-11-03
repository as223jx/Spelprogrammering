package view;

public class View {
	private Camera camera;
	
	public View(){
		camera = new Camera();
	}
	
	public void viewVisualCoordinates(int x, int y){
		camera.toVCoordinates(x, y);
		System.out.println(camera.getVisualX());
		System.out.println(camera.getVisualY());
	}
}
