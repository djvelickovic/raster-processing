package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.radialblur.RadialBlurInvoker;

public class RadialBlurTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		IProcessingInvoker invoker = new RadialBlurInvoker(0.05f);
		WritableRaster r = invoker.process(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
		
	}
}
