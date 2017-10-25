package com.corax.transformations.flip;

import java.awt.image.WritableRaster;

/**
 * Direction of flip. Can be HORIZONTAL or VERTICAL
 * 
 * @author Corax
 *
 */
public enum FlipDirection {
	HORIZONTAL {

		@Override
		public void setPixel(WritableRaster target, int x, int y, int[] rgb) {
			target.setPixel(target.getWidth() - x, y, rgb);
		}
	},
	VERTICAL {

		@Override
		public void setPixel(WritableRaster target, int x, int y, int[] rgb) {
			target.setPixel(x, target.getHeight() - y, rgb);
		}
	};
	private FlipDirection() {}

	/**
	 * Sets pixels on new raster. Setting depends on FlipDirection
	 * 
	 * @param target target raster
	 * @param x
	 * @param y
	 * @param rgb
	 */
	public abstract void setPixel(WritableRaster target,int x,int y, int[] rgb);
	
}
