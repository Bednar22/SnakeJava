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
		foodX  = (random.nextInt(57)+1) * 10;
		foodY  = (random.nextInt(49)+10) * 10;

	}
	
	public int getFoodX() {
		return foodX;
	}
	
	public int getFoodY() {
		return foodY;
	}
	
}
