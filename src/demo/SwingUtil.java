package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.corax.transformations.RasterUtils;
import com.corax.transformations.TransformationUtils;


/**
 * Util class for transformation tests
 * 
 * 
 * @author Corax
 *
 */
public class SwingUtil {
	
	/**
	 * Private constructor
	 */
	private SwingUtil() {
		throw new IllegalStateException();
	}
	
	/**
	 * Loads image from string path to BufferedImage
	 * @param path path of image
	 * @return returns readed buffered image
	 * @throws IOException
	 */
	public static BufferedImage loadImage(String fileName) {
		BufferedImage image = null;
		try {
			if (fileName.startsWith("/")) {
				fileName = fileName.substring(1);
				URL imgURL = ClassLoader.getSystemResource(fileName);
				image = ImageIO.read(imgURL.toURI().toURL());
			} else {
				image = ImageIO.read(new File(fileName));
			}
		} catch (Exception e) {
			System.err.println("Error loading: "+fileName);
		}
		return image;
	}
	
	/**
	 * Loads image from file
	 * @param image
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage loadImage(File image) {
		BufferedImage im = null;
		try {
			im = ImageIO.read(image);
		} catch (Exception e) {
			System.err.println("Error loading image.");
		}
		return im;
	}
	
	/**
	 * This method creates JFrame and shows image on it
	 * 
	 * @param image
	 */
	public static void showImage(Image image) {
		showImage(image, "Default title");
	}
	
	/**
	 * This method creates JFrame and shows image on it with chosen title
	 * @param image
	 * @param title
	 */
	public static void showImage(Image image, String title) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Shows two images, one original, one after transformation
	 * @param changed
	 * @param original
	 */
	public static void showImages(Image changed,Image original) {
		showImages(changed, original, "Default title");
	}
	
	/**
	 * Shows two images, one original, one after transformation. Sets desired title
	 * @param changed
	 * @param original
	 * @param title
	 */
	public static void showImages(Image changed,Image original, String title) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(changed)));
		frame.getContentPane().add(new JLabel(new ImageIcon(original)));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * This method shows original image and multiple images transformed from it. 
	 * @param original
	 * @param images
	 * @param name
	 */
	public static void showImages(Image original, List<Image> images, String name) {
		JFrame frame = new JFrame();
		frame.setTitle(name);
		
		JPanel picturePanel = new JPanel();
		//picturePanel.setLayout(new FlowLayout());
		picturePanel.setLayout(new BoxLayout(picturePanel, BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(new JScrollPane(picturePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);

		picturePanel.add(new JLabel(new ImageIcon(original)));
		picturePanel.add(javax.swing.Box.createRigidArea(new Dimension(0, 10)));
		for (Image image : images) {
			picturePanel.add(new JLabel(new ImageIcon(image)));
			picturePanel.add(javax.swing.Box.createRigidArea(new Dimension(0, 10)));
		}
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * This method shows original image and multiple images transformed from it. 
	 * @param original
	 * @param images
	 */
	public static void showImages(Image original, List<Image> images) {
		showImages(original, images, "Transformation");
	}
	
	
	/**
	 * This method transform writable raster to buffered image
	 * @param writableRaster
	 * @param colorModel
	 * @return
	 */
	public static BufferedImage rasterToImage(WritableRaster writableRaster) {
		return RasterUtils.rasterToImage(writableRaster);
	}
	
	
}
