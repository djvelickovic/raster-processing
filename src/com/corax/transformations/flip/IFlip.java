package com.corax.transformations.flip;

import java.awt.image.Raster;

/**
 * Interface of flip transformation
 * @author Corax
 *
 */
public interface IFlip {
	/**
	 * Flips raster in chosen direction
	 * @param raster
	 * @param flipDirection
	 * @return
	 */
	Raster flip(Raster raster,FlipDirection flipDirection);
}
