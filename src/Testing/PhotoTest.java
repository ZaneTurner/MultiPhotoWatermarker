package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import production.Photo;
import production.Visibility;

public class PhotoTest {
	//String watermarkPath = "/Users/zaneturner/git/repository/MultiPhotoWatermarker/watermarks/watermark.png";
	//String imageFolderPath = "/Users/zaneturner/git/repository/MultiPhotoWatermarker/images/";
	private final String photoLocation = "/Users/zaneturner/git/repository/MultiPhotoWatermarker/images/IMG_2894.png";

	@Test
	public void  testVisibility() {
		for (Visibility visibilityLevel : Visibility.values()) {
			Photo photo = new Photo(photoLocation, visibilityLevel);
			assertEquals(photo.visibility, visibilityLevel, visibilityLevel + " this enum value was not as expected");
		}
	}
	
}
