package com.corax.transformations.flip;

import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Flip implements IFlip {
	
	public Flip() {}
	
	@Override
	public Raster flip(Raster raster, FlipDirection flipDirection) {
		if (raster == null || flipDirection == null) {
			throw new IllegalArgumentException();
		}
		
		int[] rgb = new int[3];
		
		WritableRaster target = raster.createCompatibleWritableRaster();
		
		for (int y = 0; y < raster.getHeight(); y++) {
			for (int x = 0; x < raster.getWidth(); x++) {
				raster.getPixel(x, y, rgb);
				flipDirection.setPixel(target, x, y, rgb);
			}
		}		
		return target;
	}
}
