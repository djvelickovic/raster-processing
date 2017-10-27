package com.corax.graphics.util;

public final class TransformationUtils {

	public TransformationUtils() {}
	
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
	 * 
	 * @param a
	 *            starting color
	 * @param b
	 *            ending color
	 * @param x
	 *            factor [0, 1]
	 * @param result
	 *            RGB int array that can be used
	 */
	public static void lerpRGB(int[] a, int[] b, float x, int[] result) {
		result[0] = (int) (a[0] + (b[0] - a[0]) * x);
		result[1] = (int) (a[1] + (b[1] - a[1]) * x);
		result[2] = (int) (a[2] + (b[2] - a[2]) * x);
	}

	/**
	 * Linear interpolation between two RGBA colors
	 * 
	 * @param a
	 *            starting color
	 * @param b
	 *            ending color
	 * @param x
	 *            factor [0, 1]
	 * @param result
	 *            RGBA int array that can be used
	 */
	public static void lerpRGBA(int[] a, int[] b, float x, int[] result) {
		result[0] = (int) (a[0] + (b[0] - a[0]) * x);
		result[1] = (int) (a[1] + (b[1] - a[1]) * x);
		result[2] = (int) (a[2] + (b[2] - a[2]) * x);
		result[3] = (int) (a[3] + (b[3] - a[3]) * x);
	}

	/**
	 * Linear interpolation between two RGB colors
	 * 
	 * @param a
	 *            starting color
	 * @param b
	 *            ending color
	 * @param x
	 *            factor [0, 1]
	 * @param result
	 *            RGB float array that can be used
	 */
	public static void lerpRGB(int[] a, int[] b, float x, float[] result) {
		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
	}

	/**
	 * Linear interpolation between two RGBA colors
	 * 
	 * @param a
	 *            starting color
	 * @param b
	 *            ending color
	 * @param x
	 *            factor [0, 1]
	 * @param result
	 *            RGBA float array that can be used
	 */
	public static void lerpRGBA(int[] a, int[] b, float x, float[] result) {
		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
		result[3] = a[3] + (b[3] - a[3]) * x;
	}

	/**
	 * Linear interpolation between two RGB colors
	 * 
	 * @param a
	 *            starting color
	 * @param b
	 *            ending color
	 * @param x
	 *            factor [0, 1]
	 * @param result
	 *            RGB float array that can be used
	 */
	public static void lerpRGB(float[] a, float[] b, float x, float[] result) {

		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
	}

	/**
	 * Linear interpolation between two RGBA colors
	 * 
	 * @param a
	 *            starting color
	 * @param b
	 *            ending color
	 * @param x
	 *            factor [0, 1]
	 * @param result
	 *            RGBA float array that can be used
	 */
	public static void lerpRGBA(float[] a, float[] b, float x, float[] result) {

		result[0] = a[0] + (b[0] - a[0]) * x;
		result[1] = a[1] + (b[1] - a[1]) * x;
		result[2] = a[2] + (b[2] - a[2]) * x;
		result[3] = a[3] + (b[3] - a[3]) * x;
	}

	/**
	 * Bounds value
	 * 
	 * @param value
	 *            - value that needs bounding
	 * @return value from 0 to 255 (inclusive)
	 */
	public static int clamp(int value) {
		if (value < 0)
			return 0;
		if (value > 255)
			return 255;
		return value;
	}

	/**
	 * Bounds value
	 * 
	 * @param value
	 *            - value that needs bounding
	 * @return value from 0f to 1f (inclusive)
	 */
	public static float clamp(float value) {
		if (value < 0.0f)
			return 0.0f;
		if (value > 1.0f)
			return 1.0f;
		return value;
	}

	/**
	 * Bounds value to desired boundaries
	 * 
	 * @param value
	 * @param min
	 * @param max
	 * @return
	 */
	public static float clamp(float value, float min, float max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}

	/**
	 * Bounds value
	 * 
	 * @param value
	 *            - value that needs bounding
	 * @return value from 0 to 1 (inclusive)
	 */
	public static double clamp(double value) {
		if (value < 0.0)
			return 0.0;
		if (value > 1.0)
			return 1.0;
		return value;
	}

	/**
	 * Bounds value to desired boundaries
	 * 
	 * @param value
	 * @param min
	 * @param max
	 * @return
	 */
	public static double clamp(double value, double min, double max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}

	public static int lerp(int a, int b, float x) {
		return (int) (a + (b - a) * x);
	}

	/**
	 * Linear interpolation between two float numbers
	 * 
	 * @param a
	 * @param b
	 * @param x
	 * @return
	 */
	public static float lerp(float a, float b, float x) {
		return a + (b - a) * x;
	}

	/**
	 * Cosinus interpolation
	 * 
	 * @param a
	 * @param b
	 * @param x
	 * @return
	 */
	public static int cosInterpolation(int a, int b, float x) {
		x = (1.0f - x) * 3.14159265359f;
		return (int) (a + (b - a) * ((float) Math.cos(x) * 0.5f + 0.5f));
	}

