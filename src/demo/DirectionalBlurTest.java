package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.directionalblur.DirectionalBlurInvoker;

public class DirectionalBlurTest {
	public static void main(String[] args) {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		ITransformationInvoker invoker = new DirectionalBlurInvoker(10.0f, 20.0f);
		WritableRaster r = invoker.transform(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
	}
}
