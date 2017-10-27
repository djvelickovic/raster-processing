package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.blur.BlurInvoker;

public class BlurTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		IProcessingInvoker invoker = new BlurInvoker(BlurInvoker.DEFAULT_BOX_BLUR_ALGORITHM,10);
		IProcessingInvoker invoker1 = new BlurInvoker(BlurInvoker.DEFAULT_GAUSSIAN_BLUR_ALGORITHM,10);
		IProcessingInvoker invoker2 = new BlurInvoker(BlurInvoker.DEFAULT_SAMPLE_BLUR_ALGORITHM,10);
		
		WritableRaster r = null;
		r = invoker.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker2.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	} 
}
