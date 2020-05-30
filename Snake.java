package snakev2package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import snakev2package.Game.STATE;

public class Snake {
	
	private int[] snakeX = new int[100];
	private int[] snakeY = new int[100];
	
	private int snakeSize = 10;
	private int snakeLength = 3;
	
	
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	private boolean dead=false;
	
	private Random random = new Random();
	
	public Snake() {
		setRandomStart();
	}
	
	public void tick() {
		
		
		// MOVING RIGHT
		if(!boundColision() && !colisionWithSelf() ) {		
		
		if(right) {
					for(int i = snakeLength-1; i>=0; i-- ) {
						snakeY[i+1] = snakeY[i];
					}
					
					for(int i = snakeLength; i>=0; i-- ) {
						if(i==0) {
							snakeX[i] = snakeX[i] + snakeSize;
						} else {
							snakeX[i] = snakeX[i-1];
						}
					}
				
				}
				
				// MOVING LEFT
				if(left) {
					for(int i = snakeLength-1; i>=0; i-- ) {
						snakeY[i+1] = snakeY[i];
					}
					
					for(int i = snakeLength; i>=0; i-- ) {
						if(i==0) {
							snakeX[i] = snakeX[i] - snakeSize;
						} else {
							snakeX[i] = snakeX[i-1];
						}
						
					}
				
				}
				
				// MOVING DOWN
				if(down) {
					for(int i = snakeLength-1; i>=0; i-- ) {
						snakeX[i+1] = snakeX[i];
					}
					
					for(int i = snakeLength; i>=0; i-- ) {
						if(i==0) {
							snakeY[i] = snakeY[i] + snakeSize;
						} else {
							snakeY[i] = snakeY[i-1];
						}
					}
				
				}
				
				// MOVING UP
				if(up) {
					for(int i = snakeLength-1; i>=0; i-- ) {
						snakeX[i+1] = snakeX[i];
					}
					
					for(int i = snakeLength; i>=0; i-- ) {
						if(i==0) {
							snakeY[i] = snakeY[i] - snakeSize;
						} else {
							snakeY[i] = snakeY[i-1];
						}
					}
				
				}
		} else if(boundColision() || colisionWithSelf()){
			Game.state = STATE.GAMEOVER;
		}
		
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < snakeLength; i++ ) {
			g.setColor(Color.green);
			g.fillRect(snakeX[i], snakeY[i] , snakeSize, snakeSize);
			g.setColor(Color.red);
			g.drawRect(snakeX[i], snakeY[i] , snakeSize, snakeSize);
		}
	}
	
	private boolean colisionWithSelf() {
		for(int i = 1; i<snakeLength; i++) {
			if((snakeX[0]==snakeX[i]) && (snakeY[0] == snakeY[i])) {
				left=false;
				right=false;
				up=false;
				down=false;
				return true;
			}
		}
		return false;
	}
	
	public void increaseLength() {
		snakeLength+=1;
	}
	
	public int getHeadX() {
		return snakeX[0];
	}
	
	public int getHeadY() {
		return snakeY[0];
	}
	
	public void isDead() {
		if(dead == true) {
			Game.state = STATE.GAMEOVER;
		}
	}
	
	
	public void setRandomStart() {
		snakeX[0] = (random.nextInt(58)+1) * snakeSize; 
		snakeY[0] = (random.nextInt(49)+10) * snakeSize;
		snakeX[1] = snakeX[0] - snakeSize;
		snakeY[1] = snakeY[0];
		snakeX[2] = snakeX[1] - snakeSize;
		snakeY[2] = snakeY[0];
		snakeLength = 3;
	}
	
	public boolean boundColision() {
		if(snakeX[0]<0) { //|| snakeX[0]>590 || snakeY[0] < 100 || snakeY[0] > 590) {
			snakeX[0]+=snakeSize;
			right = false;
			left = false;
			up = false;
			down = false;
			return true;
		}
		
		if(snakeX[0]>600-snakeSize) { 
			snakeX[0]-=snakeSize;
			right = false;
			left = false;
			up = false;
			down = false;
			return true;
		}
		
		if(snakeY[0]<100) { 
			snakeY[0]+=10;
			right = false;
			left = false;
			up = false;
			down = false;
			return true;
		}
		
		if(snakeY[0]>600 - snakeSize) { 
			snakeY[0]-=snakeSize;
			right = false;
			left = false;
			up = false;
			down = false;
			return true;
		}
		return false;
	}
	
	
	
	
	public void moveRight2() {
		right = true;
		if(left == false) {
			right = true;
		} else {
			right = false;
			left = true;
		}
		up = false;
		down = false;
	}
	
	public void moveLeft2() {
		left = true;
		if(right == false) {
			left = true;
		} else {
			left = false;
			right = true;
		}
		up = false;
		down = false;
	}

	public void moveUp2() {
		up = true;
		if(down == false) {
			up = true;
		} else {
			up = false;
			down = true;
		}
		left = false;
		right = false;
	}
	
	public void moveDown2() {
		down = true;
		if(up == false) {
			down = true;
		} else {
			down = false;
			up = true;
		}
		left = false;
		right = false;
	}
	

} // end of class
