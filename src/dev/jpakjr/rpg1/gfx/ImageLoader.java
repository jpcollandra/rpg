package dev.jpakjr.rpg1.gfx;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream; // Import InputStream
import javax.imageio.ImageIO;

public class ImageLoader {

		public static BufferedImage loadImage(String path){
			try {
				InputStream is = ImageLoader.class.getResourceAsStream(path);
				if (is == null) {
					throw new IOException("Resource not found: " + path);
				}
				return ImageIO.read(is);
			} catch (IOException e) {
				System.err.println("Error loading image: " + path);
				e.printStackTrace();
				System.exit(1);
			}
			return null;
		}
		
	}
