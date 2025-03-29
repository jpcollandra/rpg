package dev.jpakjr.rpg1.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream; // Import InputStream

public class FontLoader {
	
	public static Font loadFont(String path, float size){
		
		try {
			// Use the thread's context class loader to load the font from the classpath
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path.startsWith("/") ? path.substring(1) : path);
			if (is == null) {
				// Try the class's classloader as a fallback
				is = FontLoader.class.getResourceAsStream(path);
			}
			if (is == null) {
				throw new IOException("Resource not found: " + path);
			}
			Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
			return baseFont.deriveFont(Font.PLAIN, size);
		} catch (FontFormatException e) {
			System.err.println("Error loading font (format): " + path);
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error loading font (IO): " + path);
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
