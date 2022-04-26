package week2.day1;

public class ReverseEvenPositionedWords {

	public static void main(String[] args) {

		String test = " I am a software Tester";

		String[] splitwords = test.split(" ");

		for (int i = 0; i < splitwords.length; i++) {
			if (i % 2 == 0)
				splitwords[i] = String.valueOf(Palindrome.reverseString(splitwords[i]));
			System.out.print(splitwords[i] + " ");
		}

	}

}
