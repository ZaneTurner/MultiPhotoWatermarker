import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.*;

import javax.imageio.ImageIO;


public class Photo {
	public BufferedImage image = null;
	public Visibility visibility = null;
	
	public Photo(String photoLocation, Visibility visibilityLevel) {

		try {
			image = ImageIO.read(new File(photoLocation));
			image = this.TransformGrayToTransparency(image);
			visibility = visibilityLevel;
		} catch (IOException e) {
			System.out.println("The photo location is: " + photoLocation);
			e.printStackTrace();
		}
		
		
	}
	
	  private BufferedImage TransformGrayToTransparency(BufferedImage image)
		  {
		    ImageFilter filter = new RGBImageFilter()
		    {
		      public final int filterRGB(int x, int y, int rgb)
		      {
		        return (rgb << 8) & 0xFF000000;
		      }
		    };
		
		    ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
		    Image temp_image = Toolkit.getDefaultToolkit().createImage(ip);
		    BufferedImage dest = new BufferedImage(
		    	    temp_image.getWidth(null), temp_image.getHeight(null),
		    	    BufferedImage.TYPE_INT_ARGB);
		    	Graphics2D g2 = dest.createGraphics();
		    	g2.drawImage(image, 0, 0, null);
		    	g2.dispose();
		    	
		    return dest;
		  }
}
