package com.corax.transformations.zoomblur;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class ZoomBlurInvoker implements ITransformationInvoker {
	public static final IZoomBlur DEFAULT_ZOOM_BLUR_ALGORITHM = new ZoomBlur();
	
	private IZoomBlur zoomBlur;
	private float strenght;
	
	public ZoomBlurInvoker(IZoomBlur zoomBlur, float strenght) {
		super();
		if (zoomBlur == null) {
			throw new IllegalArgumentException();
		}
		this.zoomBlur = zoomBlur;
		this.strenght = strenght;
	}
	
	public ZoomBlurInvoker(float strenght) {
		this(DEFAULT_ZOOM_BLUR_ALGORITHM, strenght);
	}


	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return zoomBlur.zoomBlur(source, strenght);
	}

	
	
}
