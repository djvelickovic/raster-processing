package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.boxblur.BoxBlurInvoker;
import com.corax.transformations.callers.ITransformationInvoker;

public class BoxBlurTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		ITransformationInvoker invoker = new BoxBlurInvoker(10);
		ITransformationInvoker invoker1 = new BoxBlurInvoker(20);
		
		WritableRaster r = invoker.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		r = invoker1.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r));
		
		SwingUtil.showImages(image, images);
	} 
}
