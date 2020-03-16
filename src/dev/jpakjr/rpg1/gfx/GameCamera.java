package dev.jpakjr.rpg1.gfx;

import dev.jpakjr.rpg1.Game;
import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.entities.Entity;
import dev.jpakjr.rpg1.tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.setxOffset(xOffset);
		this.setyOffset(yOffset);
	}
	
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset <0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() * Tile.TILEWIDTH - handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() / 2 - e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 - e.getHeight() / 2;
		checkBlankSpace();

	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
