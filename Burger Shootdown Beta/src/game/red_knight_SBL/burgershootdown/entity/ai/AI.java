package game.red_knight_SBL.burgershootdown.entity.ai;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.creatures.Creatures;
import game.red_knight_SBL.burgershootdown.gfx.Animation;
import game.red_knight_SBL.burgershootdown.gfx.Assets;

public class AI extends Creatures {

	private Animation anim;
	public float x, y;
	private boolean hit = false;
	int timer = 0;

	public AI(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		anim = new Animation(500, Assets.ai_walk);
		this.x = x;
		this.y = y;
		bounds.x = 8;
		bounds.y = 10;
		bounds.width = 48;
		bounds.width = 48;
	}

	public void tick() {
		if (!hit)
		{
			if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds().intersects(getCollisionBounds()))
			{
				hit = true;
			    handler.getWorld().setScore(handler.getWorld().getScore() - 8);
			}
			anim.tick();
			followPlayer();
		}
		else if (timer >= 300)
		{
			hit = false;
			timer = 0;
		}
		else 
			timer++;
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (this.x - handler.getGameCamera().getxOffset()),
				(int) (this.y - handler.getGameCamera().getyOffset()), DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
	}

	private BufferedImage getCurrentAnimationFrame() {
		return anim.getCurrentFrame();
	}

	private void followPlayer() {
		if (handler.getWorld().getEntityManager().getPlayer().getX() > this.x) {
			x += speed - 2;
		}
		if (handler.getWorld().getEntityManager().getPlayer().getX() < this.x) {
			x -= speed - 2;
		}
		if (handler.getWorld().getEntityManager().getPlayer().getY() > this.y) {
			y += speed - 2;
		}
		if (handler.getWorld().getEntityManager().getPlayer().getY() < this.y) {
			y -= speed - 2;
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
