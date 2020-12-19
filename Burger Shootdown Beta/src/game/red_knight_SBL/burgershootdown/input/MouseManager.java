package game.red_knight_SBL.burgershootdown.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean rightPressed, leftPressed, centerPressed, shoot;
	private int mouseX, mouseY;
	
	public MouseManager() {
		
	}
	
	// Getters
	
	public boolean isRightPressed() {
		return rightPressed;
	}
	
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	public boolean isShoot() {
		return shoot;
	}
	
	public boolean isCenterPressed() {
		return centerPressed;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	// Implemented methods

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON2)
			centerPressed = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON2)
			centerPressed = false;	
	}

}
