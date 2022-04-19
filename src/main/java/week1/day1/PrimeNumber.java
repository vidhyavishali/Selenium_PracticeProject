package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {

		int input = 41;
		boolean flag = false;

		/**
		 * Prime number is a number whose factors are the 1 and the number itself. It is
		 * not divisble by any other number. To do that optimally, we check we iterate
		 * upto half of the number and check whether the given number is divisible by
		 * any of the iterated number. 
		 */
		for (int i = 2; i < input / 2; i++)
			if (input % i == 0)
				flag = true;
		System.out.print(input + " is");
		if (flag)
			System.out.print(" NOT ");
		System.out.println(" a prime number");
	}

}
