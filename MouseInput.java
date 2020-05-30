 package snakev2package;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
				
 
		if(Game.state == Game.STATE.MENU) {
			if((mx>= Game.WIDTH / 2 - 125) && (mx<= Game.WIDTH / 2 +  125)) {
			
				if((my >= 250)&&(my <= 300)) {
					Game.state = Game.STATE.GAMEPLAY;
				}
				if((my >= 325)&&(my <= 375)) {
					Game.state = Game.STATE.SCOREBOARD;
				}
				if((my >= 400)&&(my <= 450)) {
					Game.state = Game.STATE.OPTIONS;
				}
				if((my >= 475)&&(my <= 525)) {
					System.exit(1);
				}
			}
		}
		
//		public Rectangle playAgainButton = new Rectangle(Game.WIDTH / 2 - 125, 350 , 250 , 50);
//		public Rectangle backtoMenuButton = new Rectangle(Game.WIDTH / 2 - 125, 450 , 250 , 50);
		
		if(Game.state==Game.STATE.GAMEOVER) {
			if((mx>= 175) && (mx<= 425)) {
				if((my >= 350)&&(my <= 400)) {
					Game.state = Game.STATE.GAMEPLAY;
				}
				if((my >= 450)&&(my <= 500)) {
					Game.state = Game.STATE.MENU;
				}
			}
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
