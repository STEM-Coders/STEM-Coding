package game.red_knight_SBL.burgershootdown.entity.ai;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.creatures.Creatures;
import game.red_knight_SBL.burgershootdown.entity.creatures.Player;
import game.red_knight_SBL.burgershootdown.gfx.Animation;
import game.red_knight_SBL.burgershootdown.gfx.Assets;
import game.red_knight_SBL.burgershootdown.tiles.Tile;

public class AI extends Creatures {

	private Animation anim;
	public static float x, y;
	public static boolean hit = false;

	public AI(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		anim = new Animation(500, Assets.ai_walk);
		this.x = x;
		this.y = y;
		bounds.x = 8;
		bounds.y = 10;
		bounds.width = 48;
		bounds.width = 32;
	}

	public void tick() {
		anim.tick();
		followPlayer();
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (this.x - handler.getGameCamera().getxOffset()),
				(int) (this.y - handler.getGameCamera().getyOffset()), DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
	}

	private BufferedImage getCurrentAnimationFrame() {
		return anim.getCurrentFrame();
	}

	private void followPlayer() {
		if (Player.x > this.x && !collisionWithTile((int) this.x, (int) this.y)) {
			this.x += speed - 2;
		}
		if (Player.x < this.x && !collisionWithTile((int) this.x, (int) this.y)) {
			this.x -= speed - 2;
		}
		if (Player.y > this.y && !collisionWithTile((int) this.x, (int) this.y)) {
			this.y += speed - 2;
		}
		if (Player.y < this.y && !collisionWithTile((int) this.x, (int) this.y)) {
			this.y -= speed - 2;
		}
	}

}
