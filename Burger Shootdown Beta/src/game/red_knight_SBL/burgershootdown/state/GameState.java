package game.red_knight_SBL.burgershootdown.state;

import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.ai.AI;
import game.red_knight_SBL.burgershootdown.worlds.World;

public class GameState extends State {

	private World world;
	private long timeNeeded = 10000000000L;
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
		
		if (timer >= timeNeeded)
		{
			timer = 0;
			handler.getWorld().getEntityManager().addEntity(new AI(handler, 300, 300));
		}
	}

	public void render(Graphics g) {
		// Renders the world
		world.render(g);
	}

}
