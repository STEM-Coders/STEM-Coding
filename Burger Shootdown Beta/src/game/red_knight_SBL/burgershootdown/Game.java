package game.red_knight_SBL.burgershootdown;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import game.red_knight_SBL.burgershootdown.display.Display;
import game.red_knight_SBL.burgershootdown.gfx.Assets;
import game.red_knight_SBL.burgershootdown.gfx.GameCamera;
import game.red_knight_SBL.burgershootdown.input.KeyManager;
import game.red_knight_SBL.burgershootdown.input.MouseManager;
import game.red_knight_SBL.burgershootdown.state.GameState;
import game.red_knight_SBL.burgershootdown.state.IntroState;
import game.red_knight_SBL.burgershootdown.state.MenuState;
import game.red_knight_SBL.burgershootdown.state.State;

public class Game implements Runnable{
	
	public Display display;

	private int WIDTH, HEIGHT;
	public int Time;
	public String title;

	private boolean running = false;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;
	
	// States
	public State gameState;
	public State introState;
	public State menuState;
	
	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	// Game Camera
	private GameCamera gameCamera;
	
	private Handler handler;

	public Game(String title, int WIDTH, int HEIGHT) {
		this.title = title;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();

	}

	private void init() {
		display = new Display(title, WIDTH, HEIGHT);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		introState = new IntroState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}

	private void tick() {
		keyManager.tick();
		
		if (State.getState() != null)
			State.getState().tick();

	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		//Drawing area
		
		if (State.getState() != null)
			State.getState().render(g);
		
		//End drawing area
		bs.show();
		g.dispose();

	}							

	public void run() {

		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		Time = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int tick = 0;

		while (running) {
			now = System.nanoTime();				
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				tick++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				//System.out.println("Frames: " + tick);
				tick = 0;
				timer = 0;
				Time++;
			}
			
		}

		stop();

	}
	
	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public synchronized void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
