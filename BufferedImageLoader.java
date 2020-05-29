package snakev2package;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	public BufferedImage image;
	
	public BufferedImage loadImage(String path) throws IOException {
		
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
	
}
