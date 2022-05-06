package week3.day1.org.automate;

public interface Language {

	public String lang = "Python";

	public void Java();

	default public String getDefaultLanguge() {
		return lang;
	}
}
