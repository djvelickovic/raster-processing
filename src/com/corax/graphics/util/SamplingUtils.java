package com.corax.graphics.util;

import java.awt.image.WritableRaster;

public class SamplingUtils {
	
	public static void pointSample(WritableRaster src, float u, float v, int[] color)
	{
		int x = (int)u;
		int y = (int)v;
		if(x < 0) x = 0;
		if(y < 0) y = 0;
		if(x >= src.getWidth()) x = src.getWidth() - 1;
		if(y >= src.getHeight()) x = src.getHeight() - 1;
		src.getPixel(x, y, color);
	}
	
	public static void bilSampleA(WritableRaster src, float u, float v, int[] color)
	{
		float[] a = new float[4];
		float[] b = new float[4];
		
		int[] UL = new int[4];
		int[] UR = new int[4];
		int[] LL = new int[4];
		int[] LR = new int[4];

		int x0 = (int)u;
		int y0 = (int)v;
		int x1 = x0 + 1;
		int y1 = y0 + 1;
		
		u -= x0;
		v -= y0;
		
		if(x0 < 0) x0 = 0;
		if(y0 < 0) y0 = 0;
		if(x1 < 0) x1 = 0;
		if(y1 < 0) y1 = 0;
		
		if(x0 >= src.getWidth()) x0 = src.getWidth() - 1;
		if(y0 >= src.getHeight()) y0 = src.getHeight() - 1;
		if(x1 >= src.getWidth()) x1 = src.getWidth() - 1;
		if(y1 >= src.getHeight()) y1 = src.getHeight() - 1;
		
		src.getPixel(x0, y0, UL);
		src.getPixel(x1, y0, UR);
		src.getPixel(x0, y1, LL);
		src.getPixel(x1, y1, LR);
		
		TransformationUtils.lerpRGBA(UL, UR, u, a);
		TransformationUtils.lerpRGBA(LL, LR, u, b);
		
		color[0] = (int)(TransformationUtils.lerp(a[0], b[0], v));
		color[1] = (int)(TransformationUtils.lerp(a[1], b[1], v));
		color[2] = (int)(TransformationUtils.lerp(a[2], b[2], v));
		color[2] = (int)(TransformationUtils.lerp(a[3], b[3], v));
		
		TransformationUtils.clampRGBA(color);
	}
	
	public static void bilSample(WritableRaster src, float u, float v, int[] color){
		float[] a = new float[3];
		float[] b = new float[3];
		
		int[] UL = new int[3];
		int[] UR = new int[3];
		int[] LL = new int[3];
		int[] LR = new int[3];

		int x0 = (int)u;
		int y0 = (int)v;
		int x1 = x0 + 1;
		int y1 = y0 + 1;
		
		u -= x0;
		v -= y0;
		
		if(x0 < 0) x0 = 0;
		if(y0 < 0) y0 = 0;
		if(x1 < 0) x1 = 0;
		if(y1 < 0) y1 = 0;
		
		if(x0 >= src.getWidth()) x0 = src.getWidth() - 1;
		if(y0 >= src.getHeight()) y0 = src.getHeight() - 1;
		if(x1 >= src.getWidth()) x1 = src.getWidth() - 1;
		if(y1 >= src.getHeight()) y1 = src.getHeight() - 1;
		
		src.getPixel(x0, y0, UL);
		src.getPixel(x1, y0, UR);
		src.getPixel(x0, y1, LL);
		src.getPixel(x1, y1, LR);
		
		TransformationUtils.lerpRGB(UL, UR, u, a);
		TransformationUtils.lerpRGB(LL, LR, u, b);
		
		color[0] = (int)(TransformationUtils.lerp(a[0], b[0], v));
		color[1] = (int)(TransformationUtils.lerp(a[1], b[1], v));
		color[2] = (int)(TransformationUtils.lerp(a[2], b[2], v));
		
		TransformationUtils.clampRGB(color);
	}
	
}
