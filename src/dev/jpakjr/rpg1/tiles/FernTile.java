package dev.jpakjr.rpg1.tiles;

import dev.jpakjr.rpg1.gfx.Assets;

public class FernTile extends Tile{

	public FernTile(int id) {
		super(Assets.fern, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
