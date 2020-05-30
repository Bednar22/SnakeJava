package snakev2package;
import java.awt.Color;
import java.awt.Graphics;

public class InGameInterface {

	private int score = 0;
	public InGameInterface() {
		
	}
	
	public void tick() {
		Game.score = score;
	}
	
	public void render(Graphics g) {
	
		g.setColor(Color.WHITE);
		g.drawRect(1, 1,598 ,98 );
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(2, 2, 597, 97);
		
		g.setColor(Color.white);
		g.setFont(MainMenu.pixelled.deriveFont(15f));
		g.drawString("Score:" + this.score, 15 , 20);
		}
	
	
	public void setScore(){
		score+=1;
	}
	
	public void resetScore() {
		score = 0;
	}
	public int getScore() {
		return score;
	}
} //end of InGameInterface class
