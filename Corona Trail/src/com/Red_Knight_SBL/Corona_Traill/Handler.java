package com.Red_Knight_SBL.Corona_Traill;

import com.Red_Knight_SBL.Corona_Traill.input.KeyManager;

public class Handler {

	private Game game;
	//private World world;

	public Game getGame() {
		return game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	//public GameCamera getGameCamera() {
	//	return game.getGameCamera();
	//}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public void setGame(Game game) {
		this.game = game;
	}

	//public World getWorld() {
	//	return world;
	//}

	//public void setWorld(World world) {
	//	this.world = world;
	//}
	
	public Handler(Game game) {
		this.game = game;
	}
	
}
