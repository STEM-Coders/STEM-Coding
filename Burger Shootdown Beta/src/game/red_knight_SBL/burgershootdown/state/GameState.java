package game.red_knight_SBL.burgershootdown.state;

import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Game;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.creatures.Player;
import game.red_knight_SBL.burgershootdown.worlds.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}

	public void tick() {
		world.tick();
	}

	public void render(Graphics g) {
		world.render(g);
	}

}
