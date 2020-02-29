package production;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PhotoMerger {
	
	
	public void placeWatermarkOnAllFilesInFolder(String watermarkPath, String folderPath) { 
		InputValidator inputValidator = new InputValidator();
		folderPath = inputValidator.correctFolderPath(folderPath);
		watermarkPath = inputValidator.correctImagePath(watermarkPath);
		
		if(!inputValidator.isUserInputValid(watermarkPath, folderPath)) {
			return;
		}
		
		Visibility visibilityLevel = Visibility.HIGHVISIBILITY;
		Photo watermark = new Photo(watermarkPath, visibilityLevel);
		File folder = new File(folderPath);
		String[] fileLocations = folder.list();
		
		for (String fileLocation : fileLocations) {
			String absoluteFilePath = folderPath + fileLocation;
			if(inputValidator.isUserInputValid(absoluteFilePath, folderPath)) {
				Photo newPhoto = new Photo(absoluteFilePath, visibilityLevel);
				String newPhotoPath = createNewPhotoPath(absoluteFilePath);
				this.placeWatermarkOnImage(watermark, newPhoto, newPhotoPath);
			}
		}
		
	}
	
	private void placeWatermarkOnImage(Photo watermark, Photo photo, String resultingImagePath) {
		int width = Math.max(photo.image.getWidth(), watermark.image.getWidth());
		int height = Math.max(photo.image.getHeight(), watermark.image.getHeight());
		
		if(!isImageSizeValid(width, height)) {
			return;
		}
		
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
	
	
	private static boolean isImageSizeValid(int width, int height) {
		if (width > 0 && height > 0) {
			return true;
		}
		System.out.println("Input image size is not valid.");
		return false;
	}
	
	private static String createNewPhotoPath(String photoPath) {
		int lastPeriodLocation = photoPath.lastIndexOf(".");
		String extension = photoPath.substring(lastPeriodLocation);
		String newPhotoPath = photoPath.substring(0, lastPeriodLocation) + "New" + extension;
		return newPhotoPath;
	}
	
	
}
