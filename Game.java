package snakev2package;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600; 
	public String TITLE = "Snake"; 
	
	private boolean running = false;
	private Thread thread;
	
	public static enum STATE{
		MENU,
		GAMEPLAY,
		SCOREBOARD,
		OPTIONS,
	};
	
	public static STATE state = STATE.MENU;
	
	private BufferedImage image = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
	
	private InGameInterface ingameInterface;
	private Snake snake;
	private Food food;
	private MainMenu mainMenu;
	
	private BufferedImage snakeMenu = null;
	
	public void init() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			snakeMenu = loader.loadImage("/snakePrzerobka.png");
		} catch(IOException e) {
			
		}
		requestFocus();
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
		
		ingameInterface = new InGameInterface();
		snake = new Snake();
		food = new Food();
		mainMenu = new MainMenu();
	}
	
	
	private synchronized void start() {
		if(running) {
			return ;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running) {
			return;
		}
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	@Override
	public void run() {
		
		init();
		long lastTime = System.nanoTime();
		final double ticksAmmount = 30.0;
		double ns = 2000000000 / ticksAmmount;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running) { //main game loop
		
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta>=1) {
				tick();
				updates++;
				delta --;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + "Tics, " + frames + "FPS" );
				updates =0;
				frames =0;
			}
			
		}
		stop();
	}
	
	private void tick() {
	
		if(state==STATE.GAMEPLAY) {
			snake.tick();
			isAte();
			food.tick();
			ingameInterface.tick();
		}
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////////////////////////////////////
		
		g.drawImage(mainMenu.img, 100, 100,null);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(state == STATE.GAMEPLAY) {
			ingameInterface.render(g);
			snake.render(g);
			food.render(g);
		} else if(state==STATE.MENU) {
			mainMenu.render(g);
		}
		//////////////////////////////////////////////////////////////////////
		g.dispose();
		bs.show();
		
	}
	
	public void isAte() {
		if((snake.getHeadX()==food.getFoodX()) && (snake.getHeadY()==food.getFoodY())){
			ingameInterface.setScore();
			food.generateRandomFood();
			snake.increaseLength();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(state==STATE.GAMEPLAY) {
			if(key==KeyEvent.VK_RIGHT) {
				snake.moveRight2();
			} else if(key==KeyEvent.VK_LEFT) {
				snake.moveLeft2();
			} else if(key==KeyEvent.VK_UP) {
				snake.moveUp2();
			} else if(key==KeyEvent.VK_DOWN) {
				snake.moveDown2();
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		game.start();
	}

	
}
