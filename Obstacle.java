package snakev2package;

public class Obstacle {

	private int startX;
	private int startY;
	private int obstLength;
	private int orientation; // 0 - poziom, 1 - pion
	
	public Obstacle() {
		
	}
	
	public void tick() {
		
	}
	
	
	//setters
	public void setOrientation(int newOrientation) {
		orientation = newOrientation;
	}
	
	public void setStartX(int newStartX) {
		startX = newStartX;
	}
	
	public void setStartY(int newStartY) {
		startY = newStartY;
	}
	
	public void setLength(int newLength) {
		obstLength = newLength;
	}
	
	//getters
	public int getOrientation() {
		return orientation;
	}
	
	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}

	public int getLength() {
		return obstLength;
	}
	
}
