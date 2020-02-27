package production;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class Photo {
	public BufferedImage image = null;
	public Visibility visibility = Visibility.HIGHVISIBILITY;
	
	public Photo(String photoLocation, Visibility visibilityLevel) {
		
		try {
			image = ImageIO.read(new File(photoLocation));;
			visibility = visibilityLevel;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
