package demo;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SwingUtil {
	
	public static final ColorModel RGB_COLOR_MODEL = ColorModel.getRGBdefault();
	
	
	private SwingUtil() {
		throw new IllegalStateException();
	}
	
	public static BufferedImage loadImage(String path) throws IOException {
		File image = new File(path);
		return loadImage(image);
	}
	
	public static BufferedImage loadImage(File image) throws IOException {
		BufferedImage im = null;
		im = ImageIO.read(image);
		return im;
	}
	
	public static void showImage(Image image) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void showImages(Image changed,Image original) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(changed)));
		frame.getContentPane().add(new JLabel(new ImageIcon(original)));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static BufferedImage rasterToImage(WritableRaster writableRaster,ColorModel colorModel) {
		return new BufferedImage(colorModel, writableRaster, colorModel.isAlphaPremultiplied(), null);
	}
	
	public static BufferedImage rasterToImage(WritableRaster writableRaster) {
		return rasterToImage(writableRaster, RGB_COLOR_MODEL);
	}
	
	
}
