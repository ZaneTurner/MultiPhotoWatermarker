public class ProjectController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String imageFolderPath = "images/";
		String watermarkPath = "watermarks/watermark.png";
		PhotoMerger photoMerger = new PhotoMerger();
		photoMerger.placeWatermarkOnAllFilesInFolder(watermarkPath, imageFolderPath);
	}
	
}
