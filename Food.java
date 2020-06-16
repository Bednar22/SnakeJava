package snakev2package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food {

	private int foodX;
	private int foodY;
	
	public Food() {
		generateRandomFood();
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect(foodX, foodY , 10, 10);
		}
	
	public void generateRandomFood() {
		Random random = new Random();
		boolean freeSquare = false;
		
		while(freeSquare == false) {
			foodX  = (random.nextInt(57)+1) * 10;
			foodY  = (random.nextInt(49)+10) * 10;
			
			freeSquare = checkSpawn();
		}
		
	}
	
	private boolean checkSpawn() {
		
		for(Obstacle obstacle : ObstacleHandler.obstacles) {
			
			if(obstacle.getOrientation() == 0) {
				if((foodX >= obstacle.getStartX() && foodX <= obstacle.getStartX() + obstacle.getLength())
					&& (foodY == obstacle.getStartY())) {
					return false;
				}
			}
			
			if(obstacle.getOrientation() == 1) {
				if((foodY >= obstacle.getStartY() && foodY <= obstacle.getStartY() + obstacle.getLength())
					&& (foodX == obstacle.getStartX())) {
						return false;
				}
				
			}
			
		}
		return true;
		
	}
	
	public int getFoodX() {
		return foodX;
	}
	
	public int getFoodY() {
		return foodY;
	}
	
}
