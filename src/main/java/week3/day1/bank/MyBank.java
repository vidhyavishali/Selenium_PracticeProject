package week3.day1.bank;

public class MyBank {

	public static void main(String[] args) {

		BankInfo b = new AxisBank();
		b.savings();
		b.fixed();
		/**
		 * takes overridden 3 % from its child class, though bank info object is used.
		 */
		b.deposit();
	}

}
