package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.vignette.VignetteInvoker;
import com.corax.graphics.transformations.waves.WavesInvoker;

public class WavesTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		
		IProcessingInvoker invoker = new WavesInvoker(0.02f, 10.2f);
		IProcessingInvoker invoker1 = new WavesInvoker(0.2f,10.0f);
		
		WritableRaster r = invoker.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	}
}
