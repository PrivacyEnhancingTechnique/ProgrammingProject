import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.*;


public class RSAEncryption {
	KeyGenerator keyGen;
	SecretKey encrptionKey;
	
	public RSAEncryption() throws NoSuchAlgorithmException {
		this.keyGen =   KeyGenerator.getInstance("DES");
		keyGen.init(56);
		this.encrptionKey = keyGen.generateKey();
	}
	
	public void encryptFile(String fileName) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		if (fileName.endsWith(".txt")) {
			//encrypt file
			File file = new File (fileName);
			File outFile = new File (fileName);
			encryptDecrypt(Cipher.ENCRYPT_MODE,file,outFile);
			System.out.println(this.encrptionKey);
			//decryptFile();
		}
		else {
			System.out.println("File not text file");
			//display pop up saying file not txt file
		}
	}
	
	public void decryptFile(ArrayList <String> fileNames) {
		//decrypt file code
		File outFile = new File ("decrypted.txt");
		
		for(int i=0; i<fileNames.size();i++) {
			File file = new File (fileNames.get(i));
			encryptDecrypt(Cipher.DECRYPT_MODE,file,outFile);
		}
		
	}
	
	private void encryptDecrypt (int cipherMode, File inputFile, File outputFile)  {
        try {

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(cipherMode, this.encrptionKey);
					
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
           // throw new Exception("Error encrypting/decrypting file", ex);
        }
    }

}

