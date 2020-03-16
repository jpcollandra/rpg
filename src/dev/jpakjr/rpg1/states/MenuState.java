package dev.jpakjr.rpg1.states;

import java.awt.Graphics;

import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.entities.creatures.Player;
import dev.jpakjr.rpg1.gfx.Assets2;
import dev.jpakjr.rpg1.ui.ClickListener;
import dev.jpakjr.rpg1.ui.UIImageButton;
import dev.jpakjr.rpg1.ui.UIManager;
import dev.jpakjr.rpg1.worlds.World;

public class MenuState extends State{
		
		private UIManager uiManager;
	
	    public MenuState(final Handler handler){
	    	super(handler);
	    	
	    	uiManager = new UIManager(handler);
	    	handler.getMouseManager().setUIManager(uiManager);
	    	
	    	uiManager.addObject(new UIImageButton(10,10,100, 30, Assets2.btn_start, new ClickListener(){

				public void onClick() {
					handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().gameState);
				}
				}));
		}
 
		@Override
		public void tick() {
			uiManager.tick();
		
		}

		@Override
		public void render(Graphics g) {
			uiManager.render(g);
		}
}
