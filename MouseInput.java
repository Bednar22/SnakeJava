 package snakev2package;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	/*
	 * public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 125, 150 , 250 , 50);
	public Rectangle scoresButton = new Rectangle(Game.WIDTH / 2 - 125, 250 , 250 , 50);
	public Rectangle optionsButton = new Rectangle(Game.WIDTH / 2 - 125, 350 , 250 , 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 125, 450 , 250 , 50);
	 *  
	 *  */
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		

		if((mx>= Game.WIDTH / 2 - 125) && (mx<= Game.WIDTH / 2 +  125)) {
			
			if((my >= 150)&&(my <= 200)) {
				Game.state = Game.STATE.GAMEPLAY;
			}
			if((my >= 250)&&(my <= 300)) {
				Game.state = Game.STATE.SCOREBOARD;
			}
			if((my >= 350)&&(my <= 400)) {
				Game.state = Game.STATE.OPTIONS;
			}
			
			if((my >= 450)&&(my <= 500)) {
				System.exit(1);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
