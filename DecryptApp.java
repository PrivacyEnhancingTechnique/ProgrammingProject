import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class DecryptApp {
	
	 JPanel decryptPanel = new JPanel();
     JTextArea textArea = new JTextArea();
     JLabel fileToDecryptName = new JLabel("File Name");
	 JLabel googleDrive = new JLabel("Google Drive Account?");
	 JLabel userName = new JLabel("Username");
	 JTextArea userNameTextArea = new JTextArea("me@gmail.com");
	 JTextArea passWordTextArea = new JTextArea("********");
	 JLabel passWord = new JLabel("Password");
	 JLabel dropBox = new JLabel("Dropbox Account?");
	 JLabel appKeyDropBox = new JLabel("App Key");
	 JTextArea appKeyDropBoxText = new JTextArea("");
	 JButton uploadButton = new JButton ("Download");
	 SpinnerModel model = new SpinnerNumberModel(1, 0, 20, 1);
	 JSpinner chunkSize = new JSpinner(model);
	 JRadioButton yesGoogle = new JRadioButton("Yes");
	 JRadioButton noGoogle = new JRadioButton("No");
	 JRadioButton yesDropbox = new JRadioButton("Yes");
	 JRadioButton noDropbox = new JRadioButton("No");
    JLabel spacer;
    
	 public DecryptApp() {

		 
		 //Create a label
		 googleDrive.setOpaque(true);
		 dropBox.setOpaque(true);
		 
		 //TextArea
		 textArea.setPreferredSize(new Dimension(300, 20));
	     textArea.setBackground(new Color(250,250,250));
	     userNameTextArea.setPreferredSize(new Dimension(200, 20));
	     userNameTextArea.setBackground(new Color(250,250,250));
	     passWordTextArea.setPreferredSize(new Dimension(200, 20));
	     passWordTextArea.setBackground(new Color(250,250,250));
	     appKeyDropBoxText.setPreferredSize(new Dimension(200, 20));
	     appKeyDropBoxText.setBackground(new Color(250,250,250));
	   
	     
	     //value chooser
	     chunkSize.setBounds(0, 0, 10, 10);
	 }
	 
	 public JPanel loadDecryptPage() {

	        ButtonGroup bg1 = new ButtonGroup( );
	        ButtonGroup bg2 = new ButtonGroup( );
	        
	        decryptPanel.add(fileToDecryptName);
		    decryptPanel.add(textArea);
		    decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
		    decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.setLayout(new MigLayout());
	        decryptPanel.setBackground(new Color(248, 213, 131));
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(googleDrive);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        bg1.add(yesGoogle);
	        bg1.add(noGoogle);
	        decryptPanel.add(yesGoogle);
	        decryptPanel.add(noGoogle);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(userName);
	        decryptPanel.add(userNameTextArea);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(passWord);
	        decryptPanel.add(passWordTextArea);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(dropBox);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        bg2.add(yesDropbox);
	        bg2.add(noDropbox);
	        decryptPanel.add(yesDropbox);
	        decryptPanel.add(noDropbox);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(appKeyDropBox);
	        decryptPanel.add(appKeyDropBoxText);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(uploadButton, BorderLayout.CENTER); 
	        
	        return decryptPanel;
	 }

}
