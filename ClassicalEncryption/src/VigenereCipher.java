import java.util.Scanner;


public class VigenereCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		// Declare new scanner for input
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		// Thankfully, we are allowed to reject all incorrect input
		if ( ! (response.equals("encode") || response.equals("decode"))) {
			System.out.println("Invalid option indicated." + "    "  + response + "  " + response.length());
			System.exit(1);
		}
		
		System.out.print("Enter the string to " + response + ": ");
		String text = in.nextLine();
		
		System.out.print("Enter the key: ");
		String key = in.nextLine();
		in.close();
		
		// If they have no key, we just print output back
		// This is faster than sending input to our cipher with key 'a'
		if (key.equals("")) {
			System.out.println(text);
			System.exit(0);
		}
		
		VigenereCipher(text, key, response);
	}

	private static void VigenereCipher(String text, String key, String flag) {
		// To encode we add the key, to decode we subtract it. This transposer
		// makes it so we just add the key*transposer, which is either 1 or -1
		// depending on encode/decode.
		int transposer;
		if (flag.equals("encode")) {
			transposer = 1;
		} else {
			transposer = -1;
		}
		
		// We want to access individual characters, so we need char arrays
		char[] keyArray = key.toCharArray();
		char[] textArray = text.toCharArray();
		int base = (int) 'a';
		
		for (int i = 0; i < text.length(); i++) {
			// Turn letter from text and corresponding letter from key into
			// ints between 0 and 25
			int keyInt = keyArray[i % keyArray.length] - base;
			int textInt = textArray[i] - base;
			
			int shiftedChar = (textInt + (transposer * keyInt));
			// If our shift drops below 0, we need to bring it back above 0
			if (shiftedChar < 0) {
				shiftedChar += 26;
			}
			// If it gets above 25, we need to bring it back down under
			// Then add base to get the actual character code
			textArray[i] = (char) ((shiftedChar % 26) + base);
		}
		// Since we've been changing textArray in place, we can just print
		// the full thing (as a string) here.
		System.out.println(new String(textArray));
	}

}
