package Testing;
import org.junit.Test;
import production.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class InputValidatorTest {
	
	private final InputValidator inputValidator = new InputValidator();
	private final String validPhotosFolderLocation = "/Users/zaneturner/git/repository/MultiPhotoWatermarker/ValidInputPhotos/";
	@Test
	public void isUserInputValid(){
		assertEquals(inputValidator.isUserInputValid("", ""), false, " assert equals user input error");
		assertEquals(inputValidator.isUserInputValid("", "123!"),false, " assert equals user input error");
		assertEquals(inputValidator.isUserInputValid("123!", ""), false, " assert equals user input error");
		File folder = new File(validPhotosFolderLocation);
		String[] fileLocations = folder.list();
		
		for(String fileLocation : fileLocations) {
			System.out.println(fileLocation);
			System.out.println("test");
			assertEquals(inputValidator.isUserInputValid(fileLocation, validPhotosFolderLocation), false, "assert equals unexpected input");
		}
		
	}
	
	
}
/*
 * 
 * 
 * 
 * 	public void placeWatermarkOnAllFilesInFolder(String watermarkPath, String folderPath) { 
		InputValidator inputValidator = new InputValidator();
		
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
				String newPhotoPath = folderPath + fileLocation.substring(0, fileLocation.length()-4) + "New.png";
				this.placeWatermarkOnImage(watermark, newPhoto, newPhotoPath);
			}
		}
		
	}
 * 
 * 
 * 
 * 
 * 
 */
