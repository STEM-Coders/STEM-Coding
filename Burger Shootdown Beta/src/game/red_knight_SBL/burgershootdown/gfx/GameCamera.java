package game.red_knight_SBL.burgershootdown.gfx;

import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.entity.Entity;
import game.red_knight_SBL.burgershootdown.tiles.Tile;

public class GameCamera {
	
	private float xOffset, yOffset;
	private Handler handler;

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = xOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
		}
		
	}
	
	public void centerOnEntity(Entity e) {
		yOffset = e.getY() - handler.getHeight() / 2 + e.getWIDTH() / 2;
		xOffset = e.getX() - handler.getWidth() / 2 + e.getHEIGHT() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
	
}
