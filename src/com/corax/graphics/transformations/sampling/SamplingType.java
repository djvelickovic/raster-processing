package com.corax.graphics.transformations.sampling;

import java.awt.image.WritableRaster;

import com.corax.graphics.util.SamplingUtils;

public enum SamplingType {
	BILINEAR {
		@Override
		public void calculateRGB(WritableRaster src, float u, float v, int[] rgb) {
			SamplingUtils.bilSample(src, u, v, rgb);
			
		}
	},
	POINT {
		@Override
		public void calculateRGB(WritableRaster src, float u, float v, int[] rgb) {
			SamplingUtils.pointSample(src, u, v, rgb);
			
		}
	};
	public abstract void calculateRGB(WritableRaster source, float srcX, float srcY, int[] rgb);
}
