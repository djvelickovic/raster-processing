package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.noise.NoiseInvoker;
import com.corax.transformations.noise.NoiseType;

public class NoiseTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		
		ITransformationInvoker invoker = new NoiseInvoker(NoiseType.COLORED,0.2f);
		ITransformationInvoker invoker1 = new NoiseInvoker(NoiseType.MONOCHROME, 0.6f);
		
		WritableRaster r = invoker.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	}
	
}
