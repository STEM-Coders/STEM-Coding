package com.Red_Knight_SBL.Corona_Traill.state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.Red_Knight_SBL.Corona_Traill.Handler;

public class IntroState extends State{
	
	private int index;
	private BufferedImage[] frames;
	private long lastTime, timer;

	public IntroState(Handler handler) {
		super(handler);
		
	}

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

	public void render(Graphics g) {
		
		
	}

}
