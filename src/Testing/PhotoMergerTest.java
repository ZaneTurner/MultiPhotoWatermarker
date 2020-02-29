package Testing;
import org.junit.Test;

import production.ConfigProperities;
import production.PhotoMerger;

public class PhotoMergerTest {
	
	private final PhotoMerger photoMerger = new PhotoMerger();
	ConfigProperities configProperities = new ConfigProperities();
	private final String validWatermarkPath = configProperities.getWatermarkPath();
	private final String validImageFolderPath = configProperities.getFolderPath();
	
	@Test
	public void testPlaceWatermarkOnAllFilterInFolder(){
		photoMerger.placeWatermarkOnAllFilesInFolder("", "");
		photoMerger.placeWatermarkOnAllFilesInFolder("", "123!");
		photoMerger.placeWatermarkOnAllFilesInFolder("123!", "");
		photoMerger.placeWatermarkOnAllFilesInFolder(validWatermarkPath, validImageFolderPath);
	}
	
}
