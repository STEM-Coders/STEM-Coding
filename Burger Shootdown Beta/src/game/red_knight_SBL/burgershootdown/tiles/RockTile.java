package game.red_knight_SBL.burgershootdown.tiles;

import game.red_knight_SBL.burgershootdown.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}
