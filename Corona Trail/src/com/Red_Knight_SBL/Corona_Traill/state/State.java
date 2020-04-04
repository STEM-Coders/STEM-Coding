package com.Red_Knight_SBL.Corona_Traill.state;

import java.awt.Graphics;
import com.Red_Knight_SBL.Corona_Traill.Handler;

public abstract class State {

private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
