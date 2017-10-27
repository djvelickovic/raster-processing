package com.corax.transformations.radialblur;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class RadialBlurInvoker implements ITransformationInvoker {
	public static final IRadialBlur DEFAULT_RADIAL_BLUR = new RadialBlur();
	
	private IRadialBlur radialBlur;
	private float strenght;
	
	public RadialBlurInvoker(IRadialBlur radialBlur, float strenght) {
		super();
		this.radialBlur = radialBlur;
		this.strenght = strenght;
	}
	
	public RadialBlurInvoker(float strenght) {
		this(DEFAULT_RADIAL_BLUR, strenght);
	}


	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return radialBlur.radialBlur(source, strenght);
	}

}
