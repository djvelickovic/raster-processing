package com.corax.transformations.sampling;

import java.awt.image.WritableRaster;

import com.corax.transformations.TransformationUtils;

public enum SamplingType {
	BILINEAR {
		@Override
		public void calculateRGB(WritableRaster src, float u, float v, int[] rgb) {
			int width = src.getWidth();
			int height = src.getHeight();
			
			// Radimo "clamp-to-edge" sa koordinatama, kako ne bismo izasli van
			// dimenzija slike. Odnosno, iz perspektive uzimanja uzoraka, svi
			// uzorci van dimenzija ce ponavljati posljednji rubni piksel slike.
			u = TransformationUtils.clamp(u - 0.5f, 0.0f, width - 1.0f);
			v = TransformationUtils.clamp(v - 0.5f, 0.0f, height - 1.0f);
			
			// Bilinearna interpolacija podrazumijeva interpolaciju izmedju
			// cetiri susjedna piksela
			int[] UL = new int[3];
			int[] UR = new int[3];
			int[] LL = new int[3];
			int[] LR = new int[3];

			// Koordinate susjednih piksela slike (oko tacke koju trazimo)
			int x0 = (int)u;
			int y0 = (int)v;
			int x1 = x0 + 1;
			int y1 = y0 + 1;
			
			// Sa +1, X1 i Y1 ponovo mogu biti van slike
			if(x1 >= width) x1 = width - 1;
			if(y1 >= height) y1 = height - 1;
			
			// Decimalni dijelovi koordinata
			float fX = u - x0;
			float fY = v - y0;
			
			// Uzimamo cetiri okolna piksela
			src.getPixel(x0, y0, UL);
			src.getPixel(x1, y0, UR);
			src.getPixel(x0, y1, LL);
			src.getPixel(x1, y1, LR);
			
			// Dva medjurezultata
			int[] a = new int[3];
			int[] b = new int[3];
			
			// Radimo bilinearnu interpolaciju u tri koraka
			TransformationUtils.lerpRGB(UL, UR, fX, a);
			TransformationUtils.lerpRGB(LL, LR, fX, b);
			TransformationUtils.lerpRGB(a, b, fY, rgb);
			
		}
	},
	POINT {
		@Override
		public void calculateRGB(WritableRaster source, float srcX, float srcY, int[] rgb) {
			// TODO Auto-generated method stub
			
		}
	};
	public abstract void calculateRGB(WritableRaster source, float srcX, float srcY, int[] rgb);
}
