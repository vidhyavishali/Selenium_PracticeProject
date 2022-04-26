package week2.day1;

public class CharOccurance {

	public static void main(String[] args) {
		String str = "Welcome to Chennai";

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'e')
				count++;
		}

		System.out.println("Number of e's in given string " + str + " is :" + count);

	}
}
