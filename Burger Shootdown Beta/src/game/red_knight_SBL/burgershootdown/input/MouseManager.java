package game.red_knight_SBL.burgershootdown.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean rightPressed, leftPressed, centerPressed;
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
	
	public boolean isCenterPressed() {
		return centerPressed;
	}
	
	// Implemented methods

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
		else if (e.getButton() == MouseEvent.BUTTON2)
			centerPressed = true;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON2)
			centerPressed = false;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
