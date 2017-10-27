package com.corax.transformations.scale;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class ScaleInvoker implements ITransformationInvoker {
	public static final IScale DEFAULT_SCALE_METHOD = new Scale();
	
	private IScale scaleMethod;
	private int width;
	private int height;
	
	public ScaleInvoker(IScale scaleMethod, int width, int height) {
		super();
		if (scaleMethod == null || width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		this.scaleMethod = scaleMethod;
		this.width = width;
		this.height = height;
	}


	public ScaleInvoker(int width, int height) {
		this(DEFAULT_SCALE_METHOD, width, height);
	}




	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return scaleMethod.scale(source, width, height);
	}
	
}
