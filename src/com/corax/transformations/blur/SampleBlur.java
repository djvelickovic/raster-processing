package com.corax.transformations.blur;

import java.awt.image.WritableRaster;

import com.corax.transformations.SamplingUtils;

public class SampleBlur implements IBlur {

	@Override
	public WritableRaster blur(WritableRaster source, int blurPower) {
		if (source == null || blurPower < 0) {
			throw new IllegalArgumentException();
		}
		WritableRaster target = source.createCompatibleWritableRaster();

		int rgb[] = new int[3];
		int accum[] = new int[3];

		int radius = blurPower;

		int sampleCount = blurPower * 3;

		int width = source.getWidth();
		int height = source.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				accum[0] = 0;
				accum[1] = 0;
				accum[2] = 0;

				for (int i = 0; i < sampleCount; i++) {
					float X = (float) (Math.random() - 0.5) * radius * 2.0f;
					float Y = (float) (Math.random() - 0.5) * radius * 2.0f;

					SamplingUtils.bilSample(source, x + X, y + Y, rgb);

					accum[0] += rgb[0];
					accum[1] += rgb[1];
					accum[2] += rgb[2];
				}

				rgb[0] = accum[0] / sampleCount;
				rgb[1] = accum[1] / sampleCount;
				rgb[2] = accum[2] / sampleCount;

				target.setPixel(x, y, rgb);
			}
		}
		return target;
	}
}
