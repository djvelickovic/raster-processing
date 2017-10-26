package com.corax.transformations.edgedetection;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public class EdgeDetectionInvoker implements ITransformationInvoker{

	public static final IEdgeDetection DEFAULT_EDGEDETECTION = new EdgeDetection();
	
	private IEdgeDetection edgeDetectioin;
	private int multiplier;
	
	
	public EdgeDetectionInvoker(IEdgeDetection edgeDetectioin, int multiplier) {
		super();
		if (edgeDetectioin == null || multiplier < 1) {
			throw new IllegalArgumentException();
		}
		this.edgeDetectioin = edgeDetectioin;
		this.multiplier = multiplier;
	}


	public EdgeDetectionInvoker(int multiplier) {
		this(DEFAULT_EDGEDETECTION, multiplier);
	}
	
	public EdgeDetectionInvoker() {
		this(DEFAULT_EDGEDETECTION, 3);
	}

	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return edgeDetectioin.detectEdges(source, multiplier);
	}

}
