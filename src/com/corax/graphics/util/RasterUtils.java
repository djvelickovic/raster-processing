package com.corax.graphics.util;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class RasterUtils {
	public static WritableRaster createRaster(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		return image.getRaster();
	}

	public static WritableRaster createRasterWithAlpha(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		return image.getRaster();
	}

	public static BufferedImage rasterToImage(WritableRaster raster) {
		BufferedImage image = null;
		switch (raster.getNumBands()) {
		case 3: // rgb
			image = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			image.setData(raster);
			break;
		case 4: // rgba
			image = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			image.setData(raster);
			break;
		default:
			throw new RuntimeException("Invalid type of raster!");
		}
		return image;
	}
	
	public static boolean mapFloatMapToRaster(float fmap[][], float fmin, float fmax, int[] colMin, int[] colMax, WritableRaster raster)
	{
		if(fmap.length != raster.getWidth())
		{
			System.out.println("Width mismatch!");
			return false;
		}
		
		if(fmap[0].length != raster.getHeight())
		{
			System.out.println("Height mismatch!");
			return false;
		}
		
		if(raster.getNumBands() == 3) // RGB
		{
			int[] rgb = new int[3];
			for(int y = 0; y < raster.getHeight(); ++y)
			{
				for(int x = 0; x < raster.getWidth(); ++x)
				{
					float grad = (fmap[x][y] - fmin) / (fmax - fmin);
					if(grad < 0.0f) grad = 0.0f;
					if(grad > 1.0f) grad = 1.0f;
					TransformationUtils.lerpRGB(colMin, colMax, grad, rgb);
					
					if(rgb[0] < 0) rgb[0] = 0;
					if(rgb[1] < 0) rgb[1] = 0;
					if(rgb[2] < 0) rgb[2] = 0;
					
					if(rgb[0] > 255) rgb[0] = 255;
					if(rgb[1] > 255) rgb[1] = 255;
					if(rgb[2] > 255) rgb[2] = 255;
					
					raster.setPixel(x, y, rgb);
				}
			}
		}
		else
		{
			int[] rgba = new int[4];
			for(int y = 0; y < raster.getHeight(); ++y)
			{
				for(int x = 0; x < raster.getWidth(); ++x)
				{
					float grad = (fmap[x][y] - fmin) / (fmax - fmin);
					if(grad < 0.0f) grad = 0.0f;
					if(grad > 1.0f) grad = 1.0f;
					TransformationUtils.lerpRGB(colMin, colMax, grad, rgba);
					
					if(rgba[0] < 0) rgba[0] = 0;
					if(rgba[1] < 0) rgba[1] = 0;
					if(rgba[2] < 0) rgba[2] = 0;
					if(rgba[3] < 0) rgba[3] = 0;
					
					if(rgba[0] > 255) rgba[0] = 255;
					if(rgba[1] > 255) rgba[1] = 255;
					if(rgba[2] > 255) rgba[2] = 255;
					if(rgba[3] > 255) rgba[3] = 255;
					
					raster.setPixel(x, y, rgba);
				}
			}
		}
		
		return true;
	}
	
	
	
	/**
	 * Rasterizacija matrice float vrijednosti u RGB(A) raster linearno interpolirajući kroz gradijent (array) boja.
	 * @param fmap 2D float matrica
	 * @param fmin minimum opsega float vrijednosti (one ispod će biti zaokružene na ovu)
	 * @param fmax maksimum opsega float vrijednosti (one preko će biti zaokružene na ovu)
	 * @param gradient niz RGB(A) boja koje će biti proporcionalno raspoređene u gradijent
	 * @param raster raster u koji će biti upisana slika
	 * @return uspjeh operacije, false ako se dimenzije ne poklapaju ili raster nije podržanog tipa
	 */
	public static boolean mapFloatMapViaGradient(float fmap[][], float fmin, float fmax, int[][] gradient, WritableRaster raster)
	{
		if(fmap.length != raster.getWidth())
		{
			System.out.println("Width mismatch!");
			return false;
		}
		
		if(fmap[0].length != raster.getHeight())
		{
			System.out.println("Height mismatch!");
			return false;
		}
		
		if(raster.getNumBands() == 3) // RGB
		{
			int[] rgb = new int[3];
			for(int y = 0; y < raster.getHeight(); ++y)
			{
				for(int x = 0; x < raster.getWidth(); ++x)
				{
					float grad = (fmap[x][y] - fmin) / (fmax - fmin);
					TransformationUtils.gradientSample(gradient, grad, rgb);
					
					if(rgb[0] < 0) rgb[0] = 0;
					if(rgb[1] < 0) rgb[1] = 0;
					if(rgb[2] < 0) rgb[2] = 0;
					
					if(rgb[0] > 255) rgb[0] = 255;
					if(rgb[1] > 255) rgb[1] = 255;
					if(rgb[2] > 255) rgb[2] = 255;
					
					raster.setPixel(x, y, rgb);
				}
			}
			
			return true;
		}
		else
		{
			System.out.println("FAIL");
			return false;
		}
	}
	
	
	
	public static int[][] imageToGradient(BufferedImage image){
		WritableRaster raster = image.getRaster();
		return rasterToGradient(raster);
	}
	
	public static int[][] rasterToGradient(Raster raster){
		
		int[][] gradient = new int[raster.getWidth()][raster.getNumBands()];
		for(int x = 0; x < raster.getWidth(); x++)
			raster.getPixel(x, 0, gradient[x]);
		return gradient;
	}
}
