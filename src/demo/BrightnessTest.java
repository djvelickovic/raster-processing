package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.brightness.BrightnessInvoker;

public class BrightnessTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> brightImages = new ArrayList<>();

		float step = 0.5f;
		brightImages.add(image);
		
		for (int i = 1; i < 10; i++) {
			IProcessingInvoker invoker = new BrightnessInvoker(i * step);
			WritableRaster r = invoker.process(image.getRaster());
			brightImages.add(SwingUtil.rasterToImage(r));
		}
		
		List<Image> darkImages = new ArrayList<>();
		float darkstep = -0.1f;
		for (int i = 1; i < 10; i++) {
			IProcessingInvoker invoker = new BrightnessInvoker(i * darkstep);
			WritableRaster r = invoker.process(image.getRaster());
			darkImages.add(SwingUtil.rasterToImage(r));
		}
		
		SwingUtil.showImages(image, brightImages);
		SwingUtil.showImages(image, darkImages);
	}
}
