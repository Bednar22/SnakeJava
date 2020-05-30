package snakev2package;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MainMenu {

	public static Font pixelled;
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 125, 250 , 250 , 50);
	public Rectangle scoresButton = new Rectangle(Game.WIDTH / 2 - 125, 325 , 250 , 50);
	public Rectangle optionsButton = new Rectangle(Game.WIDTH / 2 - 125, 400 , 250 , 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 125, 475 , 250 , 50);
	
	private BufferedImageLoader loader = new BufferedImageLoader();
	private BufferedImage snakeMenu = null;
	

	public static Color playColor = Color.white; 
	public static Color scoresColor= Color.white;
	public static Color optionsColor = Color.white;
	public static Color quitColor = Color.white;
	
	public MainMenu() {
		try{
			pixelled = Font.createFont(Font.TRUETYPE_FONT, new File("Lemiesz.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Lemiesz	.ttf")));
			} catch(IOException | FontFormatException e) {
				
			}
		
		try {
			snakeMenu = loader.scale(loader.loadImage("/snakePrzerobka.png"), 250, 200);
		} catch(IOException e) {
			
		}
				
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.drawImage(snakeMenu, 175, 25, null);
		
		g.setColor(playColor);
		g.setFont(pixelled.deriveFont(32f));
		g.drawString("PLAY", Game.WIDTH / 2 - 50, 290 );
		g2d.draw(playButton);
		
		g.setColor(scoresColor);
		g.drawString("SCORES", Game.WIDTH / 2 - 75, 365 );
		g2d.draw(scoresButton);
		
		g.setColor(optionsColor);
		g.drawString("OPTIONS", Game.WIDTH / 2 - 85, 440 );
		g2d.draw(optionsButton);
		
		g.setColor(quitColor);
		g.drawString("QUIT", Game.WIDTH / 2 - 50, 515 );
		g2d.draw(quitButton);
		
	}
	
	
	
	
}
