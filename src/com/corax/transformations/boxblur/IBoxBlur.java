package com.corax.transformations.boxblur;

import java.awt.image.WritableRaster;

public interface IBoxBlur {
	/**
	 * @param writableRaster
	 * @param blurPower goes from 0 to INT_MAX
	 * @return
	 */
	WritableRaster boxBlur(WritableRaster writableRaster, int blurPower);
}
