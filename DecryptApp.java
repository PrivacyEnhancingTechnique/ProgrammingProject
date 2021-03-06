
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class DecryptApp  extends JPanel implements ActionListener{

	 ButtonGroup bg1 = new ButtonGroup( );
	 ButtonGroup bg2 = new ButtonGroup( );
	 JPanel decryptPanel = new JPanel();
	 JLabel folderLocation = new JLabel("Drive Folder Location");
	 JTextArea folderLocationText = new JTextArea("");
	 JButton openButton = new JButton("Select a File...");
	 //JFileChooser fc = new JFileChooser(); 
	 JLabel key = new JLabel("Decryption Key");
	 JTextArea keyText = new JTextArea("");
	 JLabel dowloadLocation = new JLabel("Download Location");
	 JTextArea dowloadLocationText = new JTextArea("");
	 //JTextArea fileDirTextArea = new JTextArea();
	 JLabel fileToDecryptName = new JLabel("File Name");
	 JTextArea textArea = new JTextArea();
	 JLabel googleDrive = new JLabel("Google Drive Account?");
	 JLabel googleDriveKey = new JLabel("Google Drive Token");
	 JTextArea googleDriveKeyLabel = new JTextArea("");
	 //JPasswordField passWordTextArea = new JPasswordField();
	 //JLabel passWord = new JLabel("Password");
	 JLabel dropBox = new JLabel("Dropbox Account?");
	 JLabel appKeyDropBox = new JLabel("Dropbox Token");
	 JTextArea appKeyDropBoxText = new JTextArea("");
	 JButton downloadButton = new JButton ("Download");
	 SpinnerModel model = new SpinnerNumberModel(1, 0, 20, 1);
	 JSpinner chunkSize = new JSpinner(model);
	 JRadioButton yesGoogle = new JRadioButton("Yes");
	 JRadioButton noGoogle = new JRadioButton("No");
	 JRadioButton yesDropbox = new JRadioButton("Yes");
	 JRadioButton noDropbox = new JRadioButton("No");
     JLabel spacer;
    
	 public DecryptApp() {

		 downloadButton.addActionListener(this); 
		 
		 //Create a label
		 googleDrive.setOpaque(true);
		 dropBox.setOpaque(true);
		
		//set radiobutton
         yesGoogle.setActionCommand("Yes");
         noGoogle.setActionCommand("No");
         yesDropbox.setActionCommand("Yes");
         noDropbox.setActionCommand("No");
         
		 //TextArea
		 folderLocationText.setPreferredSize(new Dimension(300, 20));
		 folderLocationText.setBackground(new Color(250,250,250));
         keyText.setPreferredSize(new Dimension(300, 20));
         keyText.setBackground(new Color(250,250,250));
         dowloadLocationText.setPreferredSize(new Dimension(300, 20));
         dowloadLocationText.setBackground(new Color(250,250,250));
        // fileDirTextArea.setPreferredSize(new Dimension(300, 20));
         //fileDirTextArea.setBackground(new Color(250,250,250));
         textArea.setPreferredSize(new Dimension(300, 20));
         textArea.setBackground(new Color(250,250,250));
         googleDriveKeyLabel.setPreferredSize(new Dimension(200, 20));
         googleDriveKeyLabel.setBackground(new Color(250,250,250));
       // passWordTextArea.setPreferredSize(new Dimension(200, 20));
        //passWordTextArea.setBackground(new Color(250,250,250));
        appKeyDropBoxText.setPreferredSize(new Dimension(200, 20));
        appKeyDropBoxText.setBackground(new Color(250,250,250));
	   
	     
	     //value chooser
	     chunkSize.setBounds(0, 0, 10, 10);
	 }
	 
         

    public String getKeyText() {
        return keyText.getText();
    }
    
	 public JPanel loadDecryptPage() {
	        

	        decryptPanel.setLayout(new MigLayout());
	        decryptPanel.setBackground(new Color(248, 213, 131));
	    	decryptPanel.setPreferredSize(new Dimension(700, 400));
	        decryptPanel.add(folderLocation);
		    decryptPanel.add(folderLocationText);  
		    decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(fileToDecryptName);
		    decryptPanel.add(textArea);
		    decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(googleDrive);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        bg1.add(yesGoogle);
	        bg1.add(noGoogle);
	        decryptPanel.add(yesGoogle);
	        decryptPanel.add(noGoogle);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(googleDriveKey);
	        decryptPanel.add(googleDriveKeyLabel);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	       // decryptPanel.add(passWord);
	        //decryptPanel.add(passWordTextArea);
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
            decryptPanel.add(key);
	        decryptPanel.add(keyText);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
            decryptPanel.add(dowloadLocation);
	        decryptPanel.add(dowloadLocationText);
	        decryptPanel.add(spacer=  new JLabel(" "), "span, grow");
	        decryptPanel.add(spacer =  new JLabel(" "), "span, grow");
	        decryptPanel.add(downloadButton, BorderLayout.CENTER); 
	        
	        return decryptPanel;
	 }

         public void actionPerformed(ActionEvent e)  {
          /*  if (e.getSource() == openButton) {
	            int returnVal = fc.showOpenDialog(DecryptApp.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                //File file = fc.getSelectedFile();
	                //This is where a real application would open the file.
	                System.out.println("Opening: "+fc.getCurrentDirectory());
	                textArea.setText(fc.getCurrentDirectory()+"");
	                
	            } else {
	            	System.out.println("Open command cancelled by user.");
	            }
	        //    log.setCaretPosition(log.getDocument().getLength());
	// TODO Auto-generated method stub
			
		}*/
         if (e.getSource() == downloadButton) {
        	 String errorMessage = inputVerification() ;
         	
         	if (errorMessage!=""){
	        	 JFrame frame = new JFrame();
	        	 JOptionPane.showMessageDialog(frame,errorMessage);
         	}
         	else{
                    try {
                    	System.out.println("Hi");
                        downloadFromDropBox();
                    } catch (IOException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DbxException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
         }
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
   
    public String inputVerification() {
 	   String text = "";
 	   
 	   if (textArea.getText().trim().isEmpty()) {
 		   text+="- Enter filename to download"+"\n"; 
 	   } 
 	   
 	  if (folderLocationText.getText().trim().isEmpty()) {
		   text+="- Enter folder location to download from cloud"+"\n"; 
	   } 
 	   	 
 	   if ((bg1.getSelection()==null||bg1.getSelection().getActionCommand()== "No") && (bg2.getSelection()==null||bg2.getSelection().getActionCommand()=="No") ){
 		 text +="- Please select at least one cloud service"+"\n";
 		 return text; 
 	   }
 	   
 	   if (bg1.getSelection()!=null && bg1.getSelection().getActionCommand()== "Yes" ) {
 		   if( googleDriveKeyLabel.getText().isEmpty())
 				  text+="- Enter Google Drive Token"+"\n";
 		   
 		  // if( passWordTextArea.getText().isEmpty())
 			//	  text+="- Enter Google Drive password"+"\n";
 	   }
 	  
 	   if (bg2.getSelection()!=null && bg2.getSelection().getActionCommand()== "Yes" ) {
 		  if( appKeyDropBoxText.getText().isEmpty())
 			  text+="- Enter Dropbox Token"+"\n";  
 		   		  
 	   }

	   if (dowloadLocationText.getText().trim().isEmpty()) {
			   text+="- Enter local download directory location"+"\n";
		  }
	   
 	  if (keyText.getText().trim().isEmpty()) {
		   text+="- Enter Decryption Key";
	   }
 	  
 	   return text;
    }
    
   public void downloadFromDropBox() throws IOException, DbxException {

	   if (textArea.getText().endsWith(".txt")||textArea.getText().endsWith(".doc")||textArea.getText().endsWith(".docx")) {
		  System.out.println("Hi54");
	       EncryptDecrypt decryptObj; 
	       DbxClient client = authenticateDropBox();
	       //Download
	       ArrayList<String> subFileList = download(textArea.getText(), dowloadLocationText.getText(), folderLocationText.getText(), client);
	       
	       if (subFileList.isEmpty())
	       {
	    	   JFrame frame = new JFrame();
	    	   JOptionPane.showMessageDialog(frame," File " +textArea.getText()+" doesn't exist in "+folderLocationText.getText()+" in your cloud directory.\n Please check directory or filename and try again" );
	       }
	       else {
	       //Decrypt
		        try {
		            decryptObj = new EncryptDecrypt();
		            decryptObj.decryptFile(subFileList, keyText.getText());
		        } catch (NoSuchAlgorithmException e1) {
		                // TODO Auto-generated catch block
		                e1.printStackTrace();
		        }
		        
		        //Merge
		        
		        mergeFile(subFileList, textArea.getText(), dowloadLocationText.getText());
		        
		      //Delete
		        deleteFile(subFileList, dowloadLocationText.getText());
		        
		   	 JFrame frame = new JFrame();
		   	 JOptionPane.showMessageDialog(frame,"Download complete. Go to "+dowloadLocationText.getText()+" directory to view file");
		   }
	   }
	   else {
		   JFrame frame = new JFrame();
		   JOptionPane.showMessageDialog(frame,"Download Failed! File not text file or word document");
	   }
   }
   

	 public static void mergeFile(ArrayList<String> subFiles, String baseFile, String directory) throws IOException {
	        String baseFileNameAndPath = getFileDirectory(directory)  + baseFile;
	        BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(baseFileNameAndPath));
	        for (int subFileIndex = 0; subFileIndex < subFiles.size(); subFileIndex++) {
	            BufferedInputStream inputFile = new BufferedInputStream(
	                    new FileInputStream(subFiles.get(subFileIndex)));

	            int b;
	            while ( (b = inputFile.read()) != -1 )
	                    outputFile.write(b);

	            inputFile.close();
	        }
	            outputFile.close();
	    }
	 
	   
   public static String getFileDirectory(String directory) {
        //Add appropriate slash if the directory does not end with one
        if (directory != "/"){
            if (directory.contains("/") && !directory.endsWith("/")) {
                directory += "/";
            }
        }
        return directory;
    }
   
   public static void deleteFile(ArrayList<String> subFiles, String directory) {
       for (int index = 0; index < subFiles.size(); index++) {
           String filePath = subFiles.get(index);
           System.out.print(filePath);
           File file = new File(filePath);
           if(file.delete()){
               System.out.println(file.getName() + " is deleted successfully!");
           }else{
               System.out.println("Failed to delete file.");
           }
       }
   }
   public static ArrayList<String> download(String file, String localDirectory, String cloudDirectory, DbxClient client) 
            throws IOException, DbxException {
        ArrayList<String> subFileList = new ArrayList<String>();
        int fileCount = 0;

        //Add the appropriate slash if directory does not end with one
        localDirectory = getFileDirectory(localDirectory);
        System.out.print(localDirectory);
        //remove the end / to avoid failing at the API level since it seems to add
        //slash at the end of file before appending the file name to it
        if (cloudDirectory != "/"){
            if (cloudDirectory.endsWith("/")) {
                cloudDirectory = cloudDirectory.replaceFirst(".$","");;
            }
        }

        DbxEntry.WithChildren listing = client.getMetadataWithChildren(cloudDirectory);
        System.out.println("Files in the root path:");
        for (DbxEntry child : listing.children) {
            System.out.println("	" + child.name + ": " + child.toString());
            if (child.name.endsWith(file)) {
                fileCount++;
            }
        }
        System.out.print("total files: " + fileCount);

        //Download file
        for (int index = 0; index < fileCount; index++) {
            String fileName = cloudDirectory + "/" + "file_" + index + "_" +file;
            String outputFile = localDirectory + "file_" + index + "_" +file;
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            try {
                DbxEntry.File downloadedFile = client.getFile(fileName, null,
                    outputStream);
            } finally {
                subFileList.add(outputFile);
                outputStream.close();
            }
        }
        return subFileList;
    }
}
