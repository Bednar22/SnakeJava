package snakev2package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Options {

	//render atributes
	public static Color backMenu = Color.white;
	public static Color colorEasy = Color.white;
	public static Color colorMedium = Color.red;
	public static Color colorHard = Color.white;
	Font font = MainMenu.pixelled;
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		//Speed options
		g.setFont(font.deriveFont(28f));
		g.setColor(Color.white);
		g.drawString("OPTIONS", Game.WIDTH/2 - 75, 100);
		
		
		g.setColor(Color.white);
		g.setFont(font.deriveFont(24f));
		g.drawString("SPEED", Game.WIDTH/2 - 50, 180);
		
		g.setColor(colorEasy);
		g.setFont(font.deriveFont(20f));
		g.drawString("EASY", Game.WIDTH/2 - 180, 222);
		g.drawRect(Game.WIDTH/2 - 185, 200, 75, 30);
		
		g.setColor(colorMedium);
		g.drawString("MEDIUM", Game.WIDTH/2 - 60, 222);
		g.drawRect(Game.WIDTH/2 - 65, 200, 110, 30);
		
		g.setColor(colorHard);
		g.drawString("HARD", Game.WIDTH/2+100 , 222);
		g.drawRect(Game.WIDTH/2+95 , 200, 80, 30);
		
		
		//back to menu
		g.setColor(backMenu);
		g.setFont(font.deriveFont(28f));
		g.drawRect(Game.WIDTH/2 - 150, 425, 300, 50);
		g.drawString("BACK TO MENU", Game.WIDTH/2 - 125, 460);
	}
	
}
