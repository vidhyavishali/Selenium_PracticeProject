package week1.day1;

public class ArmstrongNumber {

	public static void main(String[] args) {

		int input = 154;

		int remainder, original;

		original = input;
		int sum = 0;

		while (input > 0) {

			remainder = input % 10; // 3
			sum += remainder * remainder * remainder;// 3 cube
			input = input / 10; // 15

		}

		if (sum == original)
			System.out.println(" Given number " + original + "is an armstrong number");
		else
			System.out.println(original + " is not an armstrong number");
	}
}
