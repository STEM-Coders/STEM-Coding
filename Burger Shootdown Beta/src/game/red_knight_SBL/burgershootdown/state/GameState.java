package game.red_knight_SBL.burgershootdown.state;

import java.awt.Font;
import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.worlds.World;

public class GameState extends State {

	private World world;
	public long score = 0;
	private long prevTime, timeNow, timer = 0;

	public GameState(Handler handler) {
		// Sets the world
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}

	public void tick() {
		// Ticks the world
		world.tick();
		timeNow = System.nanoTime();
		timer += timeNow - prevTime;
		prevTime = timeNow;
		
		if (timer >= 1000000000)
		{
			timer = 0;
			score += 1;
		}
	}

	public void render(Graphics g) {
		// Renders the world
		world.render(g);
		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(Long.toString(score), handler.getGame().getWidth() - 80, handler.getGame().getHeight() - 80);
	}

}
