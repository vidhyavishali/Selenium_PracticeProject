package week3.day1.org.automate;

public class Automation implements Language, TestTool {

	String tool = "selenium";
	String lang = "java";

	@Override
	public void Selenium() {
		System.out.println(" Using tool :" + this.tool);
		System.out.println(" But default tool is :" + getDefaultToolName());

	}

	@Override
	public void Java() {
		System.out.println(" Using Language :" + this.lang);
		System.out.println(" But Specified language is :" + getDefaultLanguge());

	}

}
