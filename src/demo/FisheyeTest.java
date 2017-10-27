package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.fisheye.FisheyeInvoker;

public class FisheyeTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		IProcessingInvoker invoker = new FisheyeInvoker(0.3f);
		WritableRaster r = invoker.process(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
		
	}
}
