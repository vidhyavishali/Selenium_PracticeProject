package week1.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {

		String test = "Changeme";

		char[] testChar = test.toCharArray();

		System.out.println("The original String is:" + test);

		for (int i = 0; i < testChar.length; i++) {
			if (i % 2 != 0)
				if (Character.isLowerCase(testChar[i])) {
					testChar[i] = Character.toUpperCase(testChar[i]);
				}

		}

		System.out.println("The Converted string is:" + String.valueOf(testChar));
	}
}
