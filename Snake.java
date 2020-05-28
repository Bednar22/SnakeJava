package snakev2package;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	
	private int[] snakeX = new int[100];
	private int[] snakeY = new int[100];
	private int snakeLength = 3;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	public  Snake(int x, int y) {
		this.snakeX[0] = x;
		this.snakeY[0] = y;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(snakeX[0], snakeY[0], 15, 15);
	}
	
}
