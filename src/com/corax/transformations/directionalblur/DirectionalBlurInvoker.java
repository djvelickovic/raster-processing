package com.corax.transformations.directionalblur;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class DirectionalBlurInvoker implements ITransformationInvoker {
	public static final IDirectionalBlur DEFAULT_DIRECTINALBLUR = new DirectionalBlur();
	
	private IDirectionalBlur directionalBlur;
	private float vecX;
	private float vecY;
	
	
	public DirectionalBlurInvoker(IDirectionalBlur directionalBlur, float vecX, float vecY) {
		super();
		this.directionalBlur = directionalBlur;
		this.vecX = vecX;
		this.vecY = vecY;
	}

	public DirectionalBlurInvoker(float vecX, float vecY) {
		this(DEFAULT_DIRECTINALBLUR, vecX, vecY);
	}

	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return directionalBlur.blur(source, vecX, vecY);
	}

}
