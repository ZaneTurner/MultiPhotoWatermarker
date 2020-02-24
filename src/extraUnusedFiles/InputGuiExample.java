package extraUnusedFiles;
import javax.swing.JOptionPane;

public class InputGuiExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane j1 = new JOptionPane();
		JOptionPane j2 = new JOptionPane();
		
		String watermarkPath = JOptionPane.showInputDialog("Enter the watermark file path");
		String folderPath = JOptionPane.showInputDialog("Enter the folder of photos to be watermarked path");
		
		String message = "The watermarkPath is: " + watermarkPath + " and the folderPath is: " + folderPath;
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);
	}

}
