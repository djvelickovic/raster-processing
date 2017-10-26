package com.corax.transformations.manager;

import java.awt.image.WritableRaster;
import java.util.LinkedList;

import com.corax.transformations.callers.ITransformationInvoker;

/**
 * Transformation contains multiple TransformationInvokers,
 * and is itself TransformationInvoker.
 * 
 * @author Corax
 *
 */
public class Transformation implements ITransformationInvoker {
	
	/**
	 * List of transformations 
	 */
	private LinkedList<ITransformationInvoker> transformationList;
	
	public Transformation() {
		transformationList = new LinkedList<>();
	}
	
	/**
	 * Add transformation invoker
	 * @param transformation
	 * @return returns itself
	 */
	public Transformation addTransformation(ITransformationInvoker transformation) {
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
	public Transformation removeTransformation(ITransformationInvoker transformationInvoker) {
		transformationList.remove(transformationInvoker);
		return this;
	}
	
	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		WritableRaster midRaster = source;
		LinkedList<ITransformationInvoker> safeCopy = new LinkedList<>(transformationList);
		for (ITransformationInvoker transformationInvoker : safeCopy) {
			midRaster = transformationInvoker.transform(midRaster);
		}
		return midRaster;
	}
	
	
}
