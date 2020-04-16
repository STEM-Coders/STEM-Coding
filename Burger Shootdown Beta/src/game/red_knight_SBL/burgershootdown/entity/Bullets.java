package game.red_knight_SBL.burgershootdown.entity;

import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.creatures.Creatures;
import game.red_knight_SBL.burgershootdown.entity.creatures.Player;
import game.red_knight_SBL.burgershootdown.gfx.Assets;
import game.red_knight_SBL.burgershootdown.tiles.Tile;

public class Bullets {

	public static float x, y;
	private int width, height;
	public static Handler handler;
	public static boolean isShooting = false;
	private Player player;

	public Bullets() {
		this.x = player.x;
		this.y = player.y;
		this.width = Creatures.DEFAULT_WIDTH;
		this.height = Creatures.DEFAULT_HEIGHT;
	}

	public void tick() {
		if (isShooting) {
			this.x += 6;
		}
		if (isShooting
				&& this.x > handler.getWorld().getWidth() - Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()) {
			isShooting = false;
		}
	}

	public void render(Graphics g) {
		if (isShooting)
			g.drawImage(Assets.pickle_bullet, (int) this.x, (int) this.y, this.width, this.height, null);
	}

}
