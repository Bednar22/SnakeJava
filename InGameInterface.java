package snakev2package;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class InGameInterface {

	private int score = 0;
	Font pixelled;
	public InGameInterface() {
		
		try{
			pixelled = Font.createFont(Font.TRUETYPE_FONT, new File("Pixeled.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Pixeled.ttf")));
			} catch(IOException | FontFormatException e) {
				
			}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(1, 1,598 ,98 );
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(2, 2, 597, 97);
		
		
		g.setColor(Color.white);
		g.setFont(pixelled.deriveFont(10f));
		g.setFont(pixelled.deriveFont(10f));
		g.drawString("Score:" + this.score, 25 , 35);
		}
	
	public void setScore(){
		score+=1;
	}
	
} //end of InGameInterface class