	/**
	 * Cosinus interpolation
	 * 
	 * @param a
	 * @param b
	 * @param x
	 * @return
	 */
	public static float cosInterpolation(float a, float b, float x) {
		x = (1.0f - x) * 3.14159265359f;
		return a + (b - a) * ((float) Math.cos(x) * 0.5f + 0.5f);
	}

	public static void clampRGB(int[] color) {
		if (color[0] < 0)
			color[0] = 0;
		if (color[1] < 0)
			color[1] = 0;
		if (color[2] < 0)
			color[2] = 0;
		if (color[0] > 255)
			color[0] = 255;
		if (color[1] > 255)
			color[1] = 255;
		if (color[2] > 255)
			color[2] = 255;
	}

	/**
	 * Clamgping rgba between 0 and 255
	 * 
	 * @param color
	 *            niz koji će biti ograni�?en
	 */
	public static void clampRGBA(int[] color) {
		if (color[0] < 0)
			color[0] = 0;
		if (color[1] < 0)
			color[1] = 0;
		if (color[2] < 0)
			color[2] = 0;
		if (color[3] < 0)
			color[3] = 0;
		if (color[0] > 255)
			color[0] = 255;
		if (color[1] > 255)
			color[1] = 255;
		if (color[2] > 255)
			color[2] = 255;
		if (color[3] > 255)
			color[3] = 255;
	}

	public static void floatMapRescale(float[][] source, float[][] destination) {
		int sourceW = source.length;
		int sourceH = source[0].length;
		int targetW = destination.length;
		int targetH = destination[0].length;

		for (int x = 0; x < targetW; x++) {
			float fx = (float) x / targetW;

			for (int y = 0; y < targetH; y++) {
				float fy = (float) y / targetH;

				float sx = fx * sourceW;
				float sy = fy * sourceH;

				int isx0 = (int) sx;
				int isy0 = (int) sy;
				int isx1 = isx0 + 1;
				int isy1 = isy0 + 1;
				if (isx1 >= sourceW)
					isx1 = sourceW - 1;
				if (isy1 >= sourceH)
					isy1 = sourceH - 1;

				sx -= isx0;
				sy -= isy0;

				float a = lerp(source[isx0][isy0], source[isx1][isy0], sx);
				float b = lerp(source[isx0][isy1], source[isx1][isy1], sx);

				destination[x][y] = lerp(a, b, sy);
			}
		}
	}

	public static void floatMapRescaleCos(float[][] source, float[][] destination) {
		int sourceW = source.length;
		int sourceH = source[0].length;
		int targetW = destination.length;
		int targetH = destination[0].length;

		for (int x = 0; x < targetW; x++) {
			float fx = (float) x / targetW;

			for (int y = 0; y < targetH; y++) {
				float fy = (float) y / targetH;

				float sx = fx * sourceW;
				float sy = fy * sourceH;

				int isx0 = (int) sx;
				int isy0 = (int) sy;
				int isx1 = isx0 + 1;
				int isy1 = isy0 + 1;
				if (isx1 >= sourceW)
					isx1 = sourceW - 1;
				if (isy1 >= sourceH)
					isy1 = sourceH - 1;

				sx -= isx0;
				sy -= isy0;

				float a = cosInterpolation(source[isx0][isy0], source[isx1][isy0], sx);
				float b = cosInterpolation(source[isx0][isy1], source[isx1][isy1], sx);

				destination[x][y] = cosInterpolation(a, b, sy);
			}
		}
	}

	public static void floatMapMAD(float[][] source, float[][] destination, float multiplier) {
		if (source.length != destination.length) {
			System.out.println("floatMapMAD width mismatch!");
			return;
		}

		if (source[0].length != destination[0].length) {
			System.out.println("floatMapMAD height mismatch!");
			return;
		}

		for (int x = 0; x < source.length; ++x) {
			for (int y = 0; y < source.length; ++y) {
				destination[x][y] += source[x][y] * multiplier;
			}
		}
	}

	/**
	 * Obavlja linearnu interpolaciju kroz niz boja (gradijent), gdje će za x = 0
	 * rezultat biti boja na indeksu [0], a za x = 1 će biti [length - 1], sa
	 * interpoliranim rezultatima između.
	 * 
	 * @param gradient
	 *            niz boja proizvoljne dužine
	 * @param x
	 *            faktor za interpolaciju, od 0 do 1
	 * @param result
	 *            unaprijed alociran niz od bar 3 elementa (za RGB) u koji će biti
	 *            upisan rezultat
	 */
	public static void gradientSample(int[][] gradient, float x, int[] result) {
		if (x < 0.0f)
			x = 0.0f;
		if (x > 1.0f)
			x = 1.0f;

		x *= (gradient.length - 1);
		int ix0 = (int) x;
		x -= ix0;
		int ix1 = ix0 + 1;
		if (ix1 >= gradient.length)
			ix1 = gradient.length - 1;

		lerpRGB(gradient[ix0], gradient[ix1], x, result);
	}

}
