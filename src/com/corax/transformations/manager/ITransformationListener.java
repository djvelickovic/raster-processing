package com.corax.transformations.manager;

import java.awt.image.Raster;
import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

public interface ITransformationListener {
	void action(ITransformationInvoker transformationInvoker, WritableRaster result);
}
