 package snakev2package;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	private Color defaultColor = Color.white;
	private Color diffChoice = Color.red;
	
	
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
		
		//g.drawRect(Game.WIDTH/2 - 150, 425, 300, 50);
		if(Game.state == Game.state.SCOREBOARD) {
			if((mx>= Game.WIDTH/2-150) && (mx<= Game.WIDTH/2+150)) {
				if((my >= 425)&&(my <= 475)) {
					Game.state = Game.STATE.MENU;
				}
			}
		}
				
		if(Game.state == Game.state.OPTIONS) {
			if((mx>= Game.WIDTH/2-150) && (mx<= Game.WIDTH/2+150)) {
				if((my >= 425)&&(my <= 475)) {
					Game.state = Game.STATE.MENU;
				}
			}
			
			if((my >= 200)&&(my <= 230)) {
				if((mx>= Game.WIDTH/2-185) && (mx<= Game.WIDTH/2 - 110)) {
					//snake speed ez
					Game.snakeSpeed = 4;
					Options.colorEasy = diffChoice;
					Options.colorMedium = defaultColor;
					Options.colorHard = defaultColor;
				} else if((mx>= Game.WIDTH/2-65) && (mx<= Game.WIDTH/2 +45)) {
					//snake speed medium
					Game.snakeSpeed = 3;
					Options.colorEasy = defaultColor;
					Options.colorHard = defaultColor;
					Options.colorMedium = diffChoice;
				} else if((mx>= Game.WIDTH/2+95) && (mx<= Game.WIDTH/2+175)) {
					//snake speed hard
					Game.snakeSpeed = 2;
					Options.colorEasy = defaultColor;
					Options.colorMedium = defaultColor;
					Options.colorHard = diffChoice;
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
