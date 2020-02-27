package production;
public class ProjectController {

	public static void main(String[] args) {
		startUsingGuiInput();
	}
	
	private static void startUsingGuiInput() {
		InputGui inputGui = new InputGui();
		String imageFolderPath = inputGui.getFolderPath();
		String watermarkPath = inputGui.getWatermarkPath();
		PhotoMerger photoMerger = new PhotoMerger();
		photoMerger.placeWatermarkOnAllFilesInFolder(watermarkPath, imageFolderPath);
	}
	
	private static void startUsingConfigInput() {
		ConfigProperities configProperities = new ConfigProperities();
		String watermarkPath = configProperities.getWatermarkPath();
		String imageFolderPath = configProperities.getValidImageFolderPath();
		PhotoMerger photoMerger = new PhotoMerger();
		photoMerger.placeWatermarkOnAllFilesInFolder(watermarkPath, imageFolderPath);
	}
	
	public static void startUsingParameterInput(String watermarkPath, String imageFolderPath) {
		PhotoMerger photoMerger = new PhotoMerger();
		photoMerger.placeWatermarkOnAllFilesInFolder(watermarkPath, imageFolderPath);
	}
	
	
}
