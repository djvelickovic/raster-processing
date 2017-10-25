package com.corax.transformations.negative;

import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 * Implementation of negative raster transformation
 * 
 * @author Corax
 *
 */
public class Negative implements INegative {

	@Override
	public Raster negative(Raster raster) {
		
		if (raster == null) {
			throw new IllegalArgumentException();
		}
		
		int[] rgb = new int[3];
		
		WritableRaster target = raster.createCompatibleWritableRaster();
		
		for (int y = 0; y < raster.getHeight(); y++) {
			for (int x = 0; x < raster.getWidth(); x++) {
				raster.getPixel(x, y, rgb);
				rgb[0] = 255 - rgb[0];
				rgb[1] = 255 - rgb[1];
				rgb[2] = 255 - rgb[2];
				target.setPixel(x, y, rgb);
			}
		}
		return target;
	}

}
