package dev.jpakjr.rpg1;

import dev.jpakjr.rpg1.gfx.GameCamera;
import dev.jpakjr.rpg1.input.KeyManager;
import dev.jpakjr.rpg1.input.MouseManager;
import dev.jpakjr.rpg1.worlds.World;

public class Handler {
	
	public Game game;
	public World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
