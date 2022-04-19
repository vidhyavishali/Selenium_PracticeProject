package week1.day1;

public class Factorial {
	/**
	 * Learnings : For loop variable iterating part can have more than one
	 * statement.
	 */

	public static void main(String[] args) {

		int input = 5;
		int factorial = 1;
		int i;
		for (i = input; i > 0; i--)
			factorial = factorial * i;
		System.out.println(" The factorial of " + input + " is :" + factorial);

		/* One more try */
		for (i = input - 1; i > 0; input *= i, i--)
			;
		System.out.println(" The factorial of given input is :" + input);
	}

}
