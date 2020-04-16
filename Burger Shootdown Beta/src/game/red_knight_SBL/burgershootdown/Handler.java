package game.red_knight_SBL.burgershootdown;

import game.red_knight_SBL.burgershootdown.gfx.GameCamera;
import game.red_knight_SBL.burgershootdown.input.KeyManager;
import game.red_knight_SBL.burgershootdown.worlds.World;

public class Handler {
	
	private Game game;
	private World world;

	public Game getGame() {
		return game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public Handler(Game game) {
		this.game = game;
	}

}
