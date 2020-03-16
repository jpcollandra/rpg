package dev.jpakjr.rpg1.entities.statics;

import java.awt.Graphics;

import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.gfx.Assets;
import dev.jpakjr.rpg1.items.Item;
import dev.jpakjr.rpg1.tiles.Tile;

public class Facts extends StaticEntity{
	
	public Facts(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);

		bounds.x = 5;
		bounds.y = (int) (height / 2);
		bounds.width = width - 10;
		bounds.height = (int)(height - height / 1.2);
		
	}


	@Override
	public void tick() {
		
	}
	
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.factsItem.createNew((int) x,(int) y));	
	}

	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.facts, (int) (x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()) , width, height, null);
		
	}
}