package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.edgedetection.EdgeDetectionInvoker;

public class EdgeDetectionTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();

		
		for (int i = 1; i < 10; i++) {
			ITransformationInvoker invoker = new EdgeDetectionInvoker(i);
			WritableRaster r = invoker.transform(image.getRaster());
			images.add(SwingUtil.rasterToImage(r, image.getColorModel()));
		}
		
		SwingUtil.showImages(image, images);
	}
}
