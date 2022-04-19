package week1.day2;

import java.util.Scanner;

public class MyCalculator {

	public static void main(String[] args) {
		int num1;
		int num2;
		int num3;
		Calculator calc = new Calculator();
		System.out.println("Enter 3 numbers :");
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();

		System.out.println("Addition :" + calc.add(num1, num2, num3));
		System.out.println("Subtraction :" + calc.sub(num1, num2));
		System.out.println("Multiply :"+ calc.multiply(num1, num2));
		System.out.println("DIvide :"+ calc.divide(num1, num2));

	}
}
