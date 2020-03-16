package dev.jpakjr.rpg1.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//static here
	public static Tile[] tiles = new Tile[500];
	public static Tile grassTile = new GrassTile(0);
	
	public static Tile fernTile = new FernTile(1);
	
	public static Tile water1Tile = new WaterTile(2);
	
	public static Tile sandwTile = new SandWaterTile(3);
	public static Tile sandw1Tile = new Sand1WaterTile(4);
	public static Tile sandw2Tile = new Sand2WaterTile(5);
	
	public static Tile dockTile = new DockTile(6);
	public static Tile dock1Tile = new Dock1Tile(7);
	
	public static Tile grasswsandTile = new GrassWSandTile(8);


	
	

	//class here
    public static final int	TILEWIDTH = 32,  TILEHEIGHT= 32; 
    
	protected BufferedImage texture;
	protected final int id;
	
	
	public Tile(BufferedImage texture,int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
		
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
}
