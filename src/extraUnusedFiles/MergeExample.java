package extraUnusedFiles;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MergeExample {

	public static void main(String[] args) {
		
		BufferedImage image = null;
		BufferedImage overlay = null;
		try {
			image = ImageIO.read(new File("/Users/zaneturner/eclipse-workspace/multiPhotoWatermarker/src/images/basicimage.png"));
			overlay = ImageIO.read(new File("/Users/zaneturner/eclipse-workspace/multiPhotoWatermarker/src/images/watermark.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int w = Math.max(image.getWidth(), overlay.getWidth());
		int h = Math.max(image.getHeight(), overlay.getHeight());
		
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.drawImage(overlay, 0, 0, null);

		try {
			ImageIO.write(combined, "png", new File("/Users/zaneturner/eclipse-workspace/multiPhotoWatermarker/src/images/result.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
