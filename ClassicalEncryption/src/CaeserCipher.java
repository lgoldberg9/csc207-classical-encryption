import java.util.Scanner;

public class CaeserCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		CaesarCipher(text, response);
	}
	
	
	public static void CaesarCipher(String text, String flag) {
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
