package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.grayscale.GrayscaleInvoker;
import com.corax.transformations.grayscale.GrayscaleType;

public class GrayscaleTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		
		for (GrayscaleType gt : GrayscaleType.values()) {
			ITransformationInvoker invoker = new GrayscaleInvoker(gt);
			WritableRaster r = invoker.transform(image.getRaster());
			images.add(SwingUtil.rasterToImage(r));
		}
		
		SwingUtil.showImages(image, images, "Gray Scale");
	}
}
