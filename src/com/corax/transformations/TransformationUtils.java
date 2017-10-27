package com.corax.transformations;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class TransformationUtils {

	public static int clamp(int value, int min, int max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}

	public static int saturate(int value) {
		return clamp(value, 0, 255);
	}

	public static WritableRaster createRaster(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		return image.getRaster();
	}

	public static WritableRaster createRasterWithAlpha(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		return image.getRaster();
	}

	public static BufferedImage rasterToImage(WritableRaster raster) {
		BufferedImage image = null;
		switch (raster.getNumBands()) {
		case 3: // rgb
			image = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			image.setData(raster);
			break;
		case 4: // rgba
			image = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			image.setData(raster);
			break;
		default:
			throw new RuntimeException("Invalid type of raster!");
		}
		return image;
	}

	public static BufferedImage loadImage(String fileName) {
		BufferedImage image = null;
		try {
			if (fileName.startsWith("/")) {
				fileName = fileName.substring(1);
				URL imgURL = ClassLoader.getSystemResource(fileName);
				image = ImageIO.read(imgURL.toURI().toURL());
			} else {
				image = ImageIO.read(new File(fileName));
			}
		} catch (Exception e) {
			System.err.println("Error loading: "+fileName);
		}
		return image;
	}

}
