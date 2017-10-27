package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.vignette.VignetteInvoker;

public class VignetteTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		
		ITransformationInvoker invoker = new VignetteInvoker();
		ITransformationInvoker invoker1 = new VignetteInvoker(1f, 0.1f);
		
		WritableRaster r = invoker.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	}
}
