package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import production.ConfigProperities;
import production.Photo;
import production.Visibility;
import production.InputValidator;

public class PhotoTest {
	ConfigProperities configProperities = new ConfigProperities();
	private final String photoLocation = configProperities.getImagePath();

	@Test
	public void  testVisibility() {
		for (Visibility visibilityLevel : Visibility.values()) {
			Photo photo = new Photo(photoLocation, visibilityLevel);
			assertEquals(photo.visibility, visibilityLevel, visibilityLevel + " this enum value was not as expected");
		}
	}
	
}
