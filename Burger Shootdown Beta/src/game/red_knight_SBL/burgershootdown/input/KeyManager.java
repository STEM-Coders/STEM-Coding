package game.red_knight_SBL.burgershootdown.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, right, left, shoot, operate, pauseMenu;

	public KeyManager() {

		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
		pauseMenu = false;

	}

	public void tick() {
		for (int i = 0; i < keys.length; i++) {
			if (cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			} else if (justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}

			if (!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}

		if (keyJustPressed(KeyEvent.VK_E)) {
			if (!pauseMenu) {
				pauseMenu = true;
				return;
			}

			if (pauseMenu) {
				pauseMenu = false;
				return;
			}
			pauseMenu = false;
		}

		// Keys that will be used
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		shoot = keys[KeyEvent.VK_J];
		operate = keys[KeyEvent.VK_E];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;

		keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;

		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean keyJustPressed(int keyCode) {
		if (keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
}
