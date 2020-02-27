package Testing;
import production.ConfigProperities;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import production.ProjectController;;

public class ProjectControllerTest {
	
	@Test
	public void testMain() {
		ConfigProperities configProperities = new ConfigProperities();
		String watermarkPath = configProperities.getWatermarkPath();
		String folderPath = configProperities.getValidImageFolderPath();
		this.isVariedInputsValid(watermarkPath, folderPath);
		}
	
		// this test can cause issues based on OS because of hidden folders which are not watermarked, therefore the folder size
		// would not be as expected
		private void isVariedInputsValid(String watermarkPath, String folderPath) {
			String[][] pathVariations = this.getVariationsOfPaths(watermarkPath, folderPath);
			int nonImageFiles = 1;
			int prevFolderSize = getSizeOfFolder(folderPath)-nonImageFiles;
			int reprintedFolderCount = 1;
			for(String[] pathVariation : pathVariations) {
				reprintedFolderCount+=1;
				ProjectController.startUsingParameterInput(pathVariation[0], pathVariation[1]);
				int newFolderSize = getSizeOfFolder(folderPath) - nonImageFiles;
				assertEquals(prevFolderSize*reprintedFolderCount, newFolderSize, "folder size: " + newFolderSize + " is not as expected: " + prevFolderSize*2);
			}
		}
		
		private String[][] getVariationsOfPaths(String watermarkPath, String folderPath) {
			String[] v1 = {watermarkPath.substring(1), folderPath};
			String[] v2 = {watermarkPath, folderPath.substring(1)};
			String[] v3 = {watermarkPath, folderPath.substring(0,folderPath.length()-1)};
			String[] v4 = {watermarkPath, folderPath.substring(1, folderPath.length()-1)};
			String[][] pathVariations = {v1,v2,v3,v4};
			return pathVariations;
		}
		
		private int getSizeOfFolder(String folderPath) {
			return new File(folderPath).listFiles().length;
		}
		


	}
	