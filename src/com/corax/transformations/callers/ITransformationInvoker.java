package com.corax.transformations.callers;

import java.awt.image.Raster;

public interface ITransformationInvoker {
	public Raster transform(Raster source);
}
