package demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.corax.transformations.callers.ITransformationInvoker;
import com.corax.transformations.flip.FlipDirection;
import com.corax.transformations.flip.FlipInvoker;
import com.corax.transformations.grayscale.GrayscaleInvoker;
import com.corax.transformations.manager.ITransformationListener;
import com.corax.transformations.manager.Transformation;
import com.corax.transformations.negative.NegativeInvoker;

public class TestTransformation {
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = SwingUtil.loadImage(TestCommons.IMAGE_FILE);
		
		Transformation transformation = new Transformation();
		transformation.addTransformation(new NegativeInvoker())
			.addTransformation(new FlipInvoker(FlipDirection.HORIZONTAL))
			.addTransformation(new GrayscaleInvoker())
			.addTransformation(new FlipInvoker(FlipDirection.VERTICAL));
		
		
		
		List<Image> images = new ArrayList<>();
		
		
		
		WritableRaster r = transformation.transform(image.getRaster(),new ITransformationListener() {
			
			@Override
			public void action(ITransformationInvoker transformationInvoker, WritableRaster result) {
				BufferedImage bi = SwingUtil.rasterToImage(result, image.getColorModel());
				images.add(bi);
			}
		});
		
//		SwingUtil.showImages(image,SwingUtil.rasterToImage(r, image.getColorModel()));
		
		SwingUtil.showImages(image,images);
		
	}
}
