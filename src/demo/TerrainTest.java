package demo;

import java.awt.image.WritableRaster;

import com.corax.graphics.generators.gradientperlin.GradientPerlinGenerator;
import com.corax.graphics.util.RasterUtils;

public class TerrainTest {
	public static void main(String[] args) {
		GradientPerlinGenerator terrainGenerator = new GradientPerlinGenerator();
		
		WritableRaster raster = terrainGenerator.generateGradientPerlin(true, 10, 0.7f, RasterUtils.imageToGradient(SwingUtil.loadImage(TestCommons.GRADIENT_FILE)));
		
		SwingUtil.showImage(RasterUtils.rasterToImage(raster));
	}
}
