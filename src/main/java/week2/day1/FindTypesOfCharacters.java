package week2.day1;

public class FindTypesOfCharacters {

	public static void main(String[] args) {
		String test = "$$ Welcome to 2nd Class of Automation $$ ";

		int letter = 0, space = 0, num = 0, specialChar = 0;

		char[] testChar = test.toCharArray();

		for (char c : testChar) {

			if (Character.isLetter(c))
				letter++;
			else if (Character.isSpaceChar(c))
				space++;
			else if (Character.isDigit(c))
				num = 0;
			else
				specialChar++;
		}

		System.out.println("The given Sentence has ");
		System.out.print(" Letters : " + letter + "\n Spaces : " + space + "\n Digits : " + num
				+ "\n Special Characters : " + specialChar);
	}

}
