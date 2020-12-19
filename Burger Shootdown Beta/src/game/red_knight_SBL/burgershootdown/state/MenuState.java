package game.red_knight_SBL.burgershootdown.state;

import java.awt.Graphics;
import game.red_knight_SBL.burgershootdown.Handler;
import game.red_knight_SBL.burgershootdown.gfx.Assets;

public class MenuState extends State{
	
	public MenuState(Handler handler) {
		super(handler);
		
	}
	
	public void tick() {
		
		if(button(795, 1068, 345, 430))
			startGame();
		
		//if(button(795, 1068, 345, 430))
		//{
		//	game.stop();
		//}
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.mainMenu, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
	}
	
	private void startGame() {
		State.setState(handler.getGame().gameState);
	}
	
	private boolean button(int xMin, int xMax, int yMin, int yMax) {
		
		if (handler.getMouseManager().getMouseX() >= xMin && handler.getMouseManager().getMouseY() >= yMin && handler.getMouseManager().getMouseX() <= xMax && handler.getMouseManager().getMouseY() <= yMax && handler.getMouseManager().isLeftPressed())
			return true;
		
		return false;
		
	}

}
