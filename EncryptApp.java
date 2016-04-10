package cs898ABProject;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class EncryptApp {
	
	private static JPanel buttonPanel2;
	
	public static void main (String[]args) {
		MainInterface main = new MainInterface();
	    
	    //create menus
        main.greenMenuBar.add(main.menu1);
        main.greenMenuBar.add(main.menu2);

        main.buttonPanel = new JPanel();
        main.buttonPanel.add(main.textArea);
        main.buttonPanel.add(main.openButton);
        ButtonGroup bg1 = new ButtonGroup( );
        ButtonGroup bg2 = new ButtonGroup( );

        buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new MigLayout());
        buttonPanel2.setBackground(new Color(248, 213, 131));
        buttonPanel2.add(main.spacer =  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.numberOfChunks);
        buttonPanel2.add(main.chunkSize);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.googleDrive);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        bg1.add(main.yesGoogle);
        bg1.add(main.noGoogle);
        buttonPanel2.add(main.yesGoogle);
        buttonPanel2.add(main.noGoogle);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.userName);
        buttonPanel2.add(main.userNameTextArea);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.passWord);
        buttonPanel2.add(main.passWordTextArea);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.dropBox);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        bg2.add(main.yesDropbox);
        bg2.add(main.noDropbox);
        buttonPanel2.add(main.yesDropbox);
        buttonPanel2.add(main.noDropbox);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.appKeyDropBox);
        buttonPanel2.add(main.appKeyDropBoxText);
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.spacer=  new JLabel(" "), "span, grow");
        buttonPanel2.add(main.uploadButton, BorderLayout.CENTER);
        
        //Set the menu bar and add the label to the content pane.
        main.frame.setJMenuBar(main.greenMenuBar);

    	main.frame.add(main.buttonPanel, BorderLayout.PAGE_START);
        main.frame.getContentPane().add(buttonPanel2);
      
        //Display the window.
	    main.frame.pack();
	    main.frame.setVisible(true);
	}

	
}
