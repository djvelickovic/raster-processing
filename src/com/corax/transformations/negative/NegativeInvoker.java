package com.corax.transformations.negative;

import java.awt.image.Raster;

import com.corax.transformations.callers.ITransformationInvoker;

/**
 * 
 * Invoker of negative raster transformation
 * 
 * @author Corax
 *
 */
public class NegativeInvoker implements ITransformationInvoker {
	/**
	 * Constants of default negative algorithm
	 */
	public static final INegative DEFAULT_NEGATIVE = new Negative();
	
	private INegative negative;
	
	public NegativeInvoker(INegative negative) {
		super();
		if (negative == null) {
			throw new IllegalArgumentException();
		}
		this.negative = negative;
	}
	
	public NegativeInvoker() {
		this(DEFAULT_NEGATIVE);
	}
	

	@Override
	public Raster transform(Raster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return negative.negative(source);
	}

}
