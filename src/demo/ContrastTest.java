package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.contrast.ContrastInvoker;

public class ContrastTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> brightImages = new ArrayList<>();

		float step = 0.1f;
		
		for (int i = 0; i < 10; i++) {
			ITransformationInvoker invoker = new ContrastInvoker(i * step);
//			ITransformationInvoker invoker = new ContrastInvoker(1.1f);
			WritableRaster r = invoker.transform(image.getRaster());
			brightImages.add(SwingUtil.rasterToImage(r, image.getColorModel()));
		}
		
		List<Image> darkImages = new ArrayList<>();
		float darkstep = -0.2f;
		for (int i = 0; i < 10; i++) {
			ITransformationInvoker invoker = new ContrastInvoker(i * darkstep);
			WritableRaster r = invoker.transform(image.getRaster());
			darkImages.add(SwingUtil.rasterToImage(r, image.getColorModel()));
		}
		
		SwingUtil.showImages(image, brightImages);
		SwingUtil.showImages(image, darkImages);
	}
}