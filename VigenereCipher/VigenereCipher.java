import java.util.Scanner;


public class VigenereCipher {

	public static void main(String[] args) {
		// Main handles all input
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
		
		cipher(text, key, response);
	}

	/* Description
	 * Main VigenereCipher program. Takes text, a key, and a flag for encode
	 * or decode, then prints out the text encoded/decoded relative to that 
	 * key.
	 */
	public static void cipher(String text, String key, String flag) {
		// Allows us to add or subtract a number in the same line. We set
		// transposer to 1 if encode, -1 if decode, then our code adds the
		// offset * transposer (so the offset is negative if we need to decode)
		int transposer;
		if (flag.equals("encode")) {
			transposer = 1;
		} else {
			transposer = -1;
		}
		
		char[] keyArray = key.toCharArray();
		char[] textArray = text.toCharArray();
		
		for (int i = 0; i < text.length(); i++) {
			char textChar = textArray[i];
			char keyChar = keyArray[i % keyArray.length];
			textArray[i] = shiftChar(textChar, keyChar, transposer);
		}
		System.out.println(new String(textArray));
	}
	
	/* Description
	 * Helper function to shift a letter by another letter. Takes a character
	 * to be shifted, a character to shift by, and a multiplier to determine
	 * if we shift up or down. Returns a shifted char.
	 */
	private static char shiftChar(char ch, char key, int transposer) {
		int base = (int) 'a';
		int chInt = ch - base;
		int keyInt = key - base;
		
		int shiftedChar = (chInt + (transposer * keyInt));
		if (shiftedChar < 0) {
			shiftedChar += 26;
		}
		return (char) ((shiftedChar % 26) + base);
	}

}
