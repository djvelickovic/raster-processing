package com.corax.transformations.sampling;

import java.awt.image.WritableRaster;

public interface ISampling {
	WritableRaster scale(WritableRaster raster, SamplingType samplingType, int width, int height);
}
