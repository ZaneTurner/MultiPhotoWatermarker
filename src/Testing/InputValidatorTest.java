package Testing;
import org.junit.Test;

import production.ConfigProperities;
import production.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class InputValidatorTest {
	
	private final InputValidator inputValidator = new InputValidator();
	ConfigProperities configProperities = new ConfigProperities();
	private final String validPhotosFolderLocation = configProperities.getValidImageFolderPath();
	
	@Test
	public void isUserInputValid(){
		assertEquals(inputValidator.isUserInputValid("", ""), false, " assert equals user input error");
		assertEquals(inputValidator.isUserInputValid("", "123!"),false, " assert equals user input error");
		assertEquals(inputValidator.isUserInputValid("123!", ""), false, " assert equals user input error");
		File folder = new File(validPhotosFolderLocation);
		String[] fileLocations = folder.list();
		
		for(String fileLocation : fileLocations) {
			assertEquals(inputValidator.isUserInputValid(fileLocation, validPhotosFolderLocation), false, "assert equals unexpected input");
		}
		
	}
}