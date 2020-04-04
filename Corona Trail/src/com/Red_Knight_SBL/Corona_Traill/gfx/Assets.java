package com.Red_Knight_SBL.Corona_Traill.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;

	public static BufferedImage logo;
	public static BufferedImage[] player_walk;
	public static BufferedImage[] ai_walk;

	public static void init() {

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Logo.png"));
		
		logo = sheet.crop(0, 0, width, height);
	}

}