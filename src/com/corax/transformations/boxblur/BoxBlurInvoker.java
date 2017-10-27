package com.corax.transformations.boxblur;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class BoxBlurInvoker implements ITransformationInvoker {
	public static final IBoxBlur DEFAULT_BOX_BLUR_ALGORITHM = new BoxBlur();
	
	
	private IBoxBlur boxBlur;
	private int bluringPower;
	
	
	public BoxBlurInvoker(IBoxBlur boxBlur, int bluringPower) {
		super();
		this.boxBlur = boxBlur;
		this.bluringPower = bluringPower;
	}
	
	public BoxBlurInvoker( int bluringPower) {
		this(DEFAULT_BOX_BLUR_ALGORITHM, bluringPower);
	}

	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return boxBlur.boxBlur(source, bluringPower);
	}
	
	
}
