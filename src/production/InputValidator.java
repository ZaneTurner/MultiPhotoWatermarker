package production;

import java.io.File;

public class InputValidator {
	
	public Boolean isUserInputValid(String watermarkPath, String folderPath) {
		if (isWatermarkPathValid(watermarkPath) && isFolderPathValid(folderPath)) { 
			return true;
		}
		System.out.println("User input is not valid");
		return false;
	}
	
	private Boolean isWatermarkPathValid(String watermarkPath) {
		File watermark = new File(watermarkPath);
		if(watermark.exists() && this.isvalidImageFormat(watermark)) {
			return true;
		}
		System.out.println(watermarkPath + " watermark path is not valid");
		return false;
	}
	
	private Boolean isFolderPathValid(String folderPath) {
		File folder = new File(folderPath);
		if(folder.exists()) {
			return true;
		}
		System.out.println(folderPath + " folder path is not valid");
		return null;
	}
	
	private Boolean isvalidImageFormat(File file) {
		String imageFormats[] = {"png", "jpeg", "jpg", "bmp", "webmp", "gif"};
		for(String format : imageFormats) {
			format = format.toLowerCase();
			String fileAbsolutePath = file.getAbsolutePath().toLowerCase();
			if(fileAbsolutePath.endsWith(format)) {
				return true;
			}
		}
		System.out.println(file.getAbsolutePath() + " image format is not valid");
		return false;
	}
	
	public String correctWatermarkPath(String watermarkPath) {
		if(!watermarkPath.startsWith("/")) {
			watermarkPath = "/" + watermarkPath;
		}
		return watermarkPath;
	}
	
	public String correctFolderPath(String folderPath) {
		if(!folderPath.endsWith("/")) {
			folderPath = folderPath + "/";
		}
		
		if(!folderPath.startsWith("/")) {
			folderPath = "/" + folderPath;
		}
		
		return folderPath;
	}
	
}
