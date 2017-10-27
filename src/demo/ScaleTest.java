package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.TransformationUtils;
import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.sampling.SamplingInvoker;

public class ScaleTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();

		ITransformationInvoker invoker = new SamplingInvoker(200,100);
		ITransformationInvoker invoker1 = new SamplingInvoker(800,700);
		
		WritableRaster r = invoker.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));

		r = invoker1.transform(r);
		images.add(TransformationUtils.rasterToImage(r));

		SwingUtil.showImages(image, images);
	}
}
