package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.transformations.flip.FlipDirection;
import com.corax.transformations.flip.FlipInvoker;

public class FlipTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		BufferedImage image2 = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		FlipInvoker flipInvoker = new FlipInvoker(FlipDirection.HORIZONTAL);
		WritableRaster r = flipInvoker.transform(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r,image2.getColorModel()));
		
	}
}
