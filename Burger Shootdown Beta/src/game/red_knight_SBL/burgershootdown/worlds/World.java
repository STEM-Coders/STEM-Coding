package game.red_knight_SBL.burgershootdown.worlds;

import java.awt.Font;
import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.EntityManager;
import game.red_knight_SBL.burgershootdown.entity.ai.AI;
import game.red_knight_SBL.burgershootdown.entity.creatures.Player;
import game.red_knight_SBL.burgershootdown.tiles.Tile;
import game.red_knight_SBL.burgershootdown.utils.Utils;

public class World {

	private Handler handler;
	private int WIDTH, HEIGHT;
	private int spawnX, spawnY;
	private int[][] tiles;
	private EntityManager entityManager;
	

	public int score = 0;
	private long prevTime, timeNow, timer = 0;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 200));
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		timer += timeNow - prevTime;
		prevTime = timeNow;
		
		if (timer >= 1000000000)
		{
			timer = 0;
			score += 1;
		}
		timeNow = System.nanoTime();
		if (handler.getKeyManager().pauseMenu == false)
			entityManager.tick();

	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(WIDTH,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(HEIGHT,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		entityManager.render(g);

		g.setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString(Long.toString(score), handler.getGame().getWidth() - 80, handler.getGame().getHeight() - 80);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x > WIDTH || y > HEIGHT)
			return Tile.grassTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.grassTile;
		return t;

	}

	private void loadWorld(String path) {

		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		WIDTH = Utils.parseInt(tokens[0]);
		HEIGHT = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[WIDTH][HEIGHT];
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * WIDTH) + 4]);
			}
		}

	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
