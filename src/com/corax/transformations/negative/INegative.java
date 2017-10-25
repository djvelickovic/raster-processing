package com.corax.transformations.negative;

import java.awt.image.Raster;

/**
 * Interface for negative transformation
 * 
 * @author Corax
 *
 */
public interface INegative {
	/**
	 * Transforms raster into negative one
	 * 
	 * @param raster
	 * @return new object of negative raster
	 */
	Raster negative(Raster raster);
}
