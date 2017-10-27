package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.noise.NoiseInvoker;
import com.corax.graphics.transformations.noise.NoiseType;

public class NoiseTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		
		IProcessingInvoker invoker = new NoiseInvoker(NoiseType.COLORED,0.2f);
		IProcessingInvoker invoker1 = new NoiseInvoker(NoiseType.MONOCHROME, 0.6f);
		
		WritableRaster r = invoker.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	}
	
}
