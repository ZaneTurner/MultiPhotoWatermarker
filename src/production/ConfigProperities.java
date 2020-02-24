package production;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
/*
 * 
 * watermarkLocation=watermarks/watermark.png
 * validImageFolderPath=ValidInputPhotos/
 * 
 * 
 * 
 */
public class ConfigProperities {

	private String watermarkLocation = null;
	private String validImageFolderPath = null;
	
	public ConfigProperities() {
		try {
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);
			watermarkLocation = prop.getProperty("watermarkLocation");
			validImageFolderPath = prop.getProperty("validImageFolderPath");
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
	}
	
	public String getWatermarkLocation() {
		return watermarkLocation;
	}
	
	public String getValidImageFolderPath() {
		return validImageFolderPath;
	}
	
}