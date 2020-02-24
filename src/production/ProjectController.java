/*
 * watermark path -
 * /Users/zaneturner/git/repository/MultiPhotoWatermarker/watermarks/watermark.png
 * images path -
 * /Users/zaneturner/git/repository/MultiPhotoWatermarker/images/
 * 
 */
package production;
public class ProjectController {

	public static void main(String[] args) {
		// used for GUI input
		/*
		InputGui inputGui = new InputGui();
		String imageFolderPath = inputGui.getFolderPath();
		String watermarkPath = inputGui.getWatermarkPath();
		*/
		//used for testing
		//TODO get rid of these hard coded paths, make them relative to the program
		ConfigProperities configProperities = new ConfigProperities();
		String watermarkPath = configProperities.getWatermarkLocation();
		String imageFolderPath = configProperities.getValidImageFolderPath();
		PhotoMerger photoMerger = new PhotoMerger();
		photoMerger.placeWatermarkOnAllFilesInFolder(watermarkPath, imageFolderPath);
	}
	
}
