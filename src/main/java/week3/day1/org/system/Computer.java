package week3.day1.org.system;

public class Computer {

	String computerModel = "Super N5010";

	public void computerModel() {
		System.out.println(this.getClass().getSimpleName() + "- Model is " + getComputerModel());
	}
	
	public String getComputerModel()
	{
		return computerModel;
	}
}
