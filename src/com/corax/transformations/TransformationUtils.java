package com.corax.transformations;

public class TransformationUtils {
	
	
	public static int clamp(int value, int min, int max)
	{
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	public static int saturate(int value)
	{
		return clamp(value, 0, 255);
	}
}
