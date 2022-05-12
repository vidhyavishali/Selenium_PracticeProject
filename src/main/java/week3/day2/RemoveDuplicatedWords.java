package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicatedWords {

	public static void main(String[] args) {

		String text = "We learn java basics as part of java sessions in java week1";
		String[] split = text.split(" ");
		System.out.println("Duplicated words...");
		List<String> asList = new ArrayList<String>(Arrays.asList(split));
		for (int i = 0; i < asList.size(); i++) {
			String currentWord = asList.get(i);
			int count = 0;

			for (int j = 0; j < asList.size(); j++) {
				String compareWord = asList.get(j);

				if (currentWord.equals(compareWord) && i != j)
					count++;

			}
			if (count > 0) {
				System.out.println(currentWord);
				asList.removeIf(e -> e.contentEquals(currentWord));
			}
		}
		System.out.println("are removed..");
		System.out.println(asList.toString());
	}

}
