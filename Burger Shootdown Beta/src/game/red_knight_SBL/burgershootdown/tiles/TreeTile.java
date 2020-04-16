package game.red_knight_SBL.burgershootdown.tiles;

import game.red_knight_SBL.burgershootdown.gfx.Assets;

public class TreeTile extends Tile {

	public TreeTile(int id) {
		super(Assets.tree, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}
