package production;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperities {

	private String watermarkPath = null;
	private String validImageFolderPath = null;
	private String validImagePath = null; 
	
	public ConfigProperities() {
		try {
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);
			watermarkPath = prop.getProperty("watermarkLocation");
			validImageFolderPath = prop.getProperty("validImageFolderPath");
			validImagePath = prop.getProperty("validImagePath");
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
	}
	
	public String getWatermarkPath() {
		return watermarkPath;
	}
	
	public String getValidImageFolderPath() {
		return validImageFolderPath;
	}
	
	public String getValidImagePath() {
		return validImagePath;
	}
	
}