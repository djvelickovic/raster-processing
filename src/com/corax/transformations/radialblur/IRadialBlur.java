package com.corax.transformations.radialblur;

import java.awt.image.WritableRaster;

public interface IRadialBlur {
	WritableRaster radialBlur(WritableRaster source, float strenght);
}
