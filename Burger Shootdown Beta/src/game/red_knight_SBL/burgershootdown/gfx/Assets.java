package game.red_knight_SBL.burgershootdown.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 64, height = 64;

	public static BufferedImage mainMenu, grass, dirt, rock, tree, player_shoot, pickle_bullet;
	public static BufferedImage[] player_walk;
	public static BufferedImage[] ai_walk;

	public static void init() {

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sheet.png"));
		
		player_walk = new BufferedImage[2];
		ai_walk = new BufferedImage[4];
		
		player_shoot = sheet.crop(1366, height * 4, width, height);
		player_walk[0] = sheet.crop(1366, height * 5, width, height);
		player_walk[1] = sheet.crop(1366, height * 6, width, height);
		pickle_bullet = sheet.crop(1366, height * 7, width, height);
		ai_walk[0] = sheet.crop(1366, height * 8, width, height);
		ai_walk[1] = sheet.crop(1366, height * 9, width, height);
		ai_walk[2] = sheet.crop(1366, height * 10, width, height);
		ai_walk[3] = sheet.crop(1366, height * 11, width, height);
		mainMenu = ImageLoader.loadImage("/textures/UI.png");
		dirt = sheet.crop(1366, 0, width, height);
		grass = sheet.crop(1366, height, width, height);
		rock = sheet.crop(1366, height * 2, width, height);
		tree = sheet.crop(1366, height * 3, width, height);
	}

}
