package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.blur.BlurInvoker;
import com.corax.transformations.callers.ITransformationInvoker;

public class BlurTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		ITransformationInvoker invoker = new BlurInvoker(BlurInvoker.DEFAULT_BOX_BLUR_ALGORITHM,10);
		ITransformationInvoker invoker1 = new BlurInvoker(BlurInvoker.DEFAULT_GAUSSIAN_BLUR_ALGORITHM,10);
		ITransformationInvoker invoker2 = new BlurInvoker(BlurInvoker.DEFAULT_SAMPLE_BLUR_ALGORITHM,10);
		
		WritableRaster r = null;
		r = invoker.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker2.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	} 
}
