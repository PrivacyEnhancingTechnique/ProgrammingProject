package cs898ABProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import static cs898ABProject.Authenticate.download;
import static cs898ABProject.Authenticate.getFileDirectory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import net.miginfocom.swing.MigLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

@SuppressWarnings("serial")
public class EncryptApp extends JPanel 
					implements ActionListener {
	public static String fileName;
	private static JPanel encryptPanel;
	
	 JMenuBar greenMenuBar = new JMenuBar();
	 JButton openButton = new JButton("Select a File...");
	 JFileChooser fc = new JFileChooser(); 
     JTextArea textArea = new JTextArea();
	 JLabel numberOfChunks = new JLabel("File Split Count");
	 JLabel googleDrive = new JLabel("Google Drive Account?");
	 JLabel userName = new JLabel("Username");
	 JTextArea userNameTextArea = new JTextArea("me@gmail.com");
	 JTextArea passWordTextArea = new JTextArea("********");
	 JLabel passWord = new JLabel("Password");
	 JLabel dropBox = new JLabel("Dropbox Account?");
	 JLabel appKeyDropBox = new JLabel("App Key");
	 JTextArea appKeyDropBoxText = new JTextArea("");
	 JButton uploadButton = new JButton ("Upload");
         JLabel dropboxDirLabel = new JLabel("Upload Location");
	 JTextArea dropboxDirText = new JTextArea("");
	 SpinnerModel model = new SpinnerNumberModel(1, 0, 20, 1);
	 JSpinner chunkSize = new JSpinner(model);
	 JRadioButton yesGoogle = new JRadioButton("Yes");
	 JRadioButton noGoogle = new JRadioButton("No");
	 JRadioButton yesDropbox = new JRadioButton("Yes");
	 JRadioButton noDropbox = new JRadioButton("No");
     JLabel spacer;
     
	 public EncryptApp() {
		 		 
		//create button
		 openButton.addActionListener(this); 
         uploadButton.addActionListener(this); 
		
		//Create the menu bar.  Make it have a green background.
	     greenMenuBar.setOpaque(true);
	     greenMenuBar.setPreferredSize(new Dimension(200, 40));
		 
		 //Create a label
		 numberOfChunks.setOpaque(true);
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
             dropboxDirText.setPreferredSize(new Dimension(200, 20)); 
	     dropboxDirText.setBackground(new Color(250,250,250));
	   
	     
	     //value chooser
	     chunkSize.setBounds(0, 0, 10, 10);
	 }

		
	 public JPanel loadEncryptPage() {
		 
		    JPanel buttonPanel = new JPanel();
	        JPanel tabPanel = new JPanel();
	        encryptPanel = new JPanel();
	        
		    //create menus
	        encryptPanel.setLayout( null );        
	        
	        tabPanel.setLayout( new BorderLayout() );
	        buttonPanel.add(textArea);
	        buttonPanel.add(openButton);
	        ButtonGroup bg1 = new ButtonGroup( );
	        ButtonGroup bg2 = new ButtonGroup( );
	        
	        encryptPanel.add(buttonPanel);
	        encryptPanel.setLayout(new MigLayout());
	        encryptPanel.setBackground(new Color(248, 213, 131));
	        encryptPanel.add(spacer =  new JLabel(" "), "span, grow");
	        encryptPanel.add(numberOfChunks);
	        encryptPanel.add(chunkSize);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(googleDrive);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        bg1.add(yesGoogle);
	        bg1.add(noGoogle);
	        encryptPanel.add(yesGoogle);
	        encryptPanel.add(noGoogle);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(userName);
	        encryptPanel.add(userNameTextArea);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(passWord);
	        encryptPanel.add(passWordTextArea);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(dropBox);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        bg2.add(yesDropbox);
	        bg2.add(noDropbox);
	        encryptPanel.add(yesDropbox);
	        encryptPanel.add(noDropbox);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(appKeyDropBox);
	        encryptPanel.add(appKeyDropBoxText);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
                encryptPanel.add(dropboxDirLabel);
	        encryptPanel.add(dropboxDirText);
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        encryptPanel.add(uploadButton, BorderLayout.CENTER);     
	        
	        return encryptPanel;
	 }
	 
	 public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		EncryptApp.fileName = fileName;
	}
	
	 @Override
		public void actionPerformed(ActionEvent e)  {
			//Handle open button action.
	         if (e.getSource() == openButton) {
	            int returnVal = fc.showOpenDialog(EncryptApp.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                //This is where a real application would open the file.
	                System.out.println("Opening: "+fc.getCurrentDirectory() + file.getName() );
	                textArea.setText(fc.getCurrentDirectory() + "\\" + file.getName());
	                setFileName(fc.getCurrentDirectory() + "\\" +file.getName());
	            } else {
	            	System.out.println("Open command cancelled by user.");
	            }
	        //    log.setCaretPosition(log.getDocument().getLength());
	// TODO Auto-generated method stub
			
		}
	    
                if (e.getSource() == uploadButton) {
                    try {
                        uploadToDropbox();
                    } catch (IOException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DbxException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeyException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
	    
		}

   public void uploadToDropbox() throws IOException, DbxException, InvalidKeyException{
       EncryptDecrypt encryptObj; 
        DbxClient client = authenticateDropBox();
        
        //Split file
        ArrayList<String> fileList = splitFile(fileName, (Integer)model.getValue());
        
        //Encrypt
        try {
            encryptObj = new EncryptDecrypt();
            for (int index = 0; index < fileList.size(); index++) {
                encryptObj.encryptFile(fileList.get(index));
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
        
        //Upload file
        String directory = getFileDirectory(dropboxDirText.getText());

        //Upload each sub file
        for (String file : fileList) {
            File inputFile = new File(file);
            FileInputStream inputStream = new FileInputStream(inputFile);
            System.out.print(inputFile.getName());
            try {
                DbxEntry.File uploadedFile = client.uploadFile(directory + inputFile.getName(),
                    DbxWriteMode.add(), inputFile.length(), inputStream);
                System.out.println("Uploaded: " + uploadedFile.toString());
            } finally {
                inputStream.close();
            }
        }
   }
   
   public static String getFileDirectory(String directory) {
        //Add appropriate slash if the directory does not end with one
        if (directory != "/"){
            if (directory.contains("/") && !directory.endsWith("/")) {
                directory += "//";
            }
        }
        return directory;
    }
   
   public DbxClient authenticateDropBox() throws DbxException {
       DbxRequestConfig config = new DbxRequestConfig(
            "CS898AB Project", Locale.getDefault().toString());
        //bypass confirm method
        String accessToken = appKeyDropBoxText.getText();

        DbxClient client = new DbxClient(config, accessToken);

        System.out.println("Linked account: " + client.getAccountInfo().displayName);
        return client;
   }
   
   public static ArrayList<String> splitFile(String file, int fileCount) 
            throws FileNotFoundException, IOException {
        ArrayList<String> subFileList = new ArrayList<String>(fileCount);
        
        //Open user provided file
        BufferedInputStream inputFile = new BufferedInputStream(
                new FileInputStream(file));

        // get the file length
        File userFile = new File(file);
        long fileLength = userFile.length();
        
        // Get file name
        String fileName = userFile.getName();
        
        //Get the chunk size for each sub files
        long fileChunkSize = fileLength / fileCount;
        
        //For each subFile
        for (int fileNumber = 0; fileNumber < fileCount; fileNumber++) {
            String subFileName = "file_" + fileNumber + "_" + fileName;
            BufferedOutputStream outputFile = new BufferedOutputStream(
                    new FileOutputStream(subFileName));

            //Write a number of bytes to a sub file
            for (int byteCount = 0; byteCount < fileChunkSize; byteCount++) {
                // write one byte from input file to output file
                outputFile.write(inputFile.read());
            }

            subFileList.add(subFileName);
            outputFile.close();
        }

        return subFileList;
    }
}
