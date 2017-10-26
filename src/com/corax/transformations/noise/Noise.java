package com.corax.transformations.noise;

import java.awt.image.WritableRaster;

public class Noise implements INoise {

	@Override
	public WritableRaster noise(WritableRaster source, NoiseType noiseType, float noiseIntensity) {
		if (source == null || noiseType == null || noiseIntensity < 0f || noiseIntensity > 1f) {
			throw new IllegalArgumentException();
		}
		
		WritableRaster target = source.createCompatibleWritableRaster();
		
		int rgb[] = new int[3];
		
		// Jacina noise efekta (u kom rasponu mijenjamo vrijednosti)
		int noise = (int)(noiseIntensity * 255);
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				source.getPixel(x, y, rgb);
				
				noiseType.calculateRGB(noise, rgb);
				
				target.setPixel(x, y, rgb);
			}
		}
		
		
		return target;
	}

}
