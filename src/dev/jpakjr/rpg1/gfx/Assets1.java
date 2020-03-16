package dev.jpakjr.rpg1.gfx;

import java.awt.image.BufferedImage;

public class Assets1 {
	private static final int width = 460, height = 120;  
	
    public static BufferedImage intro, text1;
	
	public static void init(){
		
  		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/johns.png"));
  		
  		
		intro = sheet2.crop(0, 0, width, height);
		
	}
}


