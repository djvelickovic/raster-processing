package com.corax.transformations.flip;

import java.awt.image.Raster;

import com.corax.transformations.callers.ITransformationInvoker;

/**
 * Invoker of Flip transformation
 * 
 * @author Corax
 *
 */
public class FlipInvoker implements ITransformationInvoker {
	/**
	 * Default Flip constant
	 */
	public static final IFlip DEFAULT_FLIP = new Flip();
	
	private FlipDirection flipDirection;
	private IFlip flip;
	
	/**
	 * Constructor. Accepts not null parameters
	 * @param flipDirection
	 * @param flip flip algorithm
	 */
	public FlipInvoker(FlipDirection flipDirection, IFlip flip) {
		if (flipDirection == null || flip == null) {
			throw new IllegalArgumentException();
		}
		this.flipDirection = flipDirection;
		this.flip = flip;
	}
	
	/**
	 * Gets flipDirection, as a flip algorithm uses default flip
	 * 
	 * @param flipDirection
	 */
	public FlipInvoker(FlipDirection flipDirection) {
		this(flipDirection, DEFAULT_FLIP);
	}

	@Override
	public Raster transform(Raster raster) {
		return flip.flip(raster,flipDirection);	
	}
}
