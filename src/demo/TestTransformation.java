package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.graphics.callers.IProcessingInvoker;
import com.corax.graphics.transformations.blur.BlurInvoker;
import com.corax.graphics.transformations.flip.FlipDirection;
import com.corax.graphics.transformations.flip.FlipInvoker;
import com.corax.graphics.transformations.grayscale.GrayscaleInvoker;
import com.corax.graphics.transformations.manager.ITransformationListener;
import com.corax.graphics.transformations.manager.Transformation;
import com.corax.graphics.transformations.posterize.PosterizeInvoker;
import com.corax.graphics.transformations.sharpen.SharpenInvoker;
import com.corax.graphics.transformations.vignette.VignetteInvoker;

public class TestTransformation {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		Transformation transformation = new Transformation();
		
		Transformation sharpen = new Transformation();
		sharpen.addTransformation(new PosterizeInvoker(0.01f))
			.addTransformation(new SharpenInvoker(0.8f));
		
		Transformation blurTransformations = new Transformation();
		blurTransformations.addTransformation(new BlurInvoker(BlurInvoker.DEFAULT_GAUSSIAN_BLUR_ALGORITHM, 1))
			.addTransformation(new VignetteInvoker(1f,1f));
		
		transformation.addTransformation(sharpen)
			.addTransformation(new GrayscaleInvoker())
			.addTransformation(blurTransformations);
		
		List<Image> images = new ArrayList<>();
		
		
		
		transformation.process(image.getRaster(),new ITransformationListener() {
			
			@Override
			public void action(IProcessingInvoker transformationInvoker, WritableRaster result) {
				BufferedImage bi = SwingUtil.rasterToImage(result);
				images.add(bi);
			}
		});
		
//		SwingUtil.showImages(image,SwingUtil.rasterToImage(r, image.getColorModel()));
		
		SwingUtil.showImages(image,images);
		
	}
}
