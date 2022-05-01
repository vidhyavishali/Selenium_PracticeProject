package week3.day1.org.system;

public class Desktop extends Computer {

	String computerModel = "Sub N5010";

	public void desktopSize() {
		System.out.println("Size of " + this.computerModel + " is 16 inches");
	}

	public String getComputerModel() {
		return computerModel;
	}
}
