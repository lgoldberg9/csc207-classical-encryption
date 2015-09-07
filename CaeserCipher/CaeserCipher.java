import java.util.Scanner;

public class CaeserCipher {

	public static void main(String[] args) {
		// Main handles all input
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		if ( ! (response.equals("encode") || response.equals("decode"))) {
			System.out.println("Invalid option indicated." + "    "  + response + "  " + response.length());
			System.exit(1);
		}
		
		System.out.print("Enter the string to " + response + ": ");
		
		String text = in.nextLine();
		in.close();
		
		cipher(text, response);
	}
	
	/* Description
	 * Main Caesar cipher program. Takes text and flag (for encode/decode) and
	 * prints out all 26 encodes/decodes.
	 */
	public static void cipher(String text, String flag) {
		// Allows us to add or subtract a number in the same line. We set
		// transposer to 1 if encode, -1 if decode, then our code adds the
		// offset * transposer (so the offset is negative if we need to decode)
		int transposer;
		if (flag.equals("encode")) {
			transposer = 1;
		} else {
			transposer = -1;
		} 
		
		char[] textArray = text.toCharArray();
		for (int shift = 0; shift < 26; shift++) {
			String shiftedText = new String(textArray);
			System.out.println("n = " + shift + ": " + shiftedText);
			ShiftText(textArray, transposer);
		}
		
	}

	/* Description
	 * This function takes a char array, and shifts it by transposer * 1 (so
	 * either 1 or -1). This function is called 26 times on the same array.
	 * Note it has no output because it changes the array in memory.
	 */
	private static void ShiftText(char[] text, int transposer) {
		int base = (int) 'a';
		for (int i = 0; i < text.length; i++) {
			int shiftedLetter = ((int) text[i] - base) + transposer * 1;
			if (shiftedLetter < 0) {
				shiftedLetter += 26;
			}
			text[i] = (char) ((shiftedLetter % 26) + base);
		}
	}

}
