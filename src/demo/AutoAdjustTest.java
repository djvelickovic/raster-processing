package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.autoadjust.AutoAdjustInvoker;
import com.corax.transformations.callers.ITransformationInvoker;

public class AutoAdjustTest {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);

		List<Image> images = new ArrayList<>();
		ITransformationInvoker invoker = new AutoAdjustInvoker(AutoAdjustInvoker.DEFAULT_AUTOADJUST,5f);
		ITransformationInvoker invoker1 = new AutoAdjustInvoker(AutoAdjustInvoker.DEFAULT_RGBAUTOADJUST,5f);
		
		WritableRaster r = invoker.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r, image.getColorModel()));
		
		r = invoker1.transform(image.getRaster());
		images.add(SwingUtil.rasterToImage(r, image.getColorModel()));
		
		SwingUtil.showImages(image, images);
	}
}
