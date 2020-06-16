package snakev2package;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMovement implements MouseMotionListener {

	private Color defaultColor = Color.white;
	private Color onHover = new Color(255, 55, 55);
	private Color onHoverMainMenu = new Color(51, 153, 255);
	private Color lastColor = null;
	private boolean colored = false;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.state == Game.STATE.MENU) {
			if((mx>= Game.WIDTH / 2 - 125) && (mx<= Game.WIDTH / 2 +  125)) {
				if((my >= 250)&&(my <= 300)) {
					MainMenu.playColor = onHoverMainMenu;
					colored = true;
				} else if((my >= 325)&&(my <= 375)) { 
					MainMenu.scoresColor = onHoverMainMenu;
					colored = true;
				} else if((my >= 400)&&(my <= 450)) {
					MainMenu.optionsColor = onHoverMainMenu;
					colored = true;
				} else if((my >= 475)&&(my <= 525)) {
					MainMenu.quitColor = onHoverMainMenu;
					colored = true;
				} else if(colored==true) {
					MainMenu.playColor = defaultColor;
					MainMenu.optionsColor = defaultColor;
					MainMenu.scoresColor = defaultColor;
					MainMenu.quitColor = defaultColor;
					colored = false;
				}
			} else if(colored==true) {
				MainMenu.playColor = defaultColor;
				MainMenu.optionsColor = defaultColor;
				MainMenu.scoresColor = defaultColor;
				MainMenu.quitColor = defaultColor;
				colored = false;
			}
		} 
		
		if(Game.state==Game.STATE.GAMEOVER) {
			if((mx>= 200) && (mx<= 400)) {
				if((my >= 375)&&(my <= 425)) {
					AfterGameMenu.playagainColor = onHover;
					colored = true;
				} else if((my >= 475)&&(my <= 525)) {
					AfterGameMenu.menuColor = onHover;
					colored = true;
				} else if(colored == true) {
					AfterGameMenu.playagainColor = defaultColor;
					AfterGameMenu.menuColor = defaultColor;
				}
			}else if(colored== true) {
				AfterGameMenu.playagainColor = defaultColor;
				AfterGameMenu.menuColor = defaultColor;
			}
		}

		//g.drawRect(Game.WIDTH/2 - 150, 425, 300, 50);
		
		if(Game.state==Game.STATE.SCOREBOARD) {
			if((mx>= Game.WIDTH/2 - 150) && (mx<= Game.WIDTH/2 + 150)) {
				if((my >= 425)&&(my <= 475)) {
					ScoreboardManager.backMenu = onHoverMainMenu;
					colored = true;
				} else if(colored == true) {
					ScoreboardManager.backMenu = defaultColor;
				}
			}else if(colored== true) {
				ScoreboardManager.backMenu = defaultColor;
			}
		}
		
		if(Game.state==Game.STATE.OPTIONS) {
			if((mx>= Game.WIDTH/2 - 150) && (mx<= Game.WIDTH/2 + 150)) {
				if((my >= 425)&&(my <= 475)) {
					Options.backMenu = onHoverMainMenu;
					colored = true;
				} else if(colored == true) {
					Options.backMenu = defaultColor;
				}
			}else if(colored== true) {
				Options.backMenu = defaultColor;
			}
		}
		
		
	}

}
