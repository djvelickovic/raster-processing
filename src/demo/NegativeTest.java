package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.transformations.negative.NegativeInvoker;

public class NegativeTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		NegativeInvoker negativeInvoker = new NegativeInvoker();
		WritableRaster r = negativeInvoker.transform(image.getRaster());
		
		
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
		
	}
}
