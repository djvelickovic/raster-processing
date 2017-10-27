package demo;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import com.corax.graphics.transformations.flip.FlipDirection;
import com.corax.graphics.transformations.flip.FlipInvoker;

public class FlipTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		FlipInvoker flipInvoker = new FlipInvoker(FlipDirection.HORIZONTAL);
		WritableRaster r = flipInvoker.process(image.getRaster());
		
		SwingUtil.showImages(image,SwingUtil.rasterToImage(r));
		
	}
}
