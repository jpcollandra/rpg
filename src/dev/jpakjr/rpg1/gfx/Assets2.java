package dev.jpakjr.rpg1.gfx;

import java.awt.image.BufferedImage;

public class Assets2 {
	    
		private static final int width = 70, height = 25; 
		
		public static BufferedImage copyright, jpakjr;
		
		public static BufferedImage[] btn_start;
	    
		public static void init(){
			SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/start.png"));

			btn_start = new BufferedImage[2];
			btn_start[0]= sheet4.crop(0, 0, width, height);
			btn_start[1]= sheet4.crop(0, 37, width, height);
			
			copyright = sheet4.crop(0, 225, width, height);
			jpakjr = sheet4.crop(0, 264, width, height);
		}
}
