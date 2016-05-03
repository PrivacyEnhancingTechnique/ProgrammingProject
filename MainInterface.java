import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainInterface  {

	private static JPanel tabPanel=new JPanel();
	
	public static void main (String[]args) {
		JFrame frame = new JFrame("Secured Cloud");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JDialog popWindow = new JDialog ();
		 
		JTabbedPane tabbedPane  = new JTabbedPane();
		EncryptApp encryptInterface = new EncryptApp();
		DecryptApp decryptInterface = new DecryptApp();
		       
        
        tabbedPane.addTab("Upload & Encrypt", encryptInterface.loadEncryptPage());
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Download & Decrypt", decryptInterface.loadDecryptPage());
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        tabPanel.add(tabbedPane, BorderLayout.CENTER);
        frame.add(tabPanel);
        frame.getContentPane().add(tabPanel);
      
        //Display the window.
	    frame.pack();
	    frame.setVisible(true);
	}

	
}
