package game.red_knight_SBL.burgershootdown.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int WIDTH, int HEIGHT) {
		return sheet.getSubimage(x, y, WIDTH, HEIGHT);
	}

}
