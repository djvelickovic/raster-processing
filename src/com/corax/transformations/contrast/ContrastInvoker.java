package com.corax.transformations.contrast;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

/**
 * Invoker for contrast transformation
 * 
 * @author Corax
 *
 */
public class ContrastInvoker implements ITransformationInvoker {
	public static final IContrast DEFAULT_CONTRAST = new Contrast();

	private IContrast contrast;
	private float intensity;

	public ContrastInvoker(IContrast contrast, float intensity) {
		super();
		if (contrast == null) {
			throw new IllegalArgumentException();
		}
		this.intensity = intensity;
		this.contrast = contrast;
	}
	

	public ContrastInvoker(float intensity) {
		this(DEFAULT_CONTRAST, intensity);
	}

	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return contrast.contrast(source, intensity);
	}

}
