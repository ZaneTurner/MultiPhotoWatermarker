package production;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperities {

	private String watermarkPath = null;
	private String folderPath = null;
	private String imagePath = null; 
	
	public ConfigProperities() {
		try {
			InputValidator inputValidator = new InputValidator();
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);
			watermarkPath = prop.getProperty("watermarkLocation");
			watermarkPath = inputValidator.correctImagePath(watermarkPath);
			folderPath = prop.getProperty("validImageFolderPath");
			folderPath = inputValidator.correctFolderPath(folderPath);
			imagePath = prop.getProperty("validImagePath");
			imagePath = inputValidator.correctImagePath(imagePath);
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
	}
	
	
	public String getWatermarkPath() {
		return watermarkPath;
	}
	
	public String getFolderPath() {
		return folderPath;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
}