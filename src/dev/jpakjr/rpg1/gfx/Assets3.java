package dev.jpakjr.rpg1.gfx;

import java.awt.image.BufferedImage;

public class Assets3 {
	    
		private static final int width = 80, height = 130; 
		
		public static BufferedImage icon;
	    
		public static void init(){
			SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage("/textures/icon.png"));


			icon = sheet5.crop(0 , 0, width, height);

		}
}