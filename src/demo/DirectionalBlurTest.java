package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.directionalblur.DirectionalBlurInvoker;

public class DirectionalBlurTest {
	public static void main(String[] args) {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		IProcessingInvoker invoker = new DirectionalBlurInvoker(10.0f, 20.0f);
		WritableRaster r = invoker.process(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
	}
}
