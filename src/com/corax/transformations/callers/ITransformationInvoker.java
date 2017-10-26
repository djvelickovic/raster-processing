package com.corax.transformations.callers;

import java.awt.image.WritableRaster;

/**
 * 
 * Interface that represent invoker of transformation algorithms
 * 
 * @author Corax
 *
 */
public interface ITransformationInvoker {
	/**
	 * This method do transformation on copy of forwarded raster
	 * @param source
	 * @return returns transformed copy of raster
	 */
	public WritableRaster transform(WritableRaster source);
}
