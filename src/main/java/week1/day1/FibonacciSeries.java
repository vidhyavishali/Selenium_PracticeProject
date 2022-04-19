package week1.day1;

public class FibonacciSeries {

	/*
	 * Learnings 1. FOR loop and loop indexing 2. Variables inside a method can only
	 * be final. No access specifiers are allowed . Scope is always local to the
	 * method
	 *  3. scope of loop variable i is only inside the loop
	 */

	public static void main(String[] args) {
		int firstNum = 0;
		int secNum = 1;
		int range = 8;
		int sum = 0;
		System.out.println("fibonacci series upto range :" + range);

		/*
		 * Fibonacci series is a series, where the nth number is a sum of numbers at n-1
		 * and n-2.
		 */

		System.out.print(firstNum + "\t" + secNum);
		for (int i = 2; i < range; i++) {
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
			System.out.print("\t" + sum);
		}

	}

}
