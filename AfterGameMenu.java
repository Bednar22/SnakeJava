package snakev2package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AfterGameMenu {

	public Rectangle playAgainButton = new Rectangle(Game.WIDTH / 2 - 125, 350 , 250 , 50);
	public Rectangle backtoMenuButton = new Rectangle(Game.WIDTH / 2 - 125, 450 , 250 , 50);
	Font font = MainMenu.pixelled;
	
	private BufferedImageLoader loader = new BufferedImageLoader();
	private BufferedImage gameover = null;
	public static Color playagainColor = Color.white;
	public static Color menuColor = Color.white;
	
	public AfterGameMenu() {
		
		try {
			gameover = loader.scale(loader.loadImage("/gameOver.jpg"), 300, 200);
		} catch(IOException e) {}
	}
	
	public void tick() {
	 
	}
	
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		
		g.drawImage(gameover, 150, 50, null);
		
		g.setFont(font.deriveFont(28f));
		
		g.setColor(Color.white);
		g.drawString("Score: " + Game.score, 225, 250);
		
		g.setColor(playagainColor);
		g2d.draw(playAgainButton);
		g.drawString("Play again", 195 , 385);
		
		g.setColor(menuColor);
		g2d.draw(backtoMenuButton);
		g.drawString("Menu", 250 , 485);
	}
	
}
