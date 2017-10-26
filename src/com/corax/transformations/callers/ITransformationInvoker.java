package com.corax.transformations.callers;

import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public interface ITransformationInvoker {
	public WritableRaster transform(Raster source);
}
