package snakev2package;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

public class MainMenu {

	private Font pixelled;
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 125, 150 , 250 , 50);
	public Rectangle scoresButton = new Rectangle(Game.WIDTH / 2 - 125, 250 , 250 , 50);
	public Rectangle optionsButton = new Rectangle(Game.WIDTH / 2 - 125, 350 , 250 , 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 125, 450 , 250 , 50);
	public MainMenu() {
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
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(pixelled.deriveFont(40f));
		g.setColor(Color.white);
		g.drawString("SNAKE", Game.WIDTH / 2 - 125, 100 );
		
		g.setFont(pixelled.deriveFont(32f));
		g.drawString("PLAY", Game.WIDTH / 2 - 60, 195 );
		g2d.draw(playButton);
		g.drawString("SCORES", Game.WIDTH / 2 - 95, 295 );
		g2d.draw(scoresButton);
		g.drawString("OPTIONS", Game.WIDTH / 2 - 105, 395 );
		g2d.draw(optionsButton);
		g.drawString("QUIT", Game.WIDTH / 2 - 60, 495 );
		g2d.draw(quitButton);
	}
}
