package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.edgedetection.EdgeDetectionInvoker;

public class EdgeDetectionTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();

		
		for (int i = 1; i < 10; i++) {
			IProcessingInvoker invoker = new EdgeDetectionInvoker(i);
			WritableRaster r = invoker.process(image.getRaster());
			images.add(SwingUtil.rasterToImage(r));
		}
		
		SwingUtil.showImages(image, images);
	} 
}
