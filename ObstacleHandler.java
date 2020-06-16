package snakev2package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleHandler {

	private Random random = new Random();
	//private int obstacleAmmount = 4;
	public static List<Obstacle> obstacles = new ArrayList<Obstacle>(9);

	public ObstacleHandler() {
		spawnObstacles();	
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {		
		
		for(int i=0; i<9; i++) {
			
			g.setColor(Color.red);
			if(obstacles.get(i).getOrientation() == 0) {
				g.fillRect(obstacles.get(i).getStartX(), obstacles.get(i).getStartY() , obstacles.get(i).getLength(), Snake.snakeSize);
			} else if(obstacles.get(i).getOrientation() == 1) {
				g.fillRect(obstacles.get(i).getStartX(), obstacles.get(i).getStartY() , Snake.snakeSize, obstacles.get(i).getLength());
			}

		}
		
	}

	public void spawnObstacles() {		
		int[] sectorX = {1, 20, 40, 1, 20, 40, 1, 20, 40};
		int[] sectorY = {11, 11, 11, 27, 27, 27, 43, 43, 43};
		
		
		for(int i = 0; i<9; i++) {
			Obstacle tmp = new Obstacle();
			tmp.setOrientation(random.nextInt(2));
			tmp.setStartX((random.nextInt(20)+sectorX[i]) * 10);
			tmp.setStartY((random.nextInt(16)+sectorY[i]) * 10);
			tmp.setLength((random.nextInt(10)+4) * 10);
			obstacles.add(tmp);
		}
	}
	
}
