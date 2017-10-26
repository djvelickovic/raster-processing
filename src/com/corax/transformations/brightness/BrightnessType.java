package com.corax.transformations.brightness;

public enum BrightnessType {
	BRIGHTNESS {
		@Override
		public void calculateBrightness(float intensity, int[] rgb) {
			
			
			rgb[0] += (int)(rgb[0] * intensity );
			rgb[0] = rgb[0] < 0 ? 255 : rgb[0];
			
			rgb[1] += (int)(rgb[1] * intensity );
			rgb[1] = rgb[1] > 255 ? 255 : rgb[1];
			
			rgb[2] += (int)(rgb[2] * intensity );
			rgb[2] = rgb[2] > 255 ? 255 : rgb[2];
		}
	},
	DARKNESS {
		@Override
		public void calculateBrightness(float intensity, int[] rgb) {
			// TODO Auto-generated method stub
			
		}
	};
	private BrightnessType() {}
	
	public abstract void calculateBrightness(float intensity, int[] rgb);
	
}
