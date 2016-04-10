import java.security.NoSuchAlgorithmException;
import javax.crypto.*;


public class RSAEncryption {
	KeyGenerator keyGen;
	SecretKey encrptionKey;
	
	public RSAEncryption() throws NoSuchAlgorithmException {
		this.keyGen =   KeyGenerator.getInstance("DES");
		keyGen.init(128);
		this.encrptionKey = keyGen.generateKey();
	}
	
	public void encryptFile() {
		if (MainInterface.fileName.endsWith(".txt")) {
			//encrypt file
		}
		else {
			System.out.println("File not text file");
			//display pop up saying file not txt file
		}
	}
	
	public void decryptFile() {
		//decrypt file code
	}
	
}

/*public static native int getNumber();

private static String8 rndSeed = s8("string to make the random number generator think it has entropy");

public static void main(String[] args) throws IOException {
	RsaSt[] key;
	byte[] rbuff_U = "RSA Clear Text\0".getBytes();
	int num, i;
	byte ch;
	String fileName;
	int fileSize;
	int count;
	RandomAccessFile file;

	System.out.println("Please enter filename");
	fileName.copyFrom(STDIN_SCANNER.nextLine());


	try {
		file = new RandomAccessFile(fileName.toString(), "r"); // read mode
	} catch(IOException ex) {
		file = null;
		ex.printStackTrace();
		System.exit(EXIT_FAILURE);
	}


	do {
		System.out.println("Please enter size of file in Bytes, example for 32 bytes enter 32");
		fileSize = getNumber();
	} while(fileSize < 1);

	String fileData_U = new String8(fileSize);
	byte[] wbuff_U = new byte[256];
	byte[] exbuff_U = new byte[256];
	count = 0;

	while((ch = (byte)file.read()) != EOF && count < fileSize) {
		fileData_U.set(count, ch);
		// printf("%d",count);
		count++;
	}
	System.out.println("Clear Text: " + fileData_U);

	Arrays.fill(wbuff_U, (byte)0);
	Arrays.fill(exbuff_U, (byte)0);
	randSeed(rndSeed, (long)rndSeed.size());
	System.out.print(count);
}

public final static Scanner STDIN_SCANNER = new Scanner(System.in);*/