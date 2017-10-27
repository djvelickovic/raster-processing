package demo;

import java.awt.image.WritableRaster;

import com.corax.graphics.generators.perlinnoise.IPerlinNoiseGenerator;
import com.corax.graphics.generators.perlinnoise.PerlinNoiseGenerator;

public class PelinOctavesTest {
	public static void main(String[] args){
		
		IPerlinNoiseGenerator perlinNoise = new PerlinNoiseGenerator();
		int[] firstColor = {255,255, 255};
		int[] secondColor = {0,0, 0};
		WritableRaster r = perlinNoise.generatePerlinNoise(9, 0.75f, firstColor, secondColor);
		
		SwingUtil.showImage(SwingUtil.rasterToImage(r));
		
		
	}
}
