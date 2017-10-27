package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.radialblur.RadialBlurInvoker;

public class RadialBlurTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		ITransformationInvoker invoker = new RadialBlurInvoker(0.05f);
		WritableRaster r = invoker.transform(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
		
	}
}
