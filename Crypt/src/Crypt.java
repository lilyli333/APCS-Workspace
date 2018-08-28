import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms:
 * 		Random monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author
 * @version
 * 
 */
public class Crypt {

	public static final  String lineSeparator = System.getProperty ("line.separator");

	/**
	 * 
	 * An integer representing the algorithm chosen.
	 * Set to:
	 * 1 for random monoalphabet
	 * 2 for Vigenere
	 * 3 for Playfair
	 * 
	 */
	public static final int algorithm = 2;


	/**
	 * Reads from the file specified, and writes out an encrypted version of the file. If the output file already
	 * exists, overwrite it.
	 * 
	 * @param inputFilename The path of the file to be encrypted.
	 * @param outputFilename The path of the encrypted file to be saved.
	 * @param keyword The keyword to be used in the encryption algorithm.
	 * 
	 */
	public static void encrypt(String inputFilename, String outputFilename, String keyword) 
	{
		Scanner scan = null;
		FileWriter writer = null;
		BufferedWriter bWriter = null;

		try {
			FileReader reader = new FileReader(inputFilename);
			BufferedReader bReader = new BufferedReader(reader);
			scan = new Scanner(bReader);

			writer = new FileWriter(outputFilename);
			bWriter = new BufferedWriter(writer);

			int offset = 0;
			int encryptChar;
			StringBuffer line;
			int index = 0;

			while(scan.hasNextLine()) {
				line = new StringBuffer(scan.nextLine());
				Character currentChar;

				for(int i = 0; i < line.length(); i ++) {
					currentChar = line.charAt(i);

					if(!Character.isLetter(currentChar)) {
						bWriter.write(currentChar);
					}
					else {
						offset = (int)keyword.charAt((int)(index % (keyword.length()))) - 97;
						encryptChar = currentChar + offset;
						index ++;
						if(encryptChar > 122) {
							bWriter.write((char)(97 + (encryptChar - 123)));
						}
						else if(encryptChar > 90 && currentChar <= 90) {
							bWriter.write((char)(65 + (encryptChar - 91)));
						}
						else 
							bWriter.write((char)(encryptChar));
					}
				}
				if(index > 1000 && index % keyword.length() == 0)
					index = 0;
				bWriter.write(lineSeparator);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			if(scan != null)
				scan.close();
			try {
				if(bWriter != null)
					bWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}

		}
	}


	/**
	 * Reads from the (previously encrypted) file specified, and writes out a decrypted version of the file. 
	 * If the output file already exists, overwrite it.
	 * 
	 * @param inputFilename The path of the encrypted file.
	 * @param outputFilename The path of the decrypted file to be saved.
	 * @param keyword The keyword to be used in the decryption algorithm.
	 * 
	 */
	public void decrypt(String inputFilename, String outputFilename, String keyword) 
	{
		Scanner scan = null;
		FileWriter writer = null;
		BufferedWriter bWriter = null;

		try {
			FileReader reader = new FileReader(inputFilename);
			BufferedReader bReader = new BufferedReader(reader);
			scan = new Scanner(bReader);

			writer = new FileWriter(outputFilename);
			bWriter = new BufferedWriter(writer);

			int offset = 0;
			int decryptChar;
			StringBuffer line;
			int index = 0;

			while(scan.hasNextLine()) {
				line = new StringBuffer(scan.nextLine());
				Character currentChar;

				for(int i = 0; i < line.length(); i ++) {
					currentChar = line.charAt(i);

					if(!Character.isLetter(currentChar)) {
						bWriter.write(currentChar);
					}
					else {
						offset = (int)keyword.charAt((int)(index % (keyword.length()))) - 97;
						decryptChar = currentChar - offset;
						index ++;
						if(decryptChar < 65) {
							bWriter.write((char)(90 - (offset - (currentChar - 64))));
						}
						else if(currentChar >= 97  && decryptChar < 97) {
							bWriter.write((char)(122 - (offset - (currentChar - 96))));
						}
						else
							bWriter.write((char)decryptChar);
					}
				}
				if(index > 1000 && index % keyword.length() == 0)
					index = 0;
				bWriter.write(lineSeparator);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			if(scan != null)
				scan.close();
			try {
				if(bWriter != null)
					bWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	//TESTING PURPOSES BELOW

	public static void main(String[] args){
		String str = "HELLO!";
		String s = str.substring(4,5);
		System.out.println("s is:" + s);
	}
//		//		System.out.println(91-65);
//		String keyword = "crypt";
//		StringBuffer input = new StringBuffer("CTR X; ITFJDZWV Rlh jfshxjfjsl, dfrw tnzit bp ugvgkkw,");
//		//		String noWhite = input.replaceAll(" ", "").replaceAll("[^a-zA-Z ]", "");
//		//		String noWhite = input;
//		//		System.out.println(keyword.length());
//
//		int index = 0;
//		int offset = 0;
//		int decryptChar;
//		Character currentChar;
//		//DECRYPT
//		for(int i = 0; i < input.length(); i ++) {
//			currentChar = input.charAt(i);
//
//			if(!Character.isLetter(currentChar)) {
//				System.out.print(currentChar);
//			}
//			else {
//				offset = (int)keyword.charAt((int)(index % (keyword.length()))) - 97;
//				decryptChar = currentChar - offset;
//				//				System.out.println(offset);
//				if(decryptChar < 65) {
//					//					System.out.print("-");
//					//					System.out.print(decryptChar);
//					System.out.print((char)(90 - (offset - (currentChar - 64))));
//				}
//				else if(currentChar >= 97  && decryptChar < 97) {
//					//					System.out.print("*");
//					System.out.print((char)(122 - (offset - (currentChar - 96))));
//				}
//				else
//					System.out.print((char)decryptChar);
//				//				
//				//				else 
//				//				System.out.print((char)(decryptChar));
//
//				index++;
//
//			}
//
//		}
//
//
//		/* ENCRYPTION CHECK
//		int offset = 0;
//		Character currentChar;
//		int notLetter = 0;
//
//		//encrypt line
//		for(int i = 0; i < input.length(); i ++) {
//			//					System.out.print(keyword.charAt((int)(i % keyword.length())));
//			currentChar = input.charAt(i);
//
//			if(!Character.isLetter(currentChar)) {
//				System.out.print(currentChar);
//				input.deleteCharAt(i);
//				i--;
//			}
//			else {
//
//				//			if(Character.isLetter(currentChar)) {
//				offset = (int)keyword.charAt((int)(i% (keyword.length()))) - 97;
//				int encryptChar = currentChar + offset;
//
//				//				System.out.println("**" + (i% (keyword.length() )));
//				if(encryptChar > 122) {
//					System.out.print((char)(97 + (encryptChar - 123)));
//				}
//				else if(currentChar < 90 && encryptChar > 90) {
//					System.out.print((char)(65 + (encryptChar - 91)));
//				}
//				else
//					System.out.print((char)(encryptChar));
//				//			}	
//				//			else
//				//				System.out.print(currentChar);
//			}
//		}
//		 */
//	}
}