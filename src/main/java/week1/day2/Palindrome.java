package week1.day2;

public class Palindrome {

	public static void main(String[] args) {

		String input = "madam";

		char[] reverse = reverseString(input);
		
		if( input.equals(String.valueOf(reverse)))
				System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");
			

	}

	static char[] reverseString(String input) {
		char[] reverse = new char[input.length()];

		for (int i = input.length() - 1, j = 0; i >= 0; i--, j++)

			reverse[j] = input.charAt(i);
		return reverse;
	}

}
