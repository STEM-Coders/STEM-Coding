package com.Red_Knight_SBL.Corona_Traill.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.Red_Knight_SBL.Corona_Traill.gfx.Assets;

public class Display {

	public JFrame window;
	public Canvas canvas;

	private String title;

	public static int WIDTH;
	public static int HEIGHT;

	public Display(String title, int WIDTH, int HEIGHT) {
		this.title = title;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		createDisplay();
	}

	private void createDisplay() {
		window = new JFrame(title);
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setIconImage(Assets.logo);
		window.setVisible(true);

		canvas = new Canvas();

		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);

		window.add(canvas);
		window.pack();

	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return window;
	}
	
}
