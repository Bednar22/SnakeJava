package snakev2package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileNotFoundException;

public class ScoreboardManager {

	private String line1 = " ";
	private String line2 = " ";
	private String line3 = " ";
		
	public static String[] lines = {" ", " ", " "};
	private int[] scores = {0,0,0};
	
	private int i = 1; //index
	private boolean highscoreSaved = false;
	
	public static Color backMenu = Color.white;
	
	File scoreFile = new File("highscores.txt");
	Font font = MainMenu.pixelled;
	public ScoreboardManager() {
		getHigh2();
	}
	
	void tick() {
		if(highscoreSaved == true) {
			highscoreSaved = false;
		}
	}
	
	void render(Graphics g){
		
		g.setColor(Color.red);
		g.setFont(font.deriveFont(28f));
		g.drawString("Scoreboard", Game.WIDTH/2-125, 100);
		
		g.setColor(Color.white);
		g.setFont(font.deriveFont(24f));
		g.drawString(lines[0], Game.WIDTH / 2 - 75, 150 );
		
		g.setColor(Color.white);
		g.drawString(lines[1], Game.WIDTH / 2 - 75, 200 );
		
		g.setColor(Color.white);
		g.drawString(lines[2], Game.WIDTH / 2 - 75, 250 );
		
		g.setColor(backMenu);
		g.setFont(font.deriveFont(28f));
		g.drawRect(Game.WIDTH/2 - 150, 425, 300, 50);
		g.drawString("BACK TO MENU", Game.WIDTH/2 - 125, 460);
	}
	
	public void getHigh2() {
		
		FileReader readFile = null;
		BufferedReader reader = null;
		try {
			readFile = new FileReader("highscores.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		reader = new BufferedReader(readFile);
		try {
			lines[0] = reader.readLine();
			lines[1] = reader.readLine();
			lines[2] = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null)
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		this.scoresIntoInts();
	}
	
	
	public void saveScores2() {
		
		if(!scoreFile.exists()) {
			
			try {
				scoreFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileWriter writeFile = null;
		BufferedWriter writer = null;
		try {
			writeFile = new FileWriter(scoreFile);
			writer = new BufferedWriter(writeFile);
			writer.write(lines[0]);
			writer.newLine();
			writer.append(lines[1]);
			writer.newLine();
			writer.append(lines[2]);
		} catch(Exception e){
			
			
		} finally {
			if(writer != null ) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		this.scoresIntoInts();
		
		
	}
	
	public void saveScore() {
		
		      if (scoreFile.exists()==true) {
		    	  try {
		    		  FileWriter myWriter = new FileWriter("highscores.txt");
		      
		    		  for(String line : lines) {
		    			  myWriter.write(line);
		    		  }
		    		  myWriter.close();
		    	  } catch (IOException e) {
		    		  e.printStackTrace();
		    	  	}
		      }
	}
	
	public void scoresIntoInts() {
		scores[0] = Integer.parseInt((lines[0].split(":")[1]));
		scores[1] = Integer.parseInt((lines[1].split(":")[1]));
		scores[2] = Integer.parseInt((lines[2].split(":")[1]));
	}
	
public void inputHighscore() {
		
		if(highscoreSaved == false) {
			if(Game.score > scores[0]) {
				String name = JOptionPane.showInputDialog("Best Score! Type your nick:");	
				lines[0] = name + ":" + Game.score;  
			
			} else if((Game.score <= scores[0]) && (Game.score > scores[1])) {
				String name = JOptionPane.showInputDialog("2nd best score! Type your nick:");
				lines[1] = name + ":" + Game.score;
			
			} else if((Game.score <= scores[1]) && (Game.score > scores[2])) {
				String name = JOptionPane.showInputDialog("Top 3 Highscore! Type your nick:");
				lines[2] = name + ":" + Game.score;
			}
			highscoreSaved = true;
		}
	}


	
} // end of class
