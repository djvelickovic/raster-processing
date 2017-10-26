package com.corax.transformations.noise;

import java.awt.image.WritableRaster;

public interface INoise {
	WritableRaster noise(WritableRaster source, NoiseType noiseType, float noiseIntensity);
}
