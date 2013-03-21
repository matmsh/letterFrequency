package net.sf.frequency;

import java.util.ArrayList;
import java.util.List;

public class LetterSplitter {

	/**
	 * 
	 * @param word
	 * @return A list of letters in word. Any Capital letter is converted to lower case. 
	 */
	public List<String> split(String word) {
		List<String> letters = new ArrayList<String>();

		for (int i = 0; i < word.length(); ++i) {
			char character = word.charAt(i);
			if (isLetter(character)) {
				String letter = new String(new char[] { character })
						.toLowerCase();
				letters.add(letter);
			}
		}
		return letters;
	}

	private boolean isLetter(char character) {
		return (65 <= character && character <= 90)
				|| (97 <= character && character <= 122);
	}
}
