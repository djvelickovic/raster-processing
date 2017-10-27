package com.corax.transformations.directionalblur;

import java.awt.image.WritableRaster;

public interface IDirectionalBlur {
	WritableRaster blur(WritableRaster source, float directionX, float directionY);
}
