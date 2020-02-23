import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PhotoMerger {
	
	
	public void placeWatermarkOnAllFilesInFolder(String watermarkPath, String folderPath) {
		Visibility visibilityLevel = Visibility.HIGHVISIBILITY;
		Photo watermark = new Photo(watermarkPath, visibilityLevel);
		File folder = new File(folderPath);
		String[] fileLocations = folder.list();
		for (String fileLocation : fileLocations) {
			if (isValidLocation(fileLocation)) {
				String newFileLocation =  fileLocation.substring(0, fileLocation.length()- 4) + "1.png";
				Photo currentPhoto = new Photo(folderPath + fileLocation, visibilityLevel);
				this.placeWatermarkOnImage(watermark, currentPhoto, newFileLocation);
			}
		}
	}
	
	public void placeWatermarkOnImage(Photo watermark, Photo photo, String resultingImagePath) {
		int width = Math.max(photo.image.getWidth(), watermark.image.getWidth());
		int height = Math.max(photo.image.getHeight(), watermark.image.getHeight());
		
		BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics graphicHandler = combined.getGraphics();
		graphicHandler.drawImage(photo.image, 0, 0, null);
		graphicHandler.drawImage(watermark.image, 0, 0, null);

		try {
			ImageIO.write(combined, "png", new File(resultingImagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static boolean isValidLocation(String fileLocation) {
		/*.DS_Store is a default mac folder containing meta data
		 * its the invalid fileLocation that should exist, but if more
		 * are found (in other OS) they should be put into their own file
		 * read in this method and checked if valid
		 */ 
		
		System.out.println(fileLocation);
		if (fileLocation.equals(".DS_Store")) {
			System.out.println(fileLocation + " is not a valid location");
			return false;
		}
		return true;
	}
	
	
}
