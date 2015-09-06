import java.util.Scanner;


public class VigenereCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		if ( ! (response.equals("encode") || response.equals("decode"))) {
			System.out.println("Invalid option indicated." + "    "  + response + "  " + response.length());
			System.exit(1);
		}
		
		System.out.print("Enter the string to " + response + ": ");
		String text = in.nextLine();
		
		System.out.print("Enter the key: ");
		String key = in.nextLine();
		in.close();
		
		if (key.equals("")) {
			System.out.println(text);
			System.exit(0);
		}
		
		VigenereCipher(text, key, response);
	}

	private static void VigenereCipher(String text, String key, String flag) {
		int transposer;
		if (flag.equals("encode")) {
			transposer = 1;
		} else {
			transposer = -1;
		}
		
		int base = (int) 'a';
		char[] keyArray = key.toCharArray();
		char[] textArray = text.toCharArray();
		
		for (int i = 0; i < text.length(); i++) {
			int keyInt = keyArray[i % keyArray.length] - base;
			int textInt = textArray[i] - base;
			
			int shiftedChar = (textInt + (transposer * keyInt));
			if (shiftedChar < 0) {
				shiftedChar += 26;
			}
			textArray[i] = (char) ((shiftedChar % 26) + base);
		}
		System.out.println(new String(textArray));
	}

}
