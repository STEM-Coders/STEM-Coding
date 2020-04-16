package game.red_knight_SBL.burgershootdown.state;

import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Game;
import game.red_knight_SBL.burgershootdown.Handler;

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
