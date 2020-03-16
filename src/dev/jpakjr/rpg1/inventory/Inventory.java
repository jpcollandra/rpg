package dev.jpakjr.rpg1.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.gfx.Assets;
import dev.jpakjr.rpg1.gfx.Text;
import dev.jpakjr.rpg1.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 20, invY = 20,
			invWidth = 260, invHeight= 250,
			invListCenterX = invX + 100,
		    invListCenterY = invY + invHeight / 2 + 5,
			invListSpacing = 20;
	
	private int invImageX = 205, invImageY = 100,
			invImageWidth = 32, invImageHeight = 32;
	
	private int invCountX = 220, invCountY = 150;
	
	private int selectedItem = 0; 

			
	
	public Inventory(Handler handler){
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
	}

	public void tick(){
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		
		if(selectedItem < 0)
			selectedItem =  inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
	}
	
	public void render(Graphics g){
		if(!active)
			return;
		
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);

		int len = inventoryItems.size(); 
		
		if(len == 0)
			return;
		
		for(int i = -5; i < 6; i++){
			if(selectedItem + i < 0 || selectedItem + i >=len)
				continue;
			
			if(i == 0){
			Text.drawString(g, ">" + inventoryItems.get(selectedItem +i).getName(), invListCenterX,
					invListCenterY + i * invListSpacing, true , Color.BLACK, Assets.font20);
			}else{
				Text.drawString(g, inventoryItems.get(selectedItem +i).getName(), invListCenterX,
						invListCenterY + i * invListSpacing, true , Color.BLACK, Assets.font20);
			}
		}
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.BLACK, Assets.font20);
	}
	//Inventory Methods
	public void addItem(Item item){
		for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	
	//Getters/Setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

}
