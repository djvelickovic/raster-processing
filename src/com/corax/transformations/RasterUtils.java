package com.corax.transformations;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class RasterUtils {
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
}
