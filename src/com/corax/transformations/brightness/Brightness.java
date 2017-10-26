package com.corax.transformations.brightness;

import java.awt.image.WritableRaster;

class Brightness implements IBrightness {

	@Override
	public WritableRaster brightness(WritableRaster raster, float intensity) {
		if (raster == null) {
			throw new IllegalArgumentException();
		}
		
		int[] rgb = new int[3];
		
		WritableRaster target = raster.createCompatibleWritableRaster();
		
		for (int y = 0; y < raster.getHeight(); y++) {
			for (int x = 0; x < raster.getWidth(); x++) {
				raster.getPixel(x, y, rgb);
				
				
				rgb[0] += (int)(rgb[0] * intensity );
				rgb[0] = rgb[0] > 255 ? 255 : rgb[0];
				rgb[0] = rgb[0] < 0 ? 0 : rgb[0];
				
				rgb[1] += (int)(rgb[1] * intensity );
				rgb[1] = rgb[1] > 255 ? 255 : rgb[1];
				rgb[1] = rgb[1] < 0 ? 0 : rgb[1];
				
				rgb[2] += (int)(rgb[2] * intensity );
				rgb[2] = rgb[2] > 255 ? 255 : rgb[2];
				rgb[2] = rgb[2] < 0 ? 0 : rgb[2];
				
				target.setPixel(x, y, rgb);
			}
			
		}
		return target;
	}

}
