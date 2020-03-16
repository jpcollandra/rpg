package dev.jpakjr.rpg1.tiles;

import dev.jpakjr.rpg1.gfx.Assets;

public class WaterTile extends Tile{

	public WaterTile(int id) {
		super(Assets.water1, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}