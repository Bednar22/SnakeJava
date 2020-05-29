 package snakev2package;

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
