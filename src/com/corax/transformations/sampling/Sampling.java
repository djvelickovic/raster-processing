package com.corax.transformations.scale;

import java.awt.image.WritableRaster;

import com.corax.transformations.TransformationUtils;

public class Scale implements IScale {

	@Override
	public WritableRaster scale(WritableRaster raster, int scaleW, int scaleH) {
		
		if (raster == null || scaleW <= 0 || scaleH <= 0) {
			throw new IllegalArgumentException();
		}
		
		int sourceW = raster.getWidth();
		int sourceH = raster.getHeight();
				
		WritableRaster target = TransformationUtils.createRaster(scaleW, scaleH);		
		int rgb[] = new int[3];
		
		for(int y = 0; y < scaleH; y++)
		{
			double fy = (double)y / scaleH;
			
			for(int x = 0; x < scaleW; x++)
			{
				double fx = (double)x / scaleW;
				
				double srcX = fx * sourceW;
				double srcY = fy * sourceH;
				
				int pX = TransformationUtils.clamp((int)srcX, 0, sourceW - 1);
				int pY = TransformationUtils.clamp((int)srcY, 0, sourceH - 1);
				raster.getPixel(pX, pY, rgb);
				target.setPixel(x, y, rgb);
			}
		}
		return target;
	}
}
