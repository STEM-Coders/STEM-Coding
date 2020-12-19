package game.red_knight_SBL.burgershootdown.state;

import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Game;
import game.red_knight_SBL.burgershootdown.Handler;

public class MenuState extends State{
	
	private Game game;
	private Handler handler;
	
	public MenuState(Handler handler) {
		super(handler);
		
	}
	
	public void tick() {
		
		if(button(795, 1068, 345, 430))
		{
			startGame();
		}
		
	}
	
	public void render(Graphics g) {
		
	}
	
	private void startGame() {
		State.setState(game.gameState);
	}
	
	private boolean button(int xMin, int xMax, int yMin, int yMax) {
		
		if (handler.getMouseManager().getMouseX() >= xMin && handler.getMouseManager().getMouseY() >= yMin && handler.getMouseManager().getMouseX() <= xMax && handler.getMouseManager().getMouseY() <= yMax && handler.getMouseManager().isLeftPressed())
		{
			return true;
		}
		
		return false;
		
	}

}
