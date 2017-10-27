package com.corax.transformations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class TransformationUtils {

	public static int clamp(int value, int min, int max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}

	public static int saturate(int value) {
		return clamp(value, 0, 255);
	}

	/**
	 * Linear interpolation between two RGB colors
	 * @param a starting color
	 * @param b ending color
	 * @param x factor [0, 1]
	 * @param result RGB int array that can be used
	 */
	public static void lerpRGB(int[] a, int[] b, float x, int[] result)
	{
		result[0] = (int)(a[0] + (b[0] - a[0]) * x);
		result[1] = (int)(a[1] + (b[1] - a[1]) * x);
		result[2] = (int)(a[2] + (b[2] - a[2]) * x);
	}
	
	/**
	 * Linear interpolation between two RGBA colors
	 * @param a starting color
	 * @param b ending color
	 * @param x factor [0, 1]
	 * @param result RGBA int array that can be used
	 */
	public static void lerpRGBA(int[] a, int[] b, float x, int[] result)
	{
		result[0] = (int)(a[0] + (b[0] - a[0]) * x);
		result[1] = (int)(a[1] + (b[1] - a[1]) * x);
		result[2] = (int)(a[2] + (b[2] - a[2]) * x);
		result[3] = (int)(a[3] + (b[3] - a[3]) * x);
	}
	
	/**
	 * Linear interpolation between two RGB colors
	 * @param a starting color
	 * @param b ending color
	 * @param x factor [0, 1]
	 * @param result RGB float array that can be used
	 */
	public static void lerpRGB(int[] a, int[] b, float x, float[] result)
	{
		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
	}
	
	/**
	 * Linear interpolation between two RGBA colors
	 * @param a starting color
	 * @param b ending color
	 * @param x factor [0, 1]
	 * @param result RGBA float array that can be used
	 */
	public static void lerpRGBA(int[] a, int[] b, float x, float[] result)
	{
		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
		result[3] = a[3] + (b[3] - a[3]) * x;
	}
	
	/**
	 * Linear interpolation between two RGB colors
	 * @param a starting color
	 * @param b ending color
	 * @param x factor [0, 1]
	 * @param result RGB float array that can be used
	 */
	public static void lerpRGB(float[] a, float[] b, float x, float[] result) {
		
		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
	}
	
	/**
	 * Linear interpolation between two RGBA colors
	 * @param a starting color
	 * @param b ending color
	 * @param x factor [0, 1]
	 * @param result RGBA float array that can be used
	 */
	public static void lerpRGBA(float[] a, float[] b, float x, float[] result){
		
		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
		result[3] = a[3] + (b[3] - a[3]) * x;
	}
	
	/**
	 * Bounds value
	 * @param value - value that needs bounding
	 * @return value from 0 to 255 (inclusive)
	 */
	public static int clamp(int value)
	{
		if(value < 0) return 0;
		if(value > 255) return 255;
		return value;
	}
	
	

	/**
	 * Bounds value
	 * @param value - value that needs bounding
	 * @return value from 0f to 1f (inclusive)
	 */
	public static float clamp(float value)
	{
		if(value < 0.0f) return 0.0f;
		if(value > 1.0f) return 1.0f;
		return value;
	}
	
	/**
	 * Bounds value to desired boundaries
	 * @param value
	 * @param min
	 * @param max
	 * @return
	 */
	public static float clamp(float value, float min, float max)
	{
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	/**
	 * Bounds value
	 * @param value - value that needs bounding
	 * @return value from 0 to 1 (inclusive)
	 */
	public static double clamp(double value)
	{
		if(value < 0.0) return 0.0;
		if(value > 1.0) return 1.0;
		return value;
	}
	
	/**
	 * Bounds value to desired boundaries
	 * @param value
	 * @param min
	 * @param max
	 * @return
	 */
	public static double clamp(double value, double min, double max)
	{
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	
	public static int lerp(int a, int b, float x){
		return (int)(a + (b - a) * x);
	}
	
	/**
	 * Linear interpolation between two float numbers
	 * @param a 
	 * @param b 
	 * @param x 
	 * @return 
	 */
	public static float lerp(float a, float b, float x){
		return a + (b - a) * x;
	}
	
	/**
	 * Cosinus interpolation
	 * @param a 
	 * @param b 
	 * @param x 
	 * @return 
	 */
	public static int cosInterpolation(int a, int b, float x)
	{
		x = (1.0f - x) * 3.14159265359f;
		return (int)(a + (b - a) * ((float)Math.cos(x) * 0.5f + 0.5f));
	}
	
	/**
	 * Cosinus interpolation
	 * @param a 
	 * @param b 
	 * @param x 
	 * @return 
	 */
	public static float cosInterpoplation(float a, float b, float x)
	{
		x = (1.0f - x) * 3.14159265359f;
		return a + (b - a) * ((float)Math.cos(x) * 0.5f + 0.5f);
	}
	public static void clampRGB(int[] color)
	{
		if(color[0] < 0) color[0] = 0;
		if(color[1] < 0) color[1] = 0;
		if(color[2] < 0) color[2] = 0;
		if(color[0] > 255) color[0] = 255;
		if(color[1] > 255) color[1] = 255;
		if(color[2] > 255) color[2] = 255;
	}
	
	/**
	 * Clamgping rgba between 0 and 255
	 * @param color niz koji će biti ograničen
	 */
	public static void clampRGBA(int[] color)
	{
		if(color[0] < 0) color[0] = 0;
		if(color[1] < 0) color[1] = 0;
		if(color[2] < 0) color[2] = 0;
		if(color[3] < 0) color[3] = 0;
		if(color[0] > 255) color[0] = 255;
		if(color[1] > 255) color[1] = 255;
		if(color[2] > 255) color[2] = 255;
		if(color[3] > 255) color[3] = 255;
	}
	
	
}
