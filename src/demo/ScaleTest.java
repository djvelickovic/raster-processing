package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.sampling.SamplingInvoker;
import com.corax.graphics.util.RasterUtils;

public class ScaleTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();

		IProcessingInvoker invoker = new SamplingInvoker(200,100);
		IProcessingInvoker invoker1 = new SamplingInvoker(800,700);
		
		WritableRaster r = invoker.process(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));

		r = invoker1.process(r);
		images.add(RasterUtils.rasterToImage(r));

		SwingUtil.showImages(image, images);
	}
}
