package com.corax.transformations.scale;

import java.awt.image.WritableRaster;

public interface IScale {
	WritableRaster scale(WritableRaster raster, int width, int height);
}
