package game.red_knight_SBL.burgershootdown.entity.creatures;

import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.Entity;

public abstract class Creatures extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creatures(Handler handler, float x, float y, int WIDTH, int HEIGHT) {
		super(handler, x, y, WIDTH, HEIGHT);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
