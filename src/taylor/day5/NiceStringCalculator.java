package taylor.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Taylor Moon
 */
public class NiceStringCalculator {
	
	/**
	 * If we use the new model instead of the old model.
	 */
	public static final boolean NEW_RULES = true;
	
	/**
	 * A character array of capital and lower-case vowels.
	 */
	public static final char[] VOWELS = "AEIOUaeiou".toCharArray();
	
	/**
	 * An array of words or character sequences that aren't allowed.
	 */
	public static final String[] PERMITTED_WORDS = { "ab", "cd", "pq", "xy" };
	
	/**
	 * The main method.
	 * @param args The arguments casted on runtime.
	 */
	public static void main(String[] args) throws IOException {
		int niceStrings = 0;
		BufferedReader reader = new BufferedReader(new FileReader("data/nicestringdata.txt"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (isNiceString(line, NEW_RULES)) {
				niceStrings++;
			}
		}
		System.out.println(niceStrings + " total 'nice' strings.");
		reader.close();
	}

	/**
	 * Checks if a given string is 'nice'.
	 * @param string The string to check.
	 * @param newRules If we are using the new model for calculating.
	 * @return True if so; false otherwise.
	 */
	public static boolean isNiceString(String string, boolean newRules) {
		return newRules ? hasRepeatingLetterSeperated(string) && hasSequentialPairedLetter(string) : !hasPermittedCharacters(string) && hasSequentialRepeatingLetter(string) && hasThreeVowels(string);
	}
	
	/**
	 * Checks if the string has permitted characters based on the {@code PERMITTED_WORDS} array.
	 * @param string The string to check for permitted characters.
	 * @return True if so; false otherwise.
	 */
	public static boolean hasPermittedCharacters(String string) {
		for (String permittedWord : PERMITTED_WORDS) {
			if (string.contains(permittedWord)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns if the given string contains 2 of the same letters repeating sequentially.
	 * @param string The string to check.
	 * @return True if so; false otherwise.
	 */
	public static boolean hasSequentialPairedLetter(String string) {
		char[] characters = string.toCharArray();
		try {
			for (int charIndex = 0; charIndex < characters.length; charIndex++) {
				String twoLetters = string.substring(charIndex, charIndex + 2).toLowerCase();
				if(string.substring(charIndex + 2, string.length()).contains(twoLetters)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * Returns if the given string has a single letter being repeating; yet is also seperated by another character.
	 * @param string
	 * @return
	 */
	public static boolean hasRepeatingLetterSeperated(String string) {
		char[] characters = string.toCharArray();
		try {
			for (int charIndex = 0; charIndex < characters.length; charIndex++) {
				String threeLetters = string.substring(charIndex, charIndex + 3).toLowerCase();
				if (threeLetters.charAt(0) == threeLetters.charAt(2)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Checks if the string has any given letter repeat itself at least once.
	 * @param string The string to check for repeating letters.
	 * @return True if so; false otherwise.
	 */
	public static boolean hasSequentialRepeatingLetter(String string) {
		char[] characters = string.toCharArray();
		try {
			for (int charIndex = 0; charIndex < characters.length; charIndex++) {
				if (string.charAt(charIndex) == string.charAt(charIndex + 1)) {
					return true;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}

	/**
	 * Checks if the string has at least 3 vowels.
	 * @param string The string to check for vowels for.
	 * @return True if so; false otherwise.
	 */
	public static boolean hasThreeVowels(String string) {
		int vowels = 0;
		for (char character : string.toCharArray()) {
			for (int vowel = 0; vowel < VOWELS.length; vowel++) {
				if (character == VOWELS[vowel]) {
					vowels++;
					if (vowels >= 3) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
