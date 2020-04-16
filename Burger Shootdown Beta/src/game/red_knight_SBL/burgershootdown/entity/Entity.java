package game.red_knight_SBL.burgershootdown.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import game.red_knight_SBL.burgershootdown.Handler;

public abstract class Entity {
	
protected Handler handler;	
protected float x, y;
protected int WIDTH, HEIGHT;
protected Rectangle bounds;
	
	public Entity(Handler handler,float x, float y, int WIDTH, int HEIGHT) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		
		bounds = new Rectangle(0, 0, WIDTH, HEIGHT);
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

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);


}
