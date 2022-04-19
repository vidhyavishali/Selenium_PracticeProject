package week1.day1;

public class NegativeToPositive {

	public static void main(String[] args) {
		int input = -50;
		System.out.print(" The number " + input + " is ");
		if (input < 0)

			System.out.println("negative and it is converted to " + Math.abs(input));
		else if (input > 0)
			System.out.println(" positive");
		else
			System.out.println(" neither positive nor negative");
	}

}
