package dev.jpakjr.rpg1.worlds;

import java.awt.Graphics;

import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.Utils.Utils;
import dev.jpakjr.rpg1.entities.EntityManager;
import dev.jpakjr.rpg1.entities.creatures.Player;
import dev.jpakjr.rpg1.entities.statics.Cactus1;
import dev.jpakjr.rpg1.entities.statics.Facts;
import dev.jpakjr.rpg1.entities.statics.Rock1;
import dev.jpakjr.rpg1.entities.statics.Roses;
import dev.jpakjr.rpg1.items.ItemManager;
import dev.jpakjr.rpg1.tiles.Tile;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	//Item
	private ItemManager itemManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		entityManager.addEntity(new Roses(handler, 300,150));
		entityManager.addEntity(new Roses(handler, 330,170));
		entityManager.addEntity(new Roses(handler, 370,170));
		entityManager.addEntity(new Roses(handler, 390,190));
		entityManager.addEntity(new Rock1(handler, 100,100));
		entityManager.addEntity(new Rock1(handler, 150,150));
		entityManager.addEntity(new Rock1(handler, 250,200));
		entityManager.addEntity(new Rock1(handler, 400,500));
		entityManager.addEntity(new Facts(handler, 60, 60));

		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		itemManager.tick();
		entityManager.tick();
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		//Items
		itemManager.render(g);
		
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}   
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
