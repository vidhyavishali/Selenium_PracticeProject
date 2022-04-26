package week2.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String s1 = "stops";
		String s2 = "pots";

		/**
		 * 2 Strings are said to be anagram to each other, when they have same
		 * characters with its ordered same or jumbled.
		 */
		System.out.print("The two given strings are");
		if (s1.length() == s2.length()) {

			char[] s1Char = s1.toCharArray();
			char[] s2Char = s2.toCharArray();
			Arrays.sort(s1Char);
			Arrays.sort(s2Char);

			if (Arrays.equals(s1Char, s2Char))
				System.out.println(" Anagrams");
			else
				System.out.println(" Not Anagrams");
		} else
			System.out.println(" Not Anagrams");
	}
}
