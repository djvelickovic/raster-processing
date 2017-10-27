package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.posterize.PosterizeInvoker;

public class PosterizationTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();

		float step = 0.1f;
		for (int i = 1; i < 8; i++) {
			IProcessingInvoker invoker = new PosterizeInvoker(i * step);
			WritableRaster r = invoker.process(image.getRaster());
			images.add(SwingUtil.rasterToImage(r));
		}

		SwingUtil.showImages(image, images);
	}
}
