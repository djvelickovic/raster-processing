package com.corax.transformations.sharpen;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class SharpenInvoker implements ITransformationInvoker {
	
	public static final ISharpen DEFAULT_SHARPEN = new MatrixSharpen();
	
	private ISharpen sharpen;
	private float intensity;
	
	
	public SharpenInvoker(ISharpen sharpen, float intensity) {
		super();
		if (sharpen == null || intensity < 0.0f) {
			throw new IllegalArgumentException();
		}
		this.sharpen = sharpen;
		this.intensity = intensity;
	}
	
	public SharpenInvoker(float intensity) {
		this(DEFAULT_SHARPEN, intensity);
	}

	public SharpenInvoker() {
		this(1.0f);
	}


	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return sharpen.sharp(source, intensity);
	}

}
