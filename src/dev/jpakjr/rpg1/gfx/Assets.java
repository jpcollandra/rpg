package dev.jpakjr.rpg1.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	    
		private static final int width = 32, height = 32;  
		
		public static Font font20;
	
	    public static BufferedImage grass, grasswsand, fern, roses, intro,
	    							water1,
	    							sandw1, sandw2,sandw3,
	    							dock1, dock2,
	    							rock1,
	    							cactus1,
	    							facts, facts2;     
	    public static BufferedImage[] player_down, player_up, player_left, player_right,player_down1;
	    public static BufferedImage inventoryScreen;
	    
		public static void init(){
			font20 = FontLoader.loadFont("res/fonts/slkscr.ttf", 20);
			
			
			SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tileset.png"));
      		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/mainguy.png"));
      		
      		inventoryScreen = ImageLoader.loadImage("/textures/screen.png");

      		player_down = new BufferedImage[4];
      		player_up = new BufferedImage[4];
      		player_left = new BufferedImage[4];
      		player_right = new BufferedImage[4];
      		player_down1 = new BufferedImage[4]; 

            player_down1[0]= sheet1.crop(45, 0, width, height);
            player_down1[1]= sheet1.crop(45, 0, width, height);
            player_down1[2]= sheet1.crop(45, 0, width, height);
            player_down1[3]= sheet1.crop(45, 0, width, height);

      		
      		player_down[0] = sheet1.crop(0, 0, width, height);
      		player_down[1] = sheet1.crop(90, 0, width, height);
      		player_down[2] = sheet1.crop(0, 0, width, height);
      		player_down[3] = sheet1.crop(90, 0, width, height);

      		
      		player_up[0] = sheet1.crop(0, 67 , width, height);
      		player_up[1] = sheet1.crop(90, 67, width, height);
      		player_up[2] = sheet1.crop(0, 67, width, height);
      		player_up[3] = sheet1.crop(90, 67, width, height);

      		player_left[0] = sheet1.crop(0, 100, width, height);
      		player_left[1] = sheet1.crop(90, 101, width, height);
      		player_left[2] = sheet1.crop(0, 100, width, height);
      		player_left[3] = sheet1.crop(90, 101, width, height);

      		
      		player_right[0] = sheet1.crop(0, 34, width, height);
      		player_right[1] = sheet1.crop(90 , 34 , width, height);
      		player_right[2] = sheet1.crop(0, 34 , width, height);
      		player_right[3] = sheet1.crop(90 , 34 , width, height);
            
			grass = sheet.crop(34, 34, width, height);
			grasswsand = sheet.crop(34, 496, width, height);
			
			fern = sheet.crop(100, 1, width, height);
			roses = sheet.crop(0, 165, width, height);
			rock1 = sheet.crop(0, 195, width, height);
			
			facts = sheet.crop(470, 125, width, height);
			facts2 = sheet.crop(470, 100, width, height);
			
			water1 = sheet.crop(331, 232, width, height);
			
			sandw1 = sheet.crop(133, 364, width, height);
			sandw2 = sheet.crop(100, 364, width, height);
			sandw3 = sheet.crop(100, 397, width, height);
			
			dock1 = sheet.crop(331, 1, width, height);
			dock2 = sheet.crop(265, 133, width, height);
				
			cactus1 = sheet.crop(0, 267, width, height);

		}
}
