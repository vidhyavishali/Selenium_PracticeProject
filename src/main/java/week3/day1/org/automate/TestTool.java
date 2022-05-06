package week3.day1.org.automate;

public interface TestTool {

	String tool = "QFT";

	void Selenium();

	default public String getDefaultToolName() {
		return tool;
	}

}
