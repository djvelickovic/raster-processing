package com.corax.graphics.transformations.manager;

import java.awt.image.WritableRaster;
import java.util.LinkedList;

import com.corax.graphics.callers.IProcessingInvoker;

/**
 * Transformation contains multiple TransformationInvokers,
 * and is itself TransformationInvoker.
 * 
 * @author Corax
 *
 */
public class Transformation implements IProcessingInvoker {
	
	/**
	 * List of transformations 
	 */
	private LinkedList<IProcessingInvoker> transformationList;
	
	public Transformation() {
		transformationList = new LinkedList<>();
	}
	
	/**
	 * Add transformation invoker
	 * @param transformation
	 * @return returns itself
	 */
	public Transformation addTransformation(IProcessingInvoker transformation) {
		if (transformation == null) {
			throw new IllegalArgumentException();
		}
		transformationList.add(transformation);
		return this;
	}
	
	/**
	 * Removes transformation
	 * @param transformationInvoker
	 * @return
	 */
	public Transformation removeTransformation(IProcessingInvoker transformationInvoker) {
		transformationList.remove(transformationInvoker);
		return this;
	}
	
	@Override
	public WritableRaster process(WritableRaster source) {
		return transform(source, null);
	}
	
	/**
	 * Transforms raster
	 * 
	 * @param source
	 * @param transformationListener
	 * @return
	 */
	public WritableRaster transform(WritableRaster source, ITransformationListener transformationListener) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		WritableRaster midRaster = source;
		LinkedList<IProcessingInvoker> safeCopy = new LinkedList<>(transformationList);
		for (IProcessingInvoker transformationInvoker : safeCopy) {
			midRaster = transformationInvoker.process(midRaster);
			if(transformationListener != null) { 
				transformationListener.action(transformationInvoker, midRaster);
			}
		}
		return midRaster;
	}
	
	
}
