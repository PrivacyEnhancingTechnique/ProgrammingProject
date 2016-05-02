
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class EncryptDecrypt  {
	KeyGenerator keyGen;
	SecretKey encrptionKey;
	
	public EncryptDecrypt() throws NoSuchAlgorithmException {
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
			System.out.println(Base64.getEncoder().encodeToString(this.encrptionKey.getEncoded()));
			//decryptFile();
		}
		else {
			System.out.println("File not text file");
			//display pop up saying file not txt file
		}
	}
	
	public void decryptFile(ArrayList <String> fileNames, String key) {
		//decrypt file code
		File outFile = new File ("decrypted.txt");
		 System.out.println(key);
	// String encoded = DatatypeConverter.printBase64Binary(key.getBytes());
	// System.out.println(encoded); 
       byte[] encodedKey = Base64.getDecoder().decode(key);
       System.out.println(encodedKey);  
       // byte[] encodedKey = DatatypeConverter.parseHexBinary(key);
		this.encrptionKey=new SecretKeySpec(encodedKey,0,encodedKey.length,"DES");
		System.out.println(this.encrptionKey);       
                
		for(int i=0; i<fileNames.size();i++) {
			File file = new File (fileNames.get(i));
			System.out.println("Decrypt: "+fileNames.get(i));
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
