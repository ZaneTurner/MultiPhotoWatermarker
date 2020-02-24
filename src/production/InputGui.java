package production;

import javax.swing.JOptionPane;

public class InputGui {
	
	private String watermarkPath = null;
	private String folderPath = null;
	
	InputGui() {
		watermarkPath = JOptionPane.showInputDialog("Enter the watermark file path");
		folderPath = JOptionPane.showInputDialog("Enter the folder of photos to be watermarked path");
		String message = "The watermarkPath is: " + watermarkPath + " and the folderPath is: " + folderPath;
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String getWatermarkPath() {
		return watermarkPath;
	}
	
	public String getFolderPath() {
		return folderPath;
	}
	
	
}
