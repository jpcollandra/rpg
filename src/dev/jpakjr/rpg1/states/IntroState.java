package dev.jpakjr.rpg1.states;

import java.awt.Graphics;

import dev.jpakjr.rpg1.Handler;
import dev.jpakjr.rpg1.gfx.Assets;
import dev.jpakjr.rpg1.gfx.Assets1;
import dev.jpakjr.rpg1.gfx.Assets2;
import dev.jpakjr.rpg1.gfx.Assets3;

public class IntroState extends State{
		
	    public IntroState(Handler handler){
	    	super(handler);
		}

		@Override
		public void tick() {
			if(handler.getMouseManager().isLeftPressed())
				State.setState(handler.getGame().menuState);
		
		}

		@Override
		public void render(Graphics g) {
			int width = 0;
			int height = 0;
			// TODO Auto-generated method stub
			g.drawImage(Assets1.intro, 20 , height, null);
			g.drawImage(Assets3.icon, 220, 200, null);
			g.drawImage(Assets2.copyright, 100, 425, null);
			g.drawImage(Assets2.jpakjr, 173, 426, null);

		}
   }

