package com.Red_Knight_SBL.Corona_Traill.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private BufferedImage[] frames;
	private long lastTime, timer;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		lastTime = System.currentTimeMillis();
	}
	
	//update all variables
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if (timer >= frames.length) {
			index++;
			timer = 0;
			if (index >= frames.length)
				index = 0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
