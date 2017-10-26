package com.corax.transformations.brightness;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class BrightnessInvoker implements ITransformationInvoker {
	public static final IBrightness DEFAULT_BRIGHTNESS = new Brightness();
	
	
	private IBrightness brightness;
	private float intensity;
	
	public BrightnessInvoker(IBrightness brightness, float intensity) {
		super();
		if (brightness == null) {
			throw new IllegalArgumentException();
		}
		this.brightness = brightness;
		this.intensity = intensity;
	}

	public BrightnessInvoker(float intensity) {
		this(DEFAULT_BRIGHTNESS, intensity);
	}




	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {throw new IllegalArgumentException(); }
		return brightness.brightness(source, intensity);
	}

}
