package Testing;
import org.junit.Test;
import production.PhotoMerger;

public class PhotoMergerTest {
	
	private final PhotoMerger photoMerger = new PhotoMerger();
	private final String validWatermarkPath = "/Users/zaneturner/git/repository/MultiPhotoWatermarker/watermarks/watermark.png";
	private final String validImageFolderPath = "/Users/zaneturner/git/repository/MultiPhotoWatermarker/ValidImages/";
	
	@Test
	public void testPlaceWatermarkOnAllFilterInFolder(){
		photoMerger.placeWatermarkOnAllFilesInFolder("", "");
		photoMerger.placeWatermarkOnAllFilesInFolder("", "123!");
		photoMerger.placeWatermarkOnAllFilesInFolder("123!", "");
		photoMerger.placeWatermarkOnAllFilesInFolder(validWatermarkPath, validImageFolderPath);
	}
	
}
