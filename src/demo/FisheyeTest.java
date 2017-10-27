package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.fisheye.FisheyeInvoker;

public class FisheyeTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		ITransformationInvoker invoker = new FisheyeInvoker(0.3f);
		WritableRaster r = invoker.transform(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
		
	}
}
