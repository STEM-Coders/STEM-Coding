package game.red_knight_SBL.burgershootdown.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.ai.AI;
import game.red_knight_SBL.burgershootdown.entity.creatures.Player;
import game.red_knight_SBL.burgershootdown.input.KeyManager;

public class EntityManager {

	private Handler handler;
	private Player player;
	private AI ai;
	private ArrayList<Entity> entities;
	// private boolean shooting = true;

	public EntityManager(Handler handler, Player player, AI ai) {
		this.player = player;
		this.ai = ai;
		// bullet = new Bullets();
		this.handler = handler;
		entities = new ArrayList<Entity>();

	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
		}

		player.tick();
		// while (shooting) {
		// bullet.tick();
		// }
		if (!AI.hit)
			ai.tick();
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);

		}

		player.render(g);
		// while (shooting) {
		// bullet.render(g);
		// }
		if (!AI.hit)
			ai.render(g);
	}

	public AI getAi() {
		return ai;
	}

	public void setAi(AI ai) {
		this.ai = ai;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
