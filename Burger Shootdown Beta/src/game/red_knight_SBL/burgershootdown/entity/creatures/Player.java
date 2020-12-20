package game.red_knight_SBL.burgershootdown.entity.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.gfx.Animation;
import game.red_knight_SBL.burgershootdown.gfx.Assets;
import game.red_knight_SBL.burgershootdown.tiles.Tile;

public class Player extends Creatures {

	private Animation anim;
	public static float x;
	public static float y;
	private boolean walk;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);

		this.x = x;
		this.y = y;

		bounds.x = 15;
		bounds.y = 15;
		bounds.height = 41;
		bounds.width = 40;

		anim = new Animation(500, Assets.player_walk);
	}

	public void tick() {
		if (checkEntityCollisions())
			System.out.println("Ai hit");
		anim.tick();
		getInput();
		handler.getGameCamera().centerOnEntity(this);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		Player.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		Player.y = y;
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
			walk = true;
			if (yMove < 0) {
				int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

				if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
						&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
					this.y += yMove;
				} else {
					y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
				}

			}
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
			walk = true;
			if (yMove > 0) {
				int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

				if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
						&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
					this.y += yMove;
				} else {
					y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
				}
			}
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
			walk = true;
			if (xMove < 0) {
				int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
				if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
						&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
					this.x += xMove;
				} else {
					x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
				}
			}
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
			walk = true;
			if (xMove > 0) {

				int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
				if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
						&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
					this.x += xMove;
				} else {
					x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
				}

			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), WIDTH, HEIGHT, null);
		walk = false;
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (walk) {
			return anim.getCurrentFrame();
		} else
			return Assets.player_walk[0];

	}

}
