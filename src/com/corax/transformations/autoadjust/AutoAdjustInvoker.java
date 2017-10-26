package com.corax.transformations.autoadjust;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class AutoAdjustInvoker implements ITransformationInvoker {
	public static final IAutoAdjust DEFAULT_AUTOADJUST = new AutoAdjust();
	
	private IAutoAdjust autoAdjust;
	private float percent;
	
	
	public AutoAdjustInvoker(IAutoAdjust autoAdjust, float percent) {
		super();
		if (autoAdjust == null || percent < 0.0f) {
			throw new IllegalArgumentException();
		}
		this.autoAdjust = autoAdjust;
		this.percent = percent;
	}


	public AutoAdjustInvoker(float percent) {
		this(DEFAULT_AUTOADJUST, percent);
	}




	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return autoAdjust.autoAdjust(source, percent);
	}
	
}
